package patron.mains.guis.main.controllerExtends;

import patron.mains.guis.widgets.menu.factories.MenuWidgetViewFactory;
import com.appscharles.libs.fxer.switchers.PaneViewSwitcher;
import javafx.fxml.FXML;
import javafx.scene.layout.StackPane;

/**
 * The type 14 menu pane controller extend.
 */
public class _14_MenuPaneControllerExtend extends _10_ContainerPaneControllerExtend {

    /**
     * The Menu pane.
     */
    @FXML
    protected StackPane menuPane;

    /**
     * Instantiates a new 14 menu pane controller extend.
     */
    protected _14_MenuPaneControllerExtend(){
        this.addOnInitializeWithSneakyThrow((resourceBundle)->{
            PaneViewSwitcher paneViewSwitcher = new PaneViewSwitcher(this.menuPane);
            paneViewSwitcher.switchTo(new MenuWidgetViewFactory(this.containerPane).create());
        });
    }
}
