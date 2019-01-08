package patron.users.guis.list.controllerExtend;

import patron.mains.guis.popups.CommonPopup;
import patron.users.factories.UserAddViewFactory;
import javafx.fxml.FXML;

/**
 * The type 30 on actions controller extend.
 */
public class _30_OnActionsControllerExtend extends _10_TableViewControllerExtend {

    /**
     * Cancel.
     */
    @FXML
    public void cancel(){
        this.fxStage.close();
    }

    /**
     * New user.
     */
    @FXML
    public void newUser(){
       sneakyThrow(()->{
           CommonPopup.showAndWaitFx(new UserAddViewFactory());
           loadUsers();
       });
    }
}
