package jp.co.sss.crud.service;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;

import jp.co.sss.crud.db.EmployeeDAO;
import jp.co.sss.crud.dto.Department;
import jp.co.sss.crud.dto.Employee;
import jp.co.sss.crud.exception.IllegalInputException;
import jp.co.sss.crud.exception.SystemErrorException;
import jp.co.sss.crud.io.ConsoleWriter;
import jp.co.sss.crud.io.EmployeeBirthdayReader;
import jp.co.sss.crud.io.EmployeeDeptIdReader;
import jp.co.sss.crud.io.EmployeeGenderReader;
import jp.co.sss.crud.io.EmployeeNameReader;

public class EmployeeRegisterService implements IEmployeeService {
	
	private EmployeeDAO employeeDAO;
	
	
	public void execute() throws SystemErrorException, IllegalInputException, ClassNotFoundException, SQLException, IOException, ParseException {
		ConsoleWriter.showHeadingEmployeeName();
		String name = (String) new EmployeeNameReader().input();

		ConsoleWriter.showHeadingEmployeeGender();
		Integer gender = (Integer) new EmployeeGenderReader().input();

		ConsoleWriter.showHeadingEmployeeBirthday();
		String birthday = (String) new EmployeeBirthdayReader().input();

		ConsoleWriter.showHeadingDepartment();
		Integer deptId = (Integer) new EmployeeDeptIdReader().input();
		
		Employee employee = new Employee();
		employee.setEmpName(name);
		employee.setGender(gender);
		employee.setBirthday(birthday);

		Department department = new Department();
		department.setDeptId(deptId);
		employee.setDepartment(department);
		
		employeeDAO = new EmployeeDAO();
		employeeDAO.insert(employee);
	}
	
	
	
}