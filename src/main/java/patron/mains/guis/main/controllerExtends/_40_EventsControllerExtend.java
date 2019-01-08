package patron.mains.guis.main.controllerExtends;

import patron.mains.managers.app.AppManager;

/**
 * The type 40 events controller extend.
 */
public class _40_EventsControllerExtend extends _20_StageControllerExtend {

    /**
     * Instantiates a new 40 events controller extend.
     */
    protected _40_EventsControllerExtend() {
        this.addOnShownWithSneakyThrow((event) -> {
            this.splitPane.setDividerPositions(Double.valueOf(AppManager.getAppSettings().getProperty(_40_EventsControllerExtend.class, "split_pane.divider_0", "0.3")));
            getFXStage().setWidth(Double.valueOf(AppManager.getAppSettings().getProperty(_40_EventsControllerExtend.class, "stage.width", String.valueOf(this.fXStage.getWidth()))));
            getFXStage().setHeight(Double.valueOf(AppManager.getAppSettings().getProperty(_40_EventsControllerExtend.class, "stage.height", String.valueOf(this.fXStage.getHeight()))));
            getFXStage().setX(Double.valueOf(AppManager.getAppSettings().getProperty(_40_EventsControllerExtend.class, "stage.position_x", String.valueOf(this.fXStage.getX()))));
            getFXStage().setY(Double.valueOf(AppManager.getAppSettings().getProperty(_40_EventsControllerExtend.class, "stage.position_y", String.valueOf(this.fXStage.getY()))));
            getFXStage().setMaximized(Boolean.valueOf(AppManager.getAppSettings().getProperty(_40_EventsControllerExtend.class, "stage.maximized", "false")));
            getFXStage().setOpacity(1);
        });

        this.addOnCloseWithSneakyThrow(() -> {
            AppManager.getAppSettings().putAndStore(_40_EventsControllerExtend.class, "stage.maximized", String.valueOf(this.fXStage.isMaximized()));
            AppManager.getAppSettings().putAndStore(_40_EventsControllerExtend.class, "stage.width", String.valueOf(this.fXStage.getWidth()));
            AppManager.getAppSettings().putAndStore(_40_EventsControllerExtend.class, "stage.height", String.valueOf(this.fXStage.getHeight()));
            AppManager.getAppSettings().putAndStore(_40_EventsControllerExtend.class, "stage.position_x", String.valueOf(this.fXStage.getX()));
            AppManager.getAppSettings().putAndStore(_40_EventsControllerExtend.class, "stage.position_y", String.valueOf(this.fXStage.getY()));
            AppManager.getAppSettings().putAndStore(_40_EventsControllerExtend.class, "split_pane.divider_0", String.valueOf(this.splitPane.getDividerPositions()[0]));
        });
    }
}
