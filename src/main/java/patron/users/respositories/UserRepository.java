package patron.users.respositories;

import patron.users.models.User;
import com.appscharles.libs.databaser.exceptions.DatabaserException;
import com.appscharles.libs.databaser.operators.DBOperator;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

/**
 * The type User repository.
 */
public class UserRepository {

    /**
     * Gets all.
     *
     * @return the all
     * @throws DatabaserException the databaser exception
     */
    public static List<User> getAll() throws DatabaserException {
        return DBOperator.getAll(User.class);
    }

    /**
     * Gets by login.
     *
     * @param login the login
     * @return the by login
     * @throws DatabaserException the databaser exception
     */
    public static User getByLogin(String login) throws DatabaserException {
        List<User> results = new ArrayList<>();
        DBOperator.commit(session->{
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<User> criteriaQuery = builder.createQuery(User.class);
            Root<User> root = criteriaQuery.from(User.class);
            criteriaQuery.select(root);
            criteriaQuery.where(builder.equal(root.get("login"), login));
            Query<User> q = session.createQuery(criteriaQuery);
           results.addAll(q.getResultList());
        });
        if (results.size()==0){
            return null;
        }
        return results.get(0);
    }

    /**
     * Remove all.
     *
     * @throws DatabaserException the databaser exception
     */
    public static void removeAll() throws DatabaserException {
        DBOperator.commit(session -> {
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaDelete<User> criteriaQuery = builder.createCriteriaDelete(User.class);
            criteriaQuery.from(User.class);
            session.createQuery(criteriaQuery).executeUpdate();
        });
    }
}
