package jp.co.sss.crud.io;
import static jp.co.sss.crud.util.ConstantMsg.*;

public class EmployeeEmpIdReader implements IConsoleReader {
	@Override
	public boolean isParseInt() {
		return true;
	}

	/**
	 * バリデーションの実行メソッド
	 *
	 * @param inputString コンソール入力された文字列
	 * @return inputString.matchesの結果を返す。true:inputStringが1-9999までの数値の場合
	 */
	@Override
	public boolean isValid(String inputString) {
		return inputString.matches("^[1-9]{1}[0-9]{0,3}$");//1-9999までの数値
	}

	@Override
	public String getErrorMsg() {
		return MSG_ILLEGAL_INPUT;
	}
}
