package jp.co.sss.crud.service;

import java.sql.SQLException;
import java.util.List;

import jp.co.sss.crud.db.EmployeeDAO;
import jp.co.sss.crud.dto.Employee;
import jp.co.sss.crud.exception.IllegalInputException;
import jp.co.sss.crud.exception.SystemErrorException;
import jp.co.sss.crud.io.ConsoleWriter;

public class EmployeeAllFindService implements IEmployeeService {
	
	private EmployeeDAO employeeDAO;
	
	
	public void execute() throws SystemErrorException, IllegalInputException, ClassNotFoundException, SQLException {
		employeeDAO = new EmployeeDAO();
		List<Employee> searchEmployees = null;
		
		// 全件表示機能の呼出
		searchEmployees = employeeDAO.findAllDisplay();
		
		ConsoleWriter.showEmployees(searchEmployees);
	}
	
	
	
}
