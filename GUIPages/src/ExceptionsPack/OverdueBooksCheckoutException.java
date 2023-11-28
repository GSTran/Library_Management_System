package ExceptionsPack;

public class OverdueBooksCheckoutException extends CheckoutExceptions{
    public OverdueBooksCheckoutException() {
        super("Cannot checkout any books until all overdue books returned!");
    }
}
