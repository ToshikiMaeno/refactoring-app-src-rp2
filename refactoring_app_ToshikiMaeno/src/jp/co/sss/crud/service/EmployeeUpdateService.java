package jp.co.sss.crud.service;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;

import jp.co.sss.crud.db.EmployeeDAO;
import jp.co.sss.crud.dto.Department;
import jp.co.sss.crud.dto.Employee;
import jp.co.sss.crud.io.ConsoleWriter;
import jp.co.sss.crud.io.EmployeeBirthdayReader;
import jp.co.sss.crud.io.EmployeeDeptIdReader;
import jp.co.sss.crud.io.EmployeeEmpIdReader;
import jp.co.sss.crud.io.EmployeeGenderReader;
import jp.co.sss.crud.io.EmployeeNameReader;

public class EmployeeUpdateService implements IEmployeeService {
	
	private EmployeeDAO employeeDAO;
	
	
	public void execute() throws ClassNotFoundException, SQLException, IOException, ParseException {
		ConsoleWriter.showHeadingEmpId();
		Integer empId = (Integer) new EmployeeEmpIdReader().input();

		ConsoleWriter.showHeadingEmployeeName();
		String name = (String) new EmployeeNameReader().input();

		ConsoleWriter.showHeadingEmployeeGender();
		Integer gender = (Integer) new EmployeeGenderReader().input();

		ConsoleWriter.showHeadingEmployeeBirthday();
		String birthday = (String) new EmployeeBirthdayReader().input();

		ConsoleWriter.showHeadingDepartment();
		Integer deptId = (Integer) new EmployeeDeptIdReader().input();
		
		Employee employee = new Employee();
		employee.setEmpId(empId);
		employee.setEmpName(name);
		employee.setGender(gender);
		employee.setBirthday(birthday);

		Department department = new Department();
		department.setDeptId(deptId);
		employee.setDepartment(department);
		
		employeeDAO = new EmployeeDAO();
		Integer exeCount = employeeDAO.update(employee);

		ConsoleWriter.showCompleteUpdate(exeCount);
	}
	
	
	
}