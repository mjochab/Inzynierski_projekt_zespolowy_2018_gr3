package patron.tickets.respositories;

import com.appscharles.libs.databaser.exceptions.DatabaserException;
import com.appscharles.libs.databaser.managers.SFManager;
import com.appscharles.libs.databaser.operators.DBOperator;
import org.hibernate.Session;
import org.hibernate.query.Query;
import patron.tickets.enums.TicketType;
import patron.tickets.models.Ticket;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * The type Ticket repository.
 */
public class TicketRepository {

    /**
     * Gets all.
     *
     * @return the all
     * @throws DatabaserException the databaser exception
     */
    public static List<Ticket> getAll() throws DatabaserException {
        return DBOperator.getAll(Ticket.class);
    }

    /**
     * Gets by type.
     *
     * @param ticketType the ticket type
     * @return the by type
     * @throws DatabaserException the databaser exception
     */
    public static List<Ticket> getByType(TicketType ticketType) throws DatabaserException {
       try{
           Session session = SFManager.getDefaultSessionFactory().openSession();
           CriteriaBuilder builder = session.getCriteriaBuilder();
           CriteriaQuery<Ticket> criteriaQuery = builder.createQuery(Ticket.class);
           Root<Ticket> root = criteriaQuery.from(Ticket.class);
           criteriaQuery.select(root);
           criteriaQuery.where(builder.equal(root.get("type"), ticketType));
           Query<Ticket> q = session.createQuery(criteriaQuery);
           List<Ticket> results = q.getResultList();
           session.close();
           return results;
       } catch (Exception e){
           throw new DatabaserException(e);
       }


    }


    /**
     * Remove all.
     *
     * @throws DatabaserException the databaser exception
     */
    public static void removeAll() throws DatabaserException {
        DBOperator.commit(session -> {
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaDelete<Ticket> criteriaQuery = builder.createCriteriaDelete(Ticket.class);
            criteriaQuery.from(Ticket.class);
            session.createQuery(criteriaQuery).executeUpdate();
        });
    }

    /**
     * Count long.
     *
     * @return the long
     * @throws DatabaserException the databaser exception
     */
    public static Long count() throws DatabaserException {
        try{
            Session session = SFManager.getDefaultSessionFactory().openSession();
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Long> criteriaQuery = builder.createQuery(Long.class);
            criteriaQuery.select(builder.count(criteriaQuery.from(Ticket.class)));
            Long count = session.createQuery(criteriaQuery).getSingleResult();
            session.close();
            return count;
        } catch (Exception e){
            throw new DatabaserException(e);
        }
    }
}
