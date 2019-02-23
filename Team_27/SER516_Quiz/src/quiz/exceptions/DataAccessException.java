package quiz.exceptions;

/**
 * A Java class used for handling JDBC Exceptions
 * 
 * @author (Shefali Anand)
 * @version (1.0)
 * @createDate (19 Feb 2019)
 */

@SuppressWarnings("serial")
public class DataAccessException extends Exception {
	Throwable exceptionCause = null;

	public DataAccessException(String pExceptionMsg) {
		super(pExceptionMsg);
	}

	public DataAccessException(String pExceptionMsg, Throwable pException) {
		super(pExceptionMsg);
		this.exceptionCause = pException;
	}
}
