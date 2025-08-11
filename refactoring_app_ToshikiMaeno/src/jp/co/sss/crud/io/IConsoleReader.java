package jp.co.sss.crud.io;
import static jp.co.sss.crud.util.ConstantMsg.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import jp.co.sss.crud.exception.IllegalInputException;
import jp.co.sss.crud.exception.SystemErrorException;

public interface IConsoleReader {
	public default Object input() throws SystemErrorException, IllegalInputException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = null;
		try {
		input = br.readLine();
			if (!isValid(input)) {
				String errorMsg = getErrorMsg();
				throw new IllegalInputException(errorMsg);
			} 
		} catch (IOException e) {
			throw new SystemErrorException(MSG_SYSTEM_ERROR, e);
		}
		
		if (isParseInt()) {
			return Integer.parseInt(input);
		}
		return input;
	}
	
	boolean isParseInt();
	boolean isValid(String inputString);
	String getErrorMsg();
}
