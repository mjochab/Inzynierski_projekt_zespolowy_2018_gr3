package patron.events.models;

import com.appscharles.libs.databaser.models.BaseModel;
import patron.events.enums.EventType;
import patron.tickets.models.Ticket;
import patron.users.models.User;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * The type Event.
 */
@Entity
@Table(name="event")
public class Event extends BaseModel {

    private String title;

    @Enumerated(EnumType.STRING)
    private EventType type;

    @ManyToOne(fetch = FetchType.EAGER)
    private User createdBy;

    @OneToMany(mappedBy="event", fetch = FetchType.EAGER)
    private Set<Ticket> tickets;

    private Double agentReduction;

    private Double agentCommission;

    /**
     * Instantiates a new Event.
     */
    public Event() {
        this.tickets = new HashSet<>();
    }

    /**
     * Instantiates a new Event.
     *
     * @param title           the title
     * @param type            the type
     * @param createdBy       the created by
     * @param agentReduction  the agent reduction
     * @param agentCommission the agent commission
     */
    public Event(String title, EventType type, User createdBy, Double agentReduction, Double agentCommission) {
        this();
        this.title = title;
        this.type = type;
        this.createdBy = createdBy;
        this.agentReduction = agentReduction;
        this.agentCommission = agentCommission;
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
     * Gets type.
     *
     * @return the type
     */
    public EventType getType() {
        return type;
    }

    /**
     * Sets type.
     *
     * @param type the type
     */
    public void setType(EventType type) {
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
     * Gets tickets.
     *
     * @return the tickets
     */
    public Set<Ticket> getTickets() {
        return tickets;
    }

    /**
     * Sets tickets.
     *
     * @param tickets the tickets
     */
    public void setTickets(Set<Ticket> tickets) {
        this.tickets = tickets;
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
     * Gets agent reduction.
     *
     * @return the agent reduction
     */
    public Double getAgentReduction() {
        return agentReduction;
    }

    /**
     * Sets agent reduction.
     *
     * @param agentReduction the agent reduction
     */
    public void setAgentReduction(Double agentReduction) {
        this.agentReduction = agentReduction;
    }

    /**
     * Gets agent commission.
     *
     * @return the agent commission
     */
    public Double getAgentCommission() {
        return agentCommission;
    }

    /**
     * Sets agent commission.
     *
     * @param agentCommission the agent commission
     */
    public void setAgentCommission(Double agentCommission) {
        this.agentCommission = agentCommission;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Event event = (Event) o;
        return Objects.equals(getId(), event.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
