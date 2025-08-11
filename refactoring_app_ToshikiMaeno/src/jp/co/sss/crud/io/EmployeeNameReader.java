package jp.co.sss.crud.io;
import static jp.co.sss.crud.util.ConstantMsg.*;

public class EmployeeNameReader implements IConsoleReader {
	@Override
	public boolean isParseInt() {
		return false;
	}

	@Override
	public boolean isValid(String inputString) {
		return inputString.matches("^[あ-んーァ-ヶー一-龠]{1,30}$");//ひらがなかたかな漢字で1から30文字以内
	}

	@Override
	public String getErrorMsg() {
		return MSG_ILLEGAL_INPUT;
	}
}
