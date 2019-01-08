package patron.mains.guis.main.controllerExtends;

import javafx.application.Platform;
import patron.mains.managers.app.AppManager;

/**
 * The type 20 stage controller extend.
 */
public class _20_StageControllerExtend extends _14_MenuPaneControllerExtend {

    /**
     * Instantiates a new 20 stage controller extend.
     */
    protected _20_StageControllerExtend(){
        this.addOnInitialize(resourceBundle ->{
            Platform.runLater(()->{
                this.fXStage.setTitle(AppManager.getDisplayName() + " - " + resourceBundle.getString("stage.title.version") +" "+ AppManager.getVersion());
            });
        });
    }
}
