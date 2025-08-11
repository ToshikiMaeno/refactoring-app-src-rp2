package jp.co.sss.crud.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public interface IConsoleReader {
	public default Object input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = null;
		input = br.readLine();
		
		if (isParseInt()) {
			return Integer.parseInt(input);
		}
		return input;
	}
	
	boolean isParseInt();
}
