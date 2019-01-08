package patron.users.guis.add.controllerExtend;


import patron.users.factories.UserFormViewFactory;
import com.appscharles.libs.fxer.switchers.PaneViewSwitcher;
import javafx.fxml.FXML;
import javafx.scene.layout.StackPane;

/**
 * The type 20 panes controller extend.
 */
public class _20_PanesControllerExtend extends _10_NewUserControllerExtend {

    /**
     * The Form pane.
     */
    @FXML
    protected StackPane formPane;

    /**
     * Instantiates a new 20 panes controller extend.
     */
    protected  _20_PanesControllerExtend() {
        addOnInitializeWithSneakyThrow(() -> {
            PaneViewSwitcher contentPane = new PaneViewSwitcher(this.formPane);
            contentPane.switchTo(new UserFormViewFactory(this.user).create());
        });
    }
}
