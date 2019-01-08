package patron.events.exceptions;

/**
 * The type Events exception.
 */
public class EventsException extends Exception {

    /**
     * The Serial version uid.
     */
    static final long serialVersionUID = 7231375821123530132L;

    /**
     * Instantiates a new Events exception.
     */
    public EventsException() {
        super();
    }

    /**
     * Instantiates a new Events exception.
     *
     * @param message the message
     */
    public EventsException(String message) {
        super(message);
    }

    /**
     * Instantiates a new Events exception.
     *
     * @param message the message
     * @param cause   the cause
     */
    public EventsException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Instantiates a new Events exception.
     *
     * @param cause the cause
     */
    public EventsException(Throwable cause) {
        super(cause);
    }

}

