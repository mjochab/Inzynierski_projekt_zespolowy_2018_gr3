package patron.mains.guis.main.controllerExtends;

import com.appscharles.libs.fxer.bootstraps.BootstrapCloser;
import com.appscharles.libs.fxer.sneakers.ExceptionDialogThrowSneaker;
import com.appscharles.libs.fxer.switchers.PaneViewSwitcher;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import patron.auth.globals.UserGlobal;

/**
 * The type 10 container pane controller extend.
 */
public class _12_TaskerPaneControllerExtend extends _10_ContainerPaneControllerExtend {

    @FXML
    protected StackPane taskerPane;

    /**
     * Instantiates a new 10 container pane controller extend.
     */
    protected _12_TaskerPaneControllerExtend(){
        this.addOnInitializeWithSneakyThrow((resourceBundle)->{
            PaneViewSwitcher paneViewSwitcher = new PaneViewSwitcher(this.taskerPane);
            Button btn = new Button("Wyloguj");
            btn.setOnAction(event -> {
                UserGlobal.isReAuth = true;
                ExceptionDialogThrowSneaker.sneaky(() -> {
                    this.fXStage.closeFX();
                });
            });
            paneViewSwitcher.switchTo(btn);
        });
    }
}
