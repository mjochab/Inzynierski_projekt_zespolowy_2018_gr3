package patron.auth.guis.login.controllerExtend;

import com.appscharles.libs.fxer.abstracts.AbstractViewControllerFxExtend;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import patron.users.enums.RoleName;
import patron.users.models.User;
import patron.users.respositories.UserRepository;

import java.util.List;

/**
 * The type 10 fields controller extend.
 */
public class _10_FieldsControllerExtend extends AbstractViewControllerFxExtend {

    /**
     * The Role combo.
     */
    @FXML
    protected ComboBox<RoleName> roleCombo;

    /**
     * The Login field.
     */
    @FXML
    protected TextField loginField;

    /**
     * The Password field.
     */
    @FXML
    protected PasswordField passwordField;

    /**
     * Instantiates a new 10 fields controller extend.
     */
    protected _10_FieldsControllerExtend() {
        this.addOnInitializeWithSneakyThrow(() -> {
            List<User> users = UserRepository.getAll();
            if (users.size() == 1){
                this.roleCombo.setValue(RoleName.ADMIN);
                this.loginField.setText(users.get(0).getLogin());
                if (users.get(0).getPassword().equals("admin")){
                    this.passwordField.setText("admin");
                }
            }
        });
    }
}
