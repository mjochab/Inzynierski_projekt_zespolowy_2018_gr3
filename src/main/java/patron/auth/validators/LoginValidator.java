package patron.auth.validators;

import com.appscharles.libs.databaser.exceptions.DatabaserException;
import com.appscharles.libs.dialoger.factories.AlertFactory;
import com.appscharles.libs.fxer.controls.UTF8Control;
import javafx.scene.control.Alert;
import patron.mains.managers.app.AppManager;
import patron.users.enums.RoleName;
import patron.users.models.User;
import patron.users.respositories.UserRepository;
import patron.users.services.UserService;

import java.util.ResourceBundle;

/**
 * The type Login validator.
 */
public class LoginValidator {

    /**
     * Is valid boolean.
     *
     * @param login    the login
     * @param password the password
     * @param roleName the role name
     * @return the boolean
     * @throws DatabaserException the databaser exception
     */
    public static Boolean isValid(String login, String password, RoleName roleName) throws DatabaserException {
        ResourceBundle resourceBundle = ResourceBundle.getBundle("patron/auth/validators/translations/LoginValidator", new UTF8Control());
        for (User user : UserRepository.getAll()) {
            if (user.getLogin().equalsIgnoreCase(login)
                    && user.getPassword().equals(password)
                    && UserService.hasRole(user, roleName)) {
                return true;
            }  else if (user.getLogin().equalsIgnoreCase(login)
                    && user.getPassword().equals(password)
                    && !UserService.hasRole(user, roleName)) {
                AlertFactory.create(Alert.AlertType.WARNING, resourceBundle.getString("alert.warning.title"), resourceBundle
                        .getString("alert.warning.content.no_role")).setIconStageResource(AppManager.getResourceIcon()).build().showAndWait();
                return false;
            }
        }
        AlertFactory.create(Alert.AlertType.WARNING, resourceBundle.getString("alert.warning.title"), resourceBundle
                .getString("alert.warning.content.incorrect_login_or_password")).setIconStageResource(AppManager.getResourceIcon()).build().showAndWait();
        return false;
    }
}
