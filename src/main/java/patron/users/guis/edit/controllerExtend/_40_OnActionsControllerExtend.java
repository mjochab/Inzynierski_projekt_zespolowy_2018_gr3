package patron.users.guis.edit.controllerExtend;

import com.appscharles.libs.databaser.operators.DBOperator;
import javafx.fxml.FXML;

/**
 * The type 40 on actions controller extend.
 */
public class _40_OnActionsControllerExtend extends _20_PanesControllerExtend {

    /**
     * Save.
     */
    @FXML
    public void save(){
        sneakyThrow(()->{
            DBOperator.save(this.user);
            getFXStage().close();
        });
    }

    /**
     * Cancel.
     */
    @FXML
    public void cancel(){
        getFXStage().close();
    }
}
