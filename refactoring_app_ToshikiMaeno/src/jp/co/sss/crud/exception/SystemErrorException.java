package jp.co.sss.crud.exception;

public class SystemErrorException extends Exception {
	public SystemErrorException() {
		super();
		// TODO 自動生成されたコンストラクター・スタブ
	}
	
	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public SystemErrorException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO 自動生成されたコンストラクター・スタブ
	}

	/**
	 * @param message
	 * @param cause
	 */
	public SystemErrorException(String message, Throwable cause) {
		super(message, cause);
		// TODO 自動生成されたコンストラクター・スタブ
	}

	/**
	 * @param message
	 */
	public SystemErrorException(String message) {
		super(message);
		// TODO 自動生成されたコンストラクター・スタブ
	}

	/**
	 * @param cause
	 */
	public SystemErrorException(Throwable cause) {
		super(cause);
		// TODO 自動生成されたコンストラクター・スタブ
	}
}
