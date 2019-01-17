package patron.tickets.models;

import com.appscharles.libs.databaser.models.BaseModel;
import patron.events.models.Event;
import patron.tickets.enums.TicketType;
import patron.users.models.User;

import javax.persistence.*;
import java.util.Objects;

/**
 * The type Ticket.
 */
@Entity
@Table(name="ticket")
public class Ticket extends BaseModel {

    private String title;

    private String description;

    private Double price;

    private Boolean reserved;

    @Enumerated(EnumType.STRING)
    private TicketType type;

    @ManyToOne(fetch = FetchType.EAGER)
    private User createdBy;

    @ManyToOne(fetch = FetchType.EAGER)
    private User reservedBy;

    @ManyToOne(fetch = FetchType.EAGER)
    private Event event;

    /**
     * Instantiates a new Ticket.
     */
    public Ticket() {
        this.reserved = false;
    }

    /**
     * Instantiates a new Ticket.
     *
     * @param title       the title
     * @param description the description
     * @param price       the price
     * @param reserved    the reserved
     * @param type        the type
     * @param createdBy   the created by
     */
    public Ticket(String title, String description, Double price, Boolean reserved, TicketType type, User createdBy) {
        this();
        this.title = title;
        this.description = description;
        this.price = price;
        this.reserved = reserved;
        this.type = type;
        this.createdBy = createdBy;
    }

    /**
     * Instantiates a new Ticket.
     *
     * @param title       the title
     * @param description the description
     * @param price       the price
     */
    public Ticket(String title, String description, Double price) {
        this();
        this.title = title;
        this.description = description;
        this.price = price;
    }

    /**
     * Gets title.
     *
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets title.
     *
     * @param title the title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Gets description.
     *
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets description.
     *
     * @param description the description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Gets price.
     *
     * @return the price
     */
    public Double getPrice() {
        return price;
    }

    /**
     * Sets price.
     *
     * @param price the price
     */
    public void setPrice(Double price) {
        this.price = price;
    }

    /**
     * Gets reserved.
     *
     * @return the reserved
     */
    public Boolean getReserved() {
        return reserved;
    }

    /**
     * Sets reserved.
     *
     * @param reserved the reserved
     */
    public void setReserved(Boolean reserved) {
        this.reserved = reserved;
    }

    /**
     * Gets type.
     *
     * @return the type
     */
    public TicketType getType() {
        return type;
    }

    /**
     * Sets type.
     *
     * @param type the type
     */
    public void setType(TicketType type) {
        this.type = type;
    }

    /**
     * Gets created by.
     *
     * @return the created by
     */
    public User getCreatedBy() {
        return createdBy;
    }

    /**
     * Sets created by.
     *
     * @param createdBy the created by
     */
    public void setCreatedBy(User createdBy) {
        this.createdBy = createdBy;
    }

    /**
     * Gets reserved by.
     *
     * @return the reserved by
     */
    public User getReservedBy() {
        return reservedBy;
    }

    /**
     * Sets reserved by.
     *
     * @param reservedBy the reserved by
     */
    public void setReservedBy(User reservedBy) {
        this.reservedBy = reservedBy;
    }

    /**
     * Gets event.
     *
     * @return the event
     */
    public Event getEvent() {
        return event;
    }

    /**
     * Sets event.
     *
     * @param event the event
     */
    public void setEvent(Event event) {
        this.event = event;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ticket ticket = (Ticket) o;
        return Objects.equals(getId(), ticket.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
