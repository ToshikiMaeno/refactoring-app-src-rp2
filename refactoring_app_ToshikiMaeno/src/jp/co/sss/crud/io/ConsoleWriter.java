package jp.co.sss.crud.io;

import static jp.co.sss.crud.util.ConstantMsg.*;

import java.util.List;

import jp.co.sss.crud.dto.Employee;

public class ConsoleWriter {
	
	public static void showHeader() {
		System.out.println(HEADER);
	}
	
	public static void showNonExistTarget() {
		System.out.println(MSG_NON_EXIST_TARGET);
	}
	
	public static void showMenu() {
		System.out.print(MENU_MESSAGE_ALL_DISPLAY);
	}
	
	public static void showEmployees(List<Employee> employees) {
		if (employees.isEmpty()) {
			showNonExistTarget();
		} else {
			showHeader();
			for (Employee employee : employees) {
				
				//System.out.print(employee.getEmpId()+ "\t");
				//System.out.print(employee.getEmpName()+ "\t");
				//int gender = employee.getGender();
				
				//if (gender == 0) {
				//	System.out.print("回答なし" + "\t");
				//} else if (gender == 1) {
				//	System.out.print("男性" + "\t");

				//} else if (gender == 2) {
				//	System.out.print("女性" + "\t");

				//} else if (gender == 9) {
				//	System.out.print("その他" + "\t");

				//}
				//System.out.print(employee.getBirthday()+ "\t");
				//System.out.println(employee.getDepartment().getDeptName());
				
				
				
				
				
				System.out.print(employee.toString());
				
				
			}
		}
	}
}
