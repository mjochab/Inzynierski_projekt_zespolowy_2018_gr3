package patron.users.factories;

import patron.users.guis.edit.UserEditController;
import patron.users.models.User;
import com.appscharles.libs.fxer.exceptions.FxerException;
import com.appscharles.libs.fxer.factories.AbstractPrepareViewFactory;
import com.appscharles.libs.fxer.factories.FxViewFactory;
import com.appscharles.libs.fxer.views.FxView;
import javafx.scene.Parent;

import java.io.IOException;

/**
 * The type User edit view factory.
 */
public class UserEditViewFactory extends AbstractPrepareViewFactory {

    private User signerAllegro;

    /**
     * Instantiates a new User edit view factory.
     *
     * @param signerAllegro the signer allegro
     */
    public UserEditViewFactory(User signerAllegro) {
        this.signerAllegro = signerAllegro;
    }

    public Parent create() throws FxerException {
        try {
            FxViewFactory fxViewFactory = new FxViewFactory("/patron/users/guis/edit/UserEditView.fxml",
                    "patron/users/guis/edit/translations/UserEdit", new UserEditController(this.signerAllegro), this.fXStage)
                    .addStylesheet("com/appscharles/libs/fxer/guis/commons/styles/Buttons.css");

            FxView fxView = fxViewFactory.create();
            return fxView.createView();
        } catch (IOException e) {
            throw new FxerException(e);
        }
    }

}