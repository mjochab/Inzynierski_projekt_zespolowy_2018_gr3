package patron.users.factories;

import patron.users.guis.add.UserAddController;
import com.appscharles.libs.fxer.exceptions.FxerException;
import com.appscharles.libs.fxer.factories.AbstractPrepareViewFactory;
import com.appscharles.libs.fxer.factories.FxViewFactory;
import com.appscharles.libs.fxer.views.FxView;
import javafx.scene.Parent;

import java.io.IOException;

/**
 * The type User add view factory.
 */
public class UserAddViewFactory extends AbstractPrepareViewFactory {

    public Parent create() throws FxerException {
        try {
            FxViewFactory fxViewFactory = new FxViewFactory("/patron/users/guis/add/UserAddView.fxml",
                    "patron/users/guis/add/translations/UserAdd", new UserAddController(), this.fXStage)
                    .addStylesheet("com/appscharles/libs/fxer/guis/commons/styles/Buttons.css");

            FxView fxView = fxViewFactory.create();

            return fxView.createView();
        } catch (IOException e) {
            throw new FxerException(e);
        }
    }

}