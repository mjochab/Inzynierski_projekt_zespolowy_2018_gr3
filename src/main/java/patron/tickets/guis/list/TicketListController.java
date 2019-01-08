package patron.tickets.guis.list;

import patron.tickets.enums.TicketType;
import patron.tickets.guis.list.controllerExtend._30_OnActionsControllerExtend;

/**
 * The type Ticket list controller.
 */
public class TicketListController extends _30_OnActionsControllerExtend {

    /**
     * Instantiates a new Ticket list controller.
     *
     * @param title      the title
     * @param ticketType the ticket type
     */
    public TicketListController(String title, TicketType ticketType){
        this.title = title;
        this.ticketType = ticketType;
    }
}
