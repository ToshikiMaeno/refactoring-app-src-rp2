package jp.co.sss.crud.main;

//import jp.co.sss.crud.util.ConstantMsg;
import static jp.co.sss.crud.util.ConstantMsg.*;
import static jp.co.sss.crud.util.ConstantValue.*;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;

import jp.co.sss.crud.exception.IllegalInputException;
import jp.co.sss.crud.exception.SystemErrorException;
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
	 * @throws IllegalInputException 
	 * @throws SystemErrorException 
	 */
	public static void main(String[] args) throws ClassNotFoundException, IOException, SQLException {
		MenuNoReader menuNoReader = new MenuNoReader();
		int menuNo = 0;

		do {
			try {
				// メニューの表示
				ConsoleWriter.showMenu();

				// メニュー番号の入力
				menuNo = (int) menuNoReader.input();
			
				if (menuNo == MENU_END) {
					break;
			}
			
				//ビジネスロジックの呼び出し
				IEmployeeService service = IEmployeeService.getInstanceByMenuNo(menuNo);
				service.execute();
			} catch (IllegalInputException | ParseException e) {//不正な入力があった場合、ループに戻る
				System.out.println(e.getMessage());
				System.out.println();
				continue;
			} catch (SystemErrorException e) {//継続不能なエラーの場合、ループを抜ける
				System.out.println(e.getMessage());
				e.printStackTrace();
				break;
			}
		} while (menuNo != MENU_END);
		// システム終了
		System.out.println(MENU_MESSAGE_SYSTEM_END);
	}
}
