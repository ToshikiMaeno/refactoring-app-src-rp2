package jp.co.sss.crud.service;

import java.sql.SQLException;

public interface IEmployeeService {
	

	public static IEmployeeService getInstanceByMenuNo(int menuNo) {
		IEmployeeService newInstance = null;
		// TODO 自動生成されたメソッド・スタブ
		newInstance = new EmployeeAllFindService();
		return newInstance;
	}

	public void execute() throws ClassNotFoundException, SQLException;

}
