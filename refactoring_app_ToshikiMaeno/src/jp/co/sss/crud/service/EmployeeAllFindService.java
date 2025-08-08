package jp.co.sss.crud.service;

import java.sql.SQLException;

import jp.co.sss.crud.db.EmployeeDAO;

public class EmployeeAllFindService implements IEmployeeService {
	
	private EmployeeDAO employeeDAO;
	
	
	public void execute() throws ClassNotFoundException, SQLException {
		employeeDAO = new EmployeeDAO();
		
		//System.out.println();//改行
		// 全件表示機能の呼出
		employeeDAO.findAllDisplay();
	}
	
	
	
}
