package jp.co.sss.crud.io;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class EmployeeBirthdayReader implements IConsoleReader {
	
	public String getErrorMsg() {
		return "正しい形式(yyyy/MM/dd)で入力してください";
	}
	
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
