public class NotLoggedInException extends Exception {
    public NotLoggedInException() {
        super("Please login first.");
    }
}
