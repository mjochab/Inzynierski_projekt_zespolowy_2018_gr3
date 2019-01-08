package patron.events.guis.list.controllerExtend;

import javafx.fxml.FXML;
import patron.events.guis.add.EventAddViewFactory;
import patron.mains.guis.popups.CommonPopup;

/**
 * The type 30 on actions controller extend.
 */
public class _30_OnActionsControllerExtend extends _20_ButtonsControllerExtend {

    /**
     * Add.
     */
    @FXML
    public void add(){
        sneakyThrow(()->{
            CommonPopup.showAndWaitFx(new EventAddViewFactory(this.title, this.eventType));
            refresh();
        });
    }

    /**
     * Refresh.
     */
    @FXML
    public void refresh() {
        loadNavigation();
        loadItems();
    }
}
