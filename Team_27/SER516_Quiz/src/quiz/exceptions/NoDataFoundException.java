/*
 * Taken from J2EE Design Patterns Applied. Modified slightly.
 */

package quiz.exceptions;

@SuppressWarnings("serial")
public class NoDataFoundException extends DataAccessException {
	public NoDataFoundException(String pExceptionMsg) {
		super(pExceptionMsg);
	}

	public NoDataFoundException(String pExceptionMsg, Throwable pException) {
		super(pExceptionMsg, pException);
	}
}
