package jp.co.sss.crud.io;

import java.util.List;

import jp.co.sss.crud.dto.Employee;

public class ConsoleWriter {
	public static void showEmployees(List<Employee> employees) {
		if (employees.isEmpty()) {
			//showNonExistTarget();
		} else {
			//showHeader();
			for (Employee employee : employees) {
				//System.out.println(employee);
				System.out.println(employee.getEmpName());
			}
		}
	}
}
