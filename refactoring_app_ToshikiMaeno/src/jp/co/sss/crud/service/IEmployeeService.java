package jp.co.sss.crud.service;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;

import jp.co.sss.crud.util.ConstantValue;

public interface IEmployeeService {
	/**
	 * サービスクラスのインスタンスを生成する
	 * @param menuNo
	 * @return IEmployeeServiceを実装したサービスクラス
	 */
	
	public static IEmployeeService getInstanceByMenuNo(int menuNo) {
		IEmployeeService newInstance = null;
		/*====menuNoごとにインスタンスを生成する。必要に応じてcaseを追加する====*/
		switch (menuNo) {
			case ConstantValue.MENU_SELECT_ALL:
				newInstance = new EmployeeAllFindService();
				break;
			case ConstantValue.MENU_SEARCH_EMP_NAME:
				newInstance = new EmployeeFindByEmpNameService();
				break;
			case ConstantValue.MENU_SEARCH_DEPT_ID:
				newInstance = new EmployeeFindByDeptIdService();
				break;
			case ConstantValue.MENU_INSERT:
				newInstance = new EmployeeRegisterService();
				break;
			case ConstantValue.MENU_UPDATE:
				newInstance = new EmployeeUpdateService();
				break;
			case ConstantValue.MENU_DELETE:
				newInstance = new EmployeeDeleteService();
				break;
		}
		return newInstance;
	}

	public void execute() throws ClassNotFoundException, SQLException, IOException, ParseException;

}
