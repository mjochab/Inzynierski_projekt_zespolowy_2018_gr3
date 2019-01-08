package patron.events.respositories;

import com.appscharles.libs.databaser.exceptions.DatabaserException;
import com.appscharles.libs.databaser.managers.SFManager;
import com.appscharles.libs.databaser.operators.DBOperator;
import org.hibernate.Session;
import org.hibernate.query.Query;
import patron.events.enums.EventType;
import patron.events.models.Event;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * The type Event repository.
 */
public class EventRepository {

    /**
     * Gets by type.
     *
     * @param eventType the event type
     * @return the by type
     * @throws DatabaserException the databaser exception
     */
    public static List<Event> getByType(EventType eventType) throws DatabaserException {
       try{
           Session session = SFManager.getDefaultSessionFactory().openSession();
           CriteriaBuilder builder = session.getCriteriaBuilder();
           CriteriaQuery<Event> criteriaQuery = builder.createQuery(Event.class);
           Root<Event> root = criteriaQuery.from(Event.class);
           criteriaQuery.select(root);
           criteriaQuery.where(builder.equal(root.get("type"), eventType));
           Query<Event> q = session.createQuery(criteriaQuery);
           List<Event> results = q.getResultList();
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
            CriteriaDelete<Event> criteriaQuery = builder.createCriteriaDelete(Event.class);
            criteriaQuery.from(Event.class);
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
            criteriaQuery.select(builder.count(criteriaQuery.from(Event.class)));
            Long count = session.createQuery(criteriaQuery).getSingleResult();
            session.close();
            return count;
        } catch (Exception e){
            throw new DatabaserException(e);
        }
    }
}
