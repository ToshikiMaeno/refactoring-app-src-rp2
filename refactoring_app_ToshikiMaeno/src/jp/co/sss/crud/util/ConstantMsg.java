package jp.co.sss.crud.util;

public class ConstantMsg {
	/** メッセージ */
	public static final String MENU_MESSAGE = "=== 社員管理システム ===";
	public static final String MENU_MESSAGE_1 = "1.全件表示";
	public static final String MENU_MESSAGE_2 = "2.社員名検索";
	public static final String MENU_MESSAGE_3 = "3.部署ID検索";
	public static final String MENU_MESSAGE_4 = "4.新規登録";
	public static final String MENU_MESSAGE_5 = "5.更新";
	public static final String MENU_MESSAGE_6 = "6.削除";
	public static final String MENU_MESSAGE_7 = "7.終了";
	public static final String MENU_MESSAGE_INPUT = "メニュー番号を入力してください：";
	public static final String MENU_MESSAGE_ALL_DISPLAY = MENU_MESSAGE + "\n" + MENU_MESSAGE_1 + "\n" + MENU_MESSAGE_2 + 
			"\n" + MENU_MESSAGE_3 + "\n"+ MENU_MESSAGE_4 + "\n" + MENU_MESSAGE_5 +
			"\n"+ MENU_MESSAGE_6 + "\n" + MENU_MESSAGE_7 + "\n"+ MENU_MESSAGE_INPUT;
	
	public static final String MENU_MESSAGE_EMPLOYEE_NAME = "社員名:";
	public static final String MENU_MESSAGE_DEPTID_INPUT = "部署ID(1:営業部、2:経理部、3:総務部)を入力してください:";
	//public static final String MENU_MESSAGE_GENERAL = "性別(0:その他, 1:男性, 2:女性, 9:回答なし):";
	public static final String MENU_MESSAGE_GENERAL = "性別(0:回答しない, 1:男性, 2:女性, 9:その他):";
	public static final String MENU_MESSAGE_BIRTHDAY = "生年月日(西暦年/月/日):";
	public static final String MENU_MESSAGE_DEPTID = "部署ID(1:営業部、2:経理部、3:総務部):";
	//public static final String MENU_MESSAGE_EMPLOYEE_UPDATE_INPUT = "更新する社員の社員IDを入力してください：";
	public static final String MENU_MESSAGE_EMPLOYEE_INFORMATION_UPDATE = "社員情報を更新しました";
	//public static final String MENU_MESSAGE_EMPLOYEE_DELETE_INPUT = "削除する社員の社員IDを入力してください：";
	public static final String MSG_EMP_ID = "社員IDを入力してください：";
	public static final String MENU_MESSAGE_EMPLOYEE_INFORMATION_DELETE = "社員情報を削除しました";
	public static final String MENU_MESSAGE_SYSTEM_END = "システムを終了します。";
	
	
	public static final String HEADER = "社員ID\t社員名\t性別\t生年月日\t部署名";
	public static final String MALE = "男性";
	public static final String FEMALE = "女性";
	public static final String NO_ANSWER = "回答なし";
	public static final String OTHER = "その他";
	public static final String MSG_NON_EXIST_TARGET = "対象者がいませんでした";
	
	public static final String MSG_SYSTEM_ERROR = "システムエラーです。";
}
