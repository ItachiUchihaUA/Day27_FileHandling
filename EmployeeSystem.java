package day27_pp1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class EmployeeSystem {
	static long count = 0;

	public static void main(String[] args) throws Exception {

		Path p = Paths.get("src\\day27_pp1\\textDemo.txt");
		add();
		add();
		show();
		List<EmployeePayroll> t = ojbectFromFile();
		System.out.println(t);
		Path d = Paths.get("src\\day27_pp1\\NewD");
		System.out.println("File Exists: " + Files.exists(p));
		Files.createDirectories(d);
		Files.createFile(p);
		Files.walk(Paths.get("C:\\Users\\TheUA\\eclipse-workspace\\com.bridge.week3\\src\\day27_pp1"))
				.filter(Files::isRegularFile).forEach(System.out::println);

	}

	public static void add() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		EmployeePayroll e = new EmployeePayroll();
		System.out.println("Enter Details: ");
		System.out.println("ID: ");
		e.id = Integer.parseInt(br.readLine());
		System.out.println("Name: ");
		e.name = (br.readLine());
		System.out.println("Salary: ");
		e.salary = Integer.parseInt(br.readLine());
		System.out.println(e.toString());
		if (Files.exists(Paths.get("src\\day27_pp1\\textDemo.txt"))) {
			Files.write(Paths.get("src\\day27_pp1\\textDemo.txt"), e.toString().getBytes(), StandardOpenOption.APPEND);
		} else {
			Files.createFile(Paths.get("src\\day27_pp1\\textDemo.txt"));
			Files.write(Paths.get("src\\day27_pp1\\textDemo.txt"), "id, name, salary\n".getBytes());
			Files.write(Paths.get("src\\day27_pp1\\textDemo.txt"), (e.toString() + "\n").getBytes(),
					StandardOpenOption.APPEND);
		}
		count++;

	}

	public static void show() throws Exception {
		List<String> list = Files.readAllLines(Paths.get("src\\day27_pp1\\textDemo.txt"));
		list.stream().forEach(System.out::println);
		System.out.println("Count : " + list.stream().count());
	}

	public static List<EmployeePayroll> ojbectFromFile() throws Exception {
		List<String> list = Files.readAllLines(Paths.get("src\\day27_pp1\\textDemo.txt"));
		List<EmployeePayroll> newList = new ArrayList<>();
		for (int i = 1; i < list.size(); i++) {
			//", " is the gap!
			String[] line = list.get(i).split(", ");
			EmployeePayroll e = new EmployeePayroll();
			for (int j = 0; j < line.length; j++) {
				e.id = Integer.parseInt(line[0]);
				e.name = line[1];
				e.salary = Integer.parseInt(line[2]);
			}
			newList.add(e);
		}
		return newList;
	}
}
