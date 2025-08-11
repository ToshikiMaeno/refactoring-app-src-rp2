package jp.co.sss.crud.io;
import static jp.co.sss.crud.util.ConstantMsg.*;

public class EmployeeGenderReader implements IConsoleReader {
	@Override
	public boolean isParseInt() {
		return true;
	}

	/**
	 * バリデーションの実行メソッド
	 *
	 * @param inputString コンソール入力された文字列
	 * @return inputString.matchesの結果を返す。true:inputStringが0129の数値の場合
	 */
	@Override
	public boolean isValid(String inputString) {
		return inputString.matches("^|[0129０１２９]{1}$");//1-2までの数値
	}

	@Override
	public String getErrorMsg() {
		return MSG_ILLEGAL_INPUT;
	}
}
