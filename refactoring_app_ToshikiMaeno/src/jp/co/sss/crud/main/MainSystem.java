package jp.co.sss.crud.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;

import jp.co.sss.crud.db.EmployeeDAO;
import jp.co.sss.crud.util.ConstantMsg;

/**
 * 社員情報管理システム開始クラス 社員情報管理システムはこのクラスから始まる。<br/>
 * メニュー画面を表示する。
 *
 * @author System Shared
 *
 */
public class MainSystem {
	/**
	 * 社員管理システムを起動
	 *
	 * @throws IOException 
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 * @throws ParseException 
	 */
	public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException, ParseException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int menuNo = 0;

		do {
			// メニューの表示
			System.out.print(ConstantMsg.MENU_MESSAGE_ALL_DISPLAY);

			// メニュー番号の入力
			String menuNoStr = br.readLine();
			menuNo = Integer.parseInt(menuNoStr);

			// 機能の呼出
			switch (menuNo) {
			case 1:
				// 全件表示機能の呼出
				EmployeeDAO.findAllDisplay();
				break;

			case 2:
				// 社員名検索
				System.out.print(ConstantMsg.MENU_MESSAGE_EMPLOYEE_NAME);

				// 検索機能の呼出
				EmployeeDAO.findEmployeeName();
				break;

			case 3:
				// 検索する部署IDを入力
				System.out.print(ConstantMsg.MENU_MESSAGE_DEPTID_INPUT);
				String deptId = br.readLine();
				int deptIdInt = Integer.parseInt(deptId);

				// 検索機能の呼出
				EmployeeDAO.findDeptId(deptIdInt);
				break;

			case 4:
				// 登録する値を入力
				System.out.print(ConstantMsg.MENU_MESSAGE_EMPLOYEE_NAME);
				String emp_name = br.readLine();
				System.out.print(ConstantMsg.MENU_MESSAGE_GENERAL);
				String Seibetsu = br.readLine();
				int Seibetsu2 = Integer.parseInt(Seibetsu);
				System.out.print(ConstantMsg.MENU_MESSAGE_BIRTHDAY);
				String birthday = br.readLine();
				String strDate = birthday.replaceAll("/", "-");
				Date birthday2 = java.sql.Date.valueOf(strDate);
				
				System.out.print(ConstantMsg.MENU_MESSAGE_DEPTID);
				String deptIdInsert = br.readLine();
				int deptIdInt2 = Integer.parseInt(deptIdInsert);

				// 登録機能の呼出
				EmployeeDAO.insert(emp_name, Seibetsu2, birthday2, deptIdInt2);
				//EmployeeDAO.insert2();
				//EmployeeDAO.findAllDisplay();
				break;

			case 5:
				// 更新する社員IDを入力
				System.out.print(ConstantMsg.MENU_MESSAGE_EMPLOYEE_UPDATE_INPUT);

				// 更新する値を入力する
				String empId_1 = br.readLine();
				int empId_2 = Integer.parseInt(empId_1);

				// 更新機能の呼出
				EmployeeDAO.update(empId_2);
				System.out.println(ConstantMsg.MENU_MESSAGE_EMPLOYEE_INFORMATION_UPDATE);

				break;

			case 6:
				// 削除する社員IDを入力
				System.out.print(ConstantMsg.MENU_MESSAGE_EMPLOYEE_DELETE_INPUT);
				
				// 更新する値を入力する
				String empId_3 = br.readLine();
				int empId_4 = Integer.parseInt(empId_3);

				// 削除機能の呼出
				EmployeeDAO.delete(empId_4);
				System.out.println(ConstantMsg.MENU_MESSAGE_EMPLOYEE_INFORMATION_DELETE);
				break;

			}
		} while (menuNo != 7);
		// システム終了
		//System.out.println("システムを終了します。");
		System.out.println(ConstantMsg.MENU_MESSAGE_SYSTEM_END);
	}
}
