package patron.pp.guis.show.controllerExtend;


import com.appscharles.libs.fxer.abstracts.AbstractViewControllerFxExtend;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import patron.auth.globals.UserGlobal;
import patron.tickets.models.Ticket;
import patron.tickets.respositories.TicketRepository;
import patron.users.enums.RoleName;
import patron.users.services.UserService;

import java.text.NumberFormat;
import java.util.List;
import java.util.stream.Collectors;

/**
 * The type 20 labels controller extend.
 */
public class _20_LabelsControllerExtend extends AbstractViewControllerFxExtend {

    /**
     * The Total ticket sold label.
     */
    @FXML
    protected Label totalTicketSoldLabel;

    /**
     * The Total label.
     */
    @FXML
    protected Label totalLabel;

    /**
     * Instantiates a new 20 labels controller extend.
     */
    protected _20_LabelsControllerExtend(){
        addOnInitializeWithSneakyThrow(()->{
            Double total = 0.0;
            List<Ticket> tickets = TicketRepository.getAll().stream().filter(t->t.getReserved() && t.getReservedBy().equals(UserGlobal.getUser())).collect(Collectors.toList());
            for (Ticket ticket : tickets) {
                total += ticket.getEvent().getAgentCommission();
            }
            if (!UserService.hasRole(UserGlobal.getUser(), RoleName.ADMIN) && UserService.hasRole(UserGlobal.getUser(), RoleName.AGENT)){
                this.totalLabel.setText(NumberFormat.getCurrencyInstance().format(total));
                this.totalTicketSoldLabel.setText(String.valueOf(tickets.size()));
            }
        });
    }
}
