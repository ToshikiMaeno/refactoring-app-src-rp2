package jp.co.sss.crud.io;
import static jp.co.sss.crud.util.ConstantMsg.*;

public class EmployeeDeptIdReader implements IConsoleReader {
	@Override
	public boolean isParseInt() {
		return true;
	}

	/**
	 * バリデーションの実行メソッド
	 *
	 * @param inputString コンソール入力された文字列
	 * @return inputString.matchesの結果を返す。true:inputStringが1-3までの数値の場合
	 */
	@Override
	public boolean isValid(String inputString) {
		return inputString.matches("^[1-3１-３]$");//1-3までの数値
	}

	@Override
	public String getErrorMsg() {
		return MSG_ILLEGAL_INPUT;
	}
}
