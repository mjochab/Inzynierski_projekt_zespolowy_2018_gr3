package patron.events.guis.add.controllerExtend;


import javafx.fxml.FXML;
import javafx.scene.control.TextField;

/**
 * The type 20 fields controller extend.
 */
public class _20_FieldsControllerExtend extends _10_EventControllerExtend {

    /**
     * The Title field.
     */
    @FXML
    protected TextField titleField;

    /**
     * The Agent reduction field.
     */
    @FXML
    protected TextField agentReductionField;

    /**
     * The Agent commission field.
     */
    @FXML
    protected TextField agentCommissionField;

    /**
     * The Ticket title field.
     */
    @FXML
    protected TextField ticketTitleField;

    /**
     * The Ticket description field.
     */
    @FXML
    protected TextField ticketDescriptionField;

    /**
     * The Ticket quantity field.
     */
    @FXML
    protected TextField ticketQuantityField;

    /**
     * The Ticket price field.
     */
    @FXML
    protected TextField ticketPriceField;

    /**
     * Instantiates a new 20 fields controller extend.
     */
    protected  _20_FieldsControllerExtend(){
        addOnInitializeWithSneakyThrow(()->{
            this.agentReductionField.setText("0");
            this.agentCommissionField.setText("0");
            this.ticketPriceField.setText("0.00");
        });
    }
}
