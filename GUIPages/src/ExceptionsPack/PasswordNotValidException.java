package ExceptionsPack;

public class PasswordNotValidException extends LoginException{
    public PasswordNotValidException() {
        super("Password is not valid for this account!");
    }
}
