package patron.tickets.factories;

import patron.tickets.enums.TicketType;
import patron.tickets.guis.list.TicketListController;
import com.appscharles.libs.fxer.exceptions.FxerException;
import com.appscharles.libs.fxer.factories.AbstractPrepareViewFactory;
import com.appscharles.libs.fxer.factories.FxViewFactory;
import com.appscharles.libs.fxer.views.FxView;
import javafx.scene.Parent;

import java.io.IOException;

/**
 * The type Ticket view factory.
 */
public class TicketViewFactory extends AbstractPrepareViewFactory {

    private TicketType ticketType;

    private String title;

    /**
     * Instantiates a new Ticket view factory.
     *
     * @param title      the title
     * @param ticketType the ticket type
     */
    public TicketViewFactory(String title, TicketType ticketType) {
        this.ticketType = ticketType;
        this.title = title;
    }

    public Parent create() throws FxerException {
        try {
            FxView fxView = new FxViewFactory("/patron/tickets/guis/list/TicketListView.fxml",
                    "patron/tickets/guis/list/translations/TicketList", new TicketListController(this.title, this.ticketType), this.fXStage)
                    .addStylesheet("com/appscharles/libs/fxer/guis/commons/styles/TableView.css")
                    .addStylesheet("com/appscharles/libs/fxer/guis/commons/styles/Buttons.css")
                    .addStylesheet("com/appscharles/libs/fxer/guis/commons/styles/ComboBox.css")
                   .create();
            return fxView.createView();
        } catch (IOException e) {
            throw new FxerException(e);
        }
    }
}
