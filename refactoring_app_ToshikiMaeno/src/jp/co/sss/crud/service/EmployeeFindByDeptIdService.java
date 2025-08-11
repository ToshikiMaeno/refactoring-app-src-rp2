package jp.co.sss.crud.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import jp.co.sss.crud.db.EmployeeDAO;
import jp.co.sss.crud.dto.Employee;
import jp.co.sss.crud.io.ConsoleWriter;
import jp.co.sss.crud.io.EmployeeDeptIdReader;

public class EmployeeFindByDeptIdService implements IEmployeeService {
	
	private EmployeeDAO employeeDAO;
	
	public void execute() throws ClassNotFoundException, SQLException, IOException {
		employeeDAO = new EmployeeDAO();
		List<Employee> searchEmployees = null;
		
		ConsoleWriter.showHeadingDepartment();
		int deptId = (int) new EmployeeDeptIdReader().input();
		
		// 全件表示機能の呼出
		searchEmployees = employeeDAO.findDeptId(deptId);
		
		ConsoleWriter.showEmployees(searchEmployees);
	}

}
