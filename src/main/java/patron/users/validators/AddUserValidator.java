package patron.users.validators;

import patron.mains.managers.app.AppManager;
import patron.users.models.User;
import patron.users.respositories.UserRepository;
import com.appscharles.libs.databaser.exceptions.DatabaserException;
import com.appscharles.libs.dialoger.factories.AlertFactory;
import com.appscharles.libs.fxer.controls.UTF8Control;
import javafx.scene.control.Alert;

import java.util.ResourceBundle;

/**
 * The type Add user validator.
 */
public class AddUserValidator {

    /**
     * Is valid boolean.
     *
     * @param user the user
     * @return the boolean
     * @throws DatabaserException the databaser exception
     */
    public static Boolean isValid(User user) throws DatabaserException {
        ResourceBundle resourceBundle = ResourceBundle.getBundle("patron/users/validators/translations/UserDialogValidator", new UTF8Control());
        if (user.getLogin() == null || user.getLogin().isEmpty()){
            AlertFactory.create(Alert.AlertType.WARNING, resourceBundle.getString("alert.warning.title"), resourceBundle
                    .getString("alert.warning.content.login_is_empty")).setIconStageResource(AppManager.getResourceIcon()).build().showAndWait();
            return false;
        }
        if (UserRepository.getByLogin(user.getLogin()) != null){
            AlertFactory.create(Alert.AlertType.WARNING, resourceBundle.getString("alert.warning.title"), resourceBundle
                    .getString("alert.warning.content.login_exist")).setIconStageResource(AppManager.getResourceIcon()).build().showAndWait();
            return false;
        }
        if (user.getRoles().size() == 0){
            AlertFactory.create(Alert.AlertType.WARNING, resourceBundle.getString("alert.warning.title"), resourceBundle
                    .getString("alert.warning.content.not_roles")).setIconStageResource(AppManager.getResourceIcon()).build().showAndWait();
            return false;
        }
        return true;
    }
}
