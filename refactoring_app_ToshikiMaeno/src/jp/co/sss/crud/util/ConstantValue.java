package jp.co.sss.crud.util;

public class ConstantValue {
	
	// ***** DB接続のための設定値 *****

	/** Oracle DBドライバー */
	//	public static final String JDBC_DRIVER = "oracle.jdbc.driver.OracleDriver";

	/** DB接続用文字列 */
	//	public static final String DB_URL = "jdbc:oracle:thin:@localhost:1521/xepdb1";

	/** DB接続用ユーザー */
	//	public static final String USER_NAME = "console_crud_user";

	/** DB接続用パスワード */
	//	public static final String PASSWORD = "systemsss";

	/** Postgres DBドライバー */
	public static final String JDBC_DRIVER = "org.postgresql.Driver";

	/** DB接続用文字列 */
	public static final String DB_URL = "jdbc:postgresql://localhost:5432/rp2db";

	/** DB接続用ユーザー */
	public static final String USER_NAME = "console_crud_user";

	/** DB接続用パスワード */
	public static final String PASSWORD = "systemsss";

	
	
	
	// ***** メニュー番号 *****

	/** メニュー番号(全件表示) */
	public static final int MENU_SELECT_ALL = 1;

	/** メニュー番号(登録) */
	public static final int MENU_SEARCH_EMP_NAME = 2;

	/** メニュー番号(登録) */
	public static final int MENU_SEARCH_DEPT_ID = 3;

	/** メニュー番号(登録) */
	public static final int MENU_INSERT = 4;

	/** メニュー番号(更新) */
	public static final int MENU_UPDATE = 5;

	/** メニュー番号(削除) */
	public static final int MENU_DELETE = 6;
	/** メニュー番号(終了) */
	public static final int MENU_END = 7;
}
