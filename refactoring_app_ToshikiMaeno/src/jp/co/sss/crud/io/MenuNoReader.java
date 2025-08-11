package jp.co.sss.crud.io;

import static jp.co.sss.crud.util.ConstantMsg.*;

public class MenuNoReader implements IConsoleReader {

	@Override
	public boolean isParseInt() {
		return true;
	}

	@Override
	public boolean isValid(String inputString) {
		return inputString.matches("^[1-7１-７]$");//1-7までの数値
	}

	@Override
	public String getErrorMsg() {
		// TODO 自動生成されたメソッド・スタブ
		return MSG_ILLEGAL_INPUT;
	}
	
}
