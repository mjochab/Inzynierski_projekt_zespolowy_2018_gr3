package patron.auth.guis.login.controllerExtend;


import javafx.application.Platform;

/**
 * The type 50 stage controller extend.
 */
public class _50_StageControllerExtend extends _30_OnActionsControllerExtend {

    /**
     * Instantiates a new 50 stage controller extend.
     */
    protected  _50_StageControllerExtend() {
        this.addOnInitialize(resourceBundle -> {
            Platform.runLater(() -> {
                this.fxStage.setTitle(this.resourceBundle.getString("stage.title"));
            });
        });
    }
}
