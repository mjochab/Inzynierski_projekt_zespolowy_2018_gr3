package patron.users.factories;

import patron.users.guis.list.UserListController;
import com.appscharles.libs.fxer.exceptions.FxerException;
import com.appscharles.libs.fxer.factories.AbstractPrepareViewFactory;
import com.appscharles.libs.fxer.factories.FxViewFactory;
import com.appscharles.libs.fxer.views.FxView;
import javafx.scene.Parent;

import java.io.IOException;

/**
 * The type User list view factory.
 */
public class UserListViewFactory extends AbstractPrepareViewFactory {

    public Parent create() throws FxerException {
        try {
            FxView fxView = new FxViewFactory("/patron/users/guis/list/UserListView.fxml",
                    "patron/users/guis/list/translations/UserList", new UserListController(), this.fXStage)
                    .addStylesheet("com/appscharles/libs/fxer/guis/commons/styles/TableView.css")
                    .addStylesheet("com/appscharles/libs/fxer/guis/commons/styles/Buttons.css")
                    .create();
            return fxView.createView();
        } catch (IOException e) {
            throw new FxerException(e);
        }
    }
}