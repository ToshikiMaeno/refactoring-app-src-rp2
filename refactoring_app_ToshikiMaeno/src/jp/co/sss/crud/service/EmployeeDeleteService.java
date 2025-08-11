package jp.co.sss.crud.service;

import java.io.IOException;
import java.sql.SQLException;

import jp.co.sss.crud.db.EmployeeDAO;
import jp.co.sss.crud.io.ConsoleWriter;
import jp.co.sss.crud.io.EmployeeEmpIdReader;

public class EmployeeDeleteService implements IEmployeeService {
	
	private EmployeeDAO employeeDAO;
	
	
	public void execute() throws ClassNotFoundException, SQLException, IOException {
		ConsoleWriter.showHeadingEmpId();
		Integer empId = (Integer) new EmployeeEmpIdReader().input();
		employeeDAO = new EmployeeDAO();
		Integer exeCount = employeeDAO.delete(empId);
		ConsoleWriter.showCompleteDelete(exeCount);
	}
	
	
	
}