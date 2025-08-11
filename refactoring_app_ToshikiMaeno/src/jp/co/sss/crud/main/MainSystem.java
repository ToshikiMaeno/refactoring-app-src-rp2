package jp.co.sss.crud.main;

//import jp.co.sss.crud.util.ConstantMsg;
import static jp.co.sss.crud.util.ConstantMsg.*;
import static jp.co.sss.crud.util.ConstantValue.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.text.ParseException;

import jp.co.sss.crud.io.ConsoleWriter;
import jp.co.sss.crud.io.MenuNoReader;
import jp.co.sss.crud.service.IEmployeeService;

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
		
		MenuNoReader menuNoReader = new MenuNoReader();
		int menuNo = 0;

		do {
			// メニューの表示
			//System.out.print(MENU_MESSAGE_ALL_DISPLAY);
			ConsoleWriter.showMenu();

			// メニュー番号の入力
			//String menuNoStr = br.readLine();
			//menuNo = Integer.parseInt(menuNoStr);
			
			menuNo = (int) menuNoReader.input();
			
			if (menuNo == MENU_END) {
				break;
			}
			
			//ビジネスロジックの呼び出し
			IEmployeeService service = IEmployeeService.getInstanceByMenuNo(menuNo);
			service.execute();

	
		} while (menuNo != MENU_END);
		// システム終了
		System.out.println(MENU_MESSAGE_SYSTEM_END);
	}
}
