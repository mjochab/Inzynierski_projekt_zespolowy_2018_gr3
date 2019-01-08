package patron.tickets.exceptions;

/**
 * The type Tickets exception.
 */
public class TicketsException extends Exception {

    /**
     * The Serial version uid.
     */
    static final long serialVersionUID = 7231375821123530132L;

    /**
     * Instantiates a new Tickets exception.
     */
    public TicketsException() {
        super();
    }

    /**
     * Instantiates a new Tickets exception.
     *
     * @param message the message
     */
    public TicketsException(String message) {
        super(message);
    }

    /**
     * Instantiates a new Tickets exception.
     *
     * @param message the message
     * @param cause   the cause
     */
    public TicketsException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Instantiates a new Tickets exception.
     *
     * @param cause the cause
     */
    public TicketsException(Throwable cause) {
        super(cause);
    }

}

