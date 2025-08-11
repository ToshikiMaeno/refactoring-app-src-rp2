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
	
	public static void showHeadingEmployeeName() {
		System.out.print(MENU_MESSAGE_EMPLOYEE_NAME);
	}
	
	public static void showHeadingDepartment() {
		System.out.print(MENU_MESSAGE_DEPTID);
	}
	
	public static void showHeadingEmployeeGender() {
		System.out.print(MENU_MESSAGE_GENERAL);
	}

	public static void showHeadingEmployeeBirthday() {
		System.out.print(MENU_MESSAGE_BIRTHDAY);
	}
	
	public static void showHeadingEmpId() {
		System.out.print(MSG_EMP_ID);
	}
	
	public static void showCompleteUpdate(Integer exeCount) {

		if (exeCount >= 1) {
			System.out.println(MENU_MESSAGE_EMPLOYEE_INFORMATION_UPDATE);

		} else {
			ConsoleWriter.showNonExistTarget();
		}

	}
	
	public static void showCompleteDelete(Integer exeCount) {

		if (exeCount >= 1) {
			System.out.println(MENU_MESSAGE_EMPLOYEE_INFORMATION_DELETE);

		} else {
			ConsoleWriter.showNonExistTarget();
		}

	}
	
	public static void showEmployees(List<Employee> employees) {
		if (employees.isEmpty()) {
			showNonExistTarget();
		} else {
			showHeader();
			for (Employee employee : employees) {
				System.out.print(employee.toString());
			}
		}
	}
}
