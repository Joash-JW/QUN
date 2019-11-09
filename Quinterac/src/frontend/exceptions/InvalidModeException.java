//the objective of this class is to throw an exception when the wrong mode is used

package frontend.exceptions;

public class InvalidModeException extends Exception {
	//constructor for InvalidModeException
    public InvalidModeException() {
        super("Please use agent mode.");
    }
}
