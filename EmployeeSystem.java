package day27_pp1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class EmployeeSystem {
	static int count = 0;

	public static void main(String[] args) throws Exception {

//		Path p = Paths.get("src\\day27_pp1\\textDemo.txt");
//		Files.deleteIfExists(p);
//		add();
//		add();
//		Path d = Paths.get("src\\day27_pp1\\NewD");
//		System.out.println("File Exists: " + Files.exists(p));
//		Files.createFile(p);
//		Files.createDirectories(d);
//		Files.createFile(p);
		Files.walk(Paths.get("C:\\Users\\TheUA\\eclipse-workspace\\com.bridge.week3\\src\\day27_pp1"))
				.filter(Files::isRegularFile).forEach(System.out::println);

	}

	public static void add() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		EmployeePayroll e = new EmployeePayroll();
		System.out.println("Enter Details: ");
		e.id = Integer.parseInt(br.readLine());
		e.name = (br.readLine());
		e.salary = Integer.parseInt(br.readLine());
		System.out.println(e.toString());
		if (Files.exists(Paths.get("src\\day27_pp1\\textDemo.txt"))) {
			Files.write(Paths.get("src\\day27_pp1\\textDemo.txt"), e.toString().getBytes(), StandardOpenOption.APPEND);
		} else {
			Files.createFile(Paths.get("src\\day27_pp1\\textDemo.txt"));
			Files.write(Paths.get("src\\day27_pp1\\textDemo.txt"), e.toString().getBytes(), StandardOpenOption.APPEND);
		}
		count++;

	}
}
