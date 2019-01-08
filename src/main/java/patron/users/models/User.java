package patron.users.models;

import com.appscharles.libs.databaser.models.BaseModel;
import patron.events.models.Event;
import patron.tickets.models.Ticket;
import patron.users.enums.RoleName;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * The type User.
 */
@Entity
@Table(name="user")
public class User extends BaseModel {

    private String login;

    private String password;

    @ManyToMany(cascade = { CascadeType.ALL }, fetch = FetchType.EAGER)
    @JoinTable(name = "user_role", joinColumns = { @JoinColumn(name = "user_id") }, inverseJoinColumns = { @JoinColumn(name = "role_id") })
    private Set<Role> roles;

    @OneToMany(mappedBy="createdBy", fetch = FetchType.EAGER)
    private Set<Ticket> generatedTickets;

    @OneToMany(mappedBy = "reservedBy", fetch = FetchType.EAGER)
    private Set<Ticket> reservedTickets;

    @OneToMany(mappedBy="createdBy", fetch = FetchType.EAGER)
    private Set<Event> generatedEvents;

    /**
     * Instantiates a new User.
     */
    public User() {
        this.roles = new HashSet<>();
        this.generatedTickets = new HashSet<>();
        this.reservedTickets = new HashSet<>();
    }

    /**
     * Instantiates a new User.
     *
     * @param login    the login
     * @param password the password
     * @param roleName the role name
     */
    public User(String login, String password, RoleName roleName) {
        this();
        this.login = login;
        this.password = password;
        this.roles.add(new Role(roleName));
    }

    /**
     * Gets login.
     *
     * @return the login
     */
    public String getLogin() {
        return login;
    }

    /**
     * Sets login.
     *
     * @param login the login
     */
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     * Gets password.
     *
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets password.
     *
     * @param password the password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Gets roles.
     *
     * @return the roles
     */
    public Set<Role> getRoles() {
        return roles;
    }

    /**
     * Sets roles.
     *
     * @param roles the roles
     */
    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    /**
     * Gets generated tickets.
     *
     * @return the generated tickets
     */
    public Set<Ticket> getGeneratedTickets() {
        return generatedTickets;
    }

    /**
     * Sets generated tickets.
     *
     * @param generatedTickets the generated tickets
     */
    public void setGeneratedTickets(Set<Ticket> generatedTickets) {
        this.generatedTickets = generatedTickets;
    }

    /**
     * Gets reserved tickets.
     *
     * @return the reserved tickets
     */
    public Set<Ticket> getReservedTickets() {
        return reservedTickets;
    }

    /**
     * Sets reserved tickets.
     *
     * @param reservedTickets the reserved tickets
     */
    public void setReservedTickets(Set<Ticket> reservedTickets) {
        this.reservedTickets = reservedTickets;
    }

    /**
     * Gets generated events.
     *
     * @return the generated events
     */
    public Set<Event> getGeneratedEvents() {
        return generatedEvents;
    }

    /**
     * Sets generated events.
     *
     * @param generatedEvents the generated events
     */
    public void setGeneratedEvents(Set<Event> generatedEvents) {
        this.generatedEvents = generatedEvents;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(getId(), user.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
