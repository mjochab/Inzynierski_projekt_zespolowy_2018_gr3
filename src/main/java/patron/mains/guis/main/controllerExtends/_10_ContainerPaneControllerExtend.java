package patron.mains.guis.main.controllerExtends;

import patron.tickets.enums.TicketType;
import patron.tickets.factories.TicketViewFactory;
import com.appscharles.libs.fxer.abstracts.AbstractStageControllerFxExtend;
import com.appscharles.libs.fxer.switchers.PaneViewSwitcher;
import javafx.fxml.FXML;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.AnchorPane;

/**
 * The type 10 container pane controller extend.
 */
public class _10_ContainerPaneControllerExtend extends AbstractStageControllerFxExtend {


    /**
     * The Container pane.
     */
    @FXML
    protected AnchorPane containerPane;

    /**
     * The Split pane.
     */
    @FXML
    protected SplitPane splitPane;

    /**
     * Instantiates a new 10 container pane controller extend.
     */
    protected _10_ContainerPaneControllerExtend(){
        this.addOnInitializeWithSneakyThrow((resourceBundle)->{
            PaneViewSwitcher paneViewSwitcher = new PaneViewSwitcher(this.containerPane);
            paneViewSwitcher.switchTo(new TicketViewFactory("Bilety na loty", TicketType.FLIGHT).create());
        });
    }
}
