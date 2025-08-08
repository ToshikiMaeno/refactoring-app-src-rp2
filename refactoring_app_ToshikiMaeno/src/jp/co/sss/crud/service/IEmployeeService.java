package jp.co.sss.crud.service;

import java.io.IOException;
import java.sql.SQLException;

public interface IEmployeeService {
	

	public static IEmployeeService getInstanceByMenuNo(int menuNo) {
		IEmployeeService newInstance = null;
		switch (menuNo) {
			case 1:
				newInstance = new EmployeeAllFindService();
				break;
			case 2:
				newInstance = new EmployeeFindByEmpNameService();
				break;
		}
		return newInstance;
	}

	public void execute() throws ClassNotFoundException, SQLException, IOException;
	//public void execute() throws ClassNotFoundException, SQLException;

}
