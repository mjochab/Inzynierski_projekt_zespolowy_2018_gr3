package patron.users.factories;

import patron.users.guis.form.UserFormController;
import patron.users.models.User;
import com.appscharles.libs.fxer.exceptions.FxerException;
import com.appscharles.libs.fxer.factories.AbstractPrepareViewFactory;
import com.appscharles.libs.fxer.factories.FxViewFactory;
import com.appscharles.libs.fxer.views.FxView;
import javafx.scene.Parent;

import javax.annotation.Nonnull;
import java.io.IOException;

/**
 * The type User form view factory.
 */
public class UserFormViewFactory extends AbstractPrepareViewFactory {


    private User signerAllegro;

    /**
     * Instantiates a new User form view factory.
     *
     * @param signerAllegro the signer allegro
     */
    public UserFormViewFactory(@Nonnull User signerAllegro) {
        this.signerAllegro = signerAllegro;
    }

    public Parent create() throws FxerException {
        try {
            FxView fxView = new FxViewFactory("/patron/users/guis/form/UserFormView.fxml",
                    "patron/users/guis/form/translations/UserForm", new UserFormController(this.signerAllegro), this.fXStage)
                    .addStylesheet("com/appscharles/libs/fxer/guis/commons/styles/TabPane.css")
                    .addStylesheet("com/appscharles/libs/fxer/guis/commons/styles/TitledPane.css")
                    .create();
            return fxView.createView();
        } catch (IOException e) {
            throw new FxerException(e);
        }
    }
}