package jp.co.sss.crud.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import jp.co.sss.crud.db.EmployeeDAO;
import jp.co.sss.crud.dto.Employee;
import jp.co.sss.crud.io.ConsoleWriter;
import jp.co.sss.crud.io.EmployeeNameReader;

public class EmployeeFindByEmpNameService implements IEmployeeService {
	
	private EmployeeDAO employeeDAO;
	public void execute() throws ClassNotFoundException, SQLException, IOException {
		employeeDAO = new EmployeeDAO();
		List<Employee> searchEmployees = null;
		
		ConsoleWriter.showHeadingEmployeeName();
		String name = (String) new EmployeeNameReader().input();
		
		// 全件表示機能の呼出
		searchEmployees = employeeDAO.findEmployeeName(name);
		
		ConsoleWriter.showEmployees(searchEmployees);
	}
}
