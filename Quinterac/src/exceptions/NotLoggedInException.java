//the objective of this class is to throw an exception when the user is not logged in

package exceptions;

public class NotLoggedInException extends Exception {
	//constructor for NotLoggedInException
    public NotLoggedInException() {
        super("Please login first.");
    }
}
