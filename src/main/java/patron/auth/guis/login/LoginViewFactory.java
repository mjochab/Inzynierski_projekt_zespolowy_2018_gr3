package patron.auth.guis.login;

import com.appscharles.libs.fxer.exceptions.FxerException;
import com.appscharles.libs.fxer.factories.AbstractPrepareViewFactory;
import com.appscharles.libs.fxer.factories.FxViewFactory;
import com.appscharles.libs.fxer.views.FxView;
import javafx.scene.Parent;

import java.io.IOException;

/**
 * The type Login view factory.
 */
public class LoginViewFactory extends AbstractPrepareViewFactory {

    public Parent create() throws FxerException {
        try {
            FxViewFactory fxViewFactory = new FxViewFactory("/patron/auth/guis/login/LoginView.fxml",
                    "patron/auth/guis/login/translations/Login", new LoginController(), this.fXStage)
                    .addStylesheet("com/appscharles/libs/fxer/guis/commons/styles/Buttons.css");

            FxView fxView = fxViewFactory.create();

            return fxView.createView();
        } catch (IOException e) {
            throw new FxerException(e);
        }
    }

}