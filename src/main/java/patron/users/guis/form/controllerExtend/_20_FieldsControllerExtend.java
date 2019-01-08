package patron.users.guis.form.controllerExtend;


import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**
 * The type 20 fields controller extend.
 */
public class _20_FieldsControllerExtend extends _10_UserControllerExtend {

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
     * Instantiates a new 20 fields controller extend.
     */
    protected  _20_FieldsControllerExtend(){
        addOnInitializeWithSneakyThrow(()->{
            this.loginField.setText(this.user.getLogin());
            this.loginField.textProperty().addListener((args, oldVal, newVal)->{
                this.user.setLogin(newVal);
            });
            this.passwordField.setText(this.user.getPassword());
            this.passwordField.textProperty().addListener((args, oldVal, newVal)->{
                this.user.setPassword(newVal);
            });
        });
    }
}
