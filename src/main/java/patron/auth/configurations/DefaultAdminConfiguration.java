package patron.auth.configurations;

import com.appscharles.libs.databaser.exceptions.DatabaserException;
import com.appscharles.libs.databaser.operators.DBOperator;
import patron.users.enums.RoleName;
import patron.users.models.User;
import patron.users.respositories.UserRepository;

/**
 * The type Default admin configuration.
 */
public class DefaultAdminConfiguration {

    /**
     * Init.
     *
     * @throws DatabaserException the databaser exception
     */
    public static void init() throws DatabaserException {
        if (UserRepository.getAll().size()==0){
            DBOperator.save(new User("admin", "admin", RoleName.ADMIN));
        }
    }
}
