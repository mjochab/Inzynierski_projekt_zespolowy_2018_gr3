package patron.events.guis.add.controllerExtend;

import com.appscharles.libs.databaser.operators.DBOperator;
import javafx.fxml.FXML;
import patron.auth.globals.UserGlobal;
import patron.events.validators.AddEventValidator;
import patron.tickets.enums.TicketType;
import patron.tickets.models.Ticket;

/**
 * The type 40 on actions controller extend.
 */
public class _40_OnActionsControllerExtend extends _20_FieldsControllerExtend {

    /**
     * Add.
     */
    @FXML
    public void add() {
        sneakyThrow(() -> {
            if (AddEventValidator.isValid(this.ticketTitleField,
                    this.ticketPriceField, this.ticketQuantityField,
                    this.titleField, this.agentReductionField, this.agentCommissionField)) {
                this.event.setTitle(this.titleField.getText());
                this.event.setAgentCommission(Double.valueOf(this.agentCommissionField.getText()));
                this.event.setAgentReduction(Double.valueOf(this.agentReductionField.getText()));
                Integer quantityTickets = Integer.valueOf(this.ticketQuantityField.getText());
                DBOperator.save(this.event);
                UserGlobal.getUser().getGeneratedEvents().add(this.event);
                for (Integer i = 0; i < quantityTickets; i++) {
                    Ticket ticket = new Ticket(this.ticketTitleField.getText(),
                            this.ticketDescriptionField.getText(),
                            Double.valueOf(this.ticketPriceField.getText()));
                    ticket.setCreatedBy(UserGlobal.getUser());
                    switch (this.event.getType()) {
                        case TOUR:
                            ticket.setType(TicketType.TOUR);
                            break;
                        case TURNUS:
                            ticket.setType(TicketType.TURNUS);
                            break;
                        case FLIGHT:
                            ticket.setType(TicketType.FLIGHT);
                            break;
                    }
                    ticket.setEvent(this.event);
                    DBOperator.save(ticket);
                    UserGlobal.getUser().getGeneratedTickets().add(ticket);
                }
                DBOperator.save(UserGlobal.getUser());
                getFXStage().close();
            }
        });
    }

    /**
     * Cancel.
     */
    @FXML

    public void cancel() {
        getFXStage().close();
    }
}
