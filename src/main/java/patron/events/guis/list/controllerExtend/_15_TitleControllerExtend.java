package patron.events.guis.list.controllerExtend;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

/**
 * The type 15 title controller extend.
 */
public class _15_TitleControllerExtend extends _10_TableViewControllerExtend {

    /**
     * The Title.
     */
    protected String title;

    /**
     * The Title label.
     */
    @FXML
    protected Label titleLabel;

    /**
     * Instantiates a new 15 title controller extend.
     */
    public _15_TitleControllerExtend(){
        addOnInitializeWithSneakyThrow(()->{
            this.titleLabel.setText(title);
        });
    }


}
