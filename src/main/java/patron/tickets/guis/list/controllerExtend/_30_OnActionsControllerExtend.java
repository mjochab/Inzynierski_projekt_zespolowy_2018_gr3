package patron.tickets.guis.list.controllerExtend;

import javafx.fxml.FXML;

/**
 * The type 30 on actions controller extend.
 */
public class _30_OnActionsControllerExtend extends _20_ButtonsControllerExtend {

    /**
     * Refresh.
     */
    @FXML
    public void refresh() {
        loadNavigation();
        loadItems();
    }
}
