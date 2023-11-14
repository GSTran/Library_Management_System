package Library_Backend.ExceptionsPack;

public class BookNotAvailableException extends CheckoutExceptions{
    public BookNotAvailableException() {
        super("This book is not available for checkout!");
    }
}
