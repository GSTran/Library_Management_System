package ExceptionsPack;

public class NoMatchingNumberException extends LoginException{
    public NoMatchingNumberException() {
        super("There is no matching library number for this input!");
    }
}
