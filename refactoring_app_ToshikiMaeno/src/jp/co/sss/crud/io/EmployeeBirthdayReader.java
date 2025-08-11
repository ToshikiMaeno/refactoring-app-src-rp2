package jp.co.sss.crud.io;

import static jp.co.sss.crud.util.ConstantMsg.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class EmployeeBirthdayReader implements IConsoleReader {
	
	/**
	 * @return エラーメッセージ
	 */
	@Override
	public String getErrorMsg() {
		return MSG_ILLEGAL_BIRTHDAY;
	}

	/**
	 * @return 指定した形式（yyyy/MM/dd形式）に一致する場合は、true
	 */
	@Override
	public boolean isValid(String inputString) {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		sdf.setLenient(false);//厳密な日付チェック
		boolean isValid = false;
		try {
			sdf.parse(inputString);
			isValid = true;
		} catch (ParseException e) {
		}
		return isValid;

	}
	
	@Override
	public boolean isParseInt() {
		return false;
	}
}
