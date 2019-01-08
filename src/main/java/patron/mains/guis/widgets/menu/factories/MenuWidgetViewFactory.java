package patron.mains.guis.widgets.menu.factories;

import patron.mains.guis.widgets.menu.MenuWidgetController;
import com.appscharles.libs.fxer.exceptions.FxerException;
import com.appscharles.libs.fxer.factories.AbstractPrepareViewFactory;
import com.appscharles.libs.fxer.factories.FxViewFactory;
import com.appscharles.libs.fxer.views.FxView;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

/**
 * The type Menu widget view factory.
 */
public class MenuWidgetViewFactory extends AbstractPrepareViewFactory {

    private AnchorPane containerPane;

    /**
     * Instantiates a new Menu widget view factory.
     *
     * @param containerPane the container pane
     */
    public MenuWidgetViewFactory(AnchorPane containerPane) {
        this.containerPane = containerPane;
    }

    public Parent create() throws FxerException {
        try {
            FxView fxView = new FxViewFactory("/patron/mains/guis/widgets/menu/MenuWidgetView.fxml",
                    "patron/mains/guis/widgets/menu/translations/MenuWidget", new MenuWidgetController(this.containerPane), this.fXStage)
                    .addStylesheet("com/appscharles/libs/fxer/guis/commons/styles/TableView.css")
                    .addStylesheet("com/appscharles/libs/fxer/guis/commons/styles/Buttons.css")
                    .addStylesheet("com/appscharles/libs/fxer/guis/menu/styles/TreeView.css")
                    .create();
            return fxView.createView();
        } catch (IOException e) {
            throw new FxerException(e);
        }
    }
}