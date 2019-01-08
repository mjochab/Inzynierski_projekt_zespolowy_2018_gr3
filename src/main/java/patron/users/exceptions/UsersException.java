package patron.users.exceptions;

/**
 * The type Users exception.
 */
public class UsersException extends Exception {

    /**
     * The Serial version uid.
     */
    static final long serialVersionUID = 2231374811123530132L;

    /**
     * Instantiates a new Users exception.
     */
    public UsersException() {
        super();
    }

    /**
     * Instantiates a new Users exception.
     *
     * @param message the message
     */
    public UsersException(String message) {
        super(message);
    }

    /**
     * Instantiates a new Users exception.
     *
     * @param message the message
     * @param cause   the cause
     */
    public UsersException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Instantiates a new Users exception.
     *
     * @param cause the cause
     */
    public UsersException(Throwable cause) {
        super(cause);
    }

}

