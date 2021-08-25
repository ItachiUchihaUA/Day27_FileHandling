package day27_pp1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class EmployeeSystem {

	public static void main(String[] args) throws Exception  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		EmployeePayroll e = new EmployeePayroll();
		System.out.println("Enter Details: ");
		e.id = Integer.parseInt(br.readLine());
		e.name = (br.readLine());
		e.salary = Integer.parseInt(br.readLine());
		
		System.out.println(e.toString());
		
		Path p = Paths.get("C:\\Users\\TheUA\\eclipse-workspace\\com.bridge.week3\\src\\day27_pp1\\textDemo.txt");
		Path d = Paths.get("C:\\Users\\TheUA\\eclipse-workspace\\com.bridge.week3\\src\\day27_pp1\\NewD");
		System.out.println("File Exists: "+Files.exists(p));
		Files.createFile(p );
		Files.deleteIfExists(p);
		Files.createDirectories(d);
		Files.createFile(p );
		Files.walk(Paths.get("C:\\Users\\TheUA\\eclipse-workspace\\com.bridge.week3\\src\\day27_pp1")).filter(Files::isRegularFile).forEach(System.out::println);
	}

}
