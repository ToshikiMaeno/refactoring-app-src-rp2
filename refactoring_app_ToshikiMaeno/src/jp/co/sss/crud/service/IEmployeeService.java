package jp.co.sss.crud.service;

import java.io.IOException;
import java.sql.SQLException;

import jp.co.sss.crud.util.ConstantMsg;

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
			case 3:
				newInstance = new EmployeeFindByDeptIdService();
				break;
			case 4:
				newInstance = new EmployeeRegisterService();
				break;
			case 5:
				newInstance = new EmployeeUpdateService();
				break;
			case 6:
				newInstance = new EmployeeDeleteService();
				break;
			case 7:
				System.out.println(ConstantMsg.MENU_MESSAGE_SYSTEM_END);
				break;
		}
		return newInstance;
	}

	public void execute() throws ClassNotFoundException, SQLException, IOException;
	//public void execute() throws ClassNotFoundException, SQLException;

}
