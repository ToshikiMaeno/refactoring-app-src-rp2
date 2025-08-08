package jp.co.sss.crud.io;

import java.util.List;

import jp.co.sss.crud.dto.Employee;

public class ConsoleWriter {
	public static void showEmployees(List<Employee> employees) {
		if (employees.isEmpty()) {
			//showNonExistTarget();
		} else {
			//showHeader();
			
			
			System.out.println("社員ID\t社員名\t性別\t生年月日\t部署名");
			for (Employee employee : employees) {
				
				//System.out.println(employee);
				//Department department = new Department();
				System.out.print(employee.getEmpId()+ "\t");
				
				System.out.print(employee.getEmpName()+ "\t");
				
				//System.out.print(employee.getGender()+ "\t");
				int gender = employee.getGender();
				if (gender == 0) {
					System.out.print("回答なし" + "\t");
				} else if (gender == 1) {
					System.out.print("男性" + "\t");

				} else if (gender == 2) {
					System.out.print("女性" + "\t");

				} else if (gender == 9) {
					System.out.print("その他" + "\t");

				}
				
				System.out.print(employee.getBirthday()+ "\t");
				
				//System.out.println(department.getDeptName());
				System.out.println(employee.getDepartment().getDeptName());
				
				
				
				
				
				
				
				
			}
		}
	}
}
