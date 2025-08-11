package jp.co.sss.crud.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.text.ParseException;

import jp.co.sss.crud.service.IEmployeeService;
import jp.co.sss.crud.util.ConstantMsg;
import jp.co.sss.crud.util.ConstantValue;

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
			
			if (menuNo == ConstantValue.MENU_END) {
				break;
			}
			
			//ビジネスロジックの呼び出し
			IEmployeeService service = IEmployeeService.getInstanceByMenuNo(menuNo);
			service.execute();

	
		} while (menuNo != ConstantValue.MENU_END);
		// システム終了
		System.out.println(ConstantMsg.MENU_MESSAGE_SYSTEM_END);
	}
}
