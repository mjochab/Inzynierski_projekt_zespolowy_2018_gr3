package patron.events.guis.add.controllerExtend;


import javafx.application.Platform;

/**
 * The type 50 stage controller extend.
 */
public class _50_StageControllerExtend extends _40_OnActionsControllerExtend {

    /**
     * The Title.
     */
    protected String title;

    /**
     * Instantiates a new 50 stage controller extend.
     */
    protected _50_StageControllerExtend() {
        this.addOnInitialize(resourceBundle -> {
            Platform.runLater(() -> {
                this.fxStage.setTitle(title);
            });
        });
    }
}
