package day27_pp1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class EmployeeSystem {

	public static void main(String[] args) throws Exception  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		EmployeePayroll e = new EmployeePayroll();
		e.id = Integer.parseInt(br.readLine());
		e.name = (br.readLine());
		e.salary = Integer.parseInt(br.readLine());
		
		System.out.println(e.toString());
	}

}
