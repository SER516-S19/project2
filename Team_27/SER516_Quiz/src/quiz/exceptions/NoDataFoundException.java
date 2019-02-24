package quiz.exceptions;

/**
 * A Java class used for handling JDBC Exceptions
 * 
 * @author (Shefali Anand)
 * @version (1.0)
 * @createDate (19 Feb 2019)
 */

@SuppressWarnings("serial")
public class NoDataFoundException extends DataAccessException {
	public NoDataFoundException(String pExceptionMsg) {
		super(pExceptionMsg);
	}

	public NoDataFoundException(String pExceptionMsg, Throwable pException) {
		super(pExceptionMsg, pException);
	}
}
