package patron.events.guis.list.controllerExtend;

import com.appscharles.libs.databaser.operators.DBOperator;
import com.appscharles.libs.fxer.sneakers.ExceptionDialogThrowSneaker;
import com.appscharles.libs.fxer.tables.cells.UniversalTableCell;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import patron.auth.globals.UserGlobal;
import patron.events.models.Event;
import patron.tickets.models.Ticket;

/**
 * The type 10 table view controller extend.
 */
public class _10_TableViewControllerExtend extends _4_FiltrControllerExtend {

    private static final Logger logger = LogManager.getLogger(_10_TableViewControllerExtend.class);

    /**
     * The Table.
     */
    @FXML
    protected TableView<Event> table;

    /**
     * The Column title.
     */
    @FXML
    protected TableColumn<String, Event> columnTitle;

    /**
     * The Column generated ticket count.
     */
    @FXML
    protected TableColumn<Event, Node> columnGeneratedTicketCount;

    /**
     * The Column reserved ticket count.
     */
    @FXML
    protected TableColumn<Event, Node> columnReservedTicketCount;

    /**
     * The Column button remove.
     */
    @FXML
    protected TableColumn<Event, Node> columnButtonRemove;

    /**
     * Instantiates a new 10 table view controller extend.
     */
    protected _10_TableViewControllerExtend() {


        this.addOnInitializeWithSneakyThrow(resourceBundle -> {
            this.table.setItems(this.filteredItems);
        });
        this.addOnInitializeWithSneakyThrow(() -> {
            this.columnGeneratedTicketCount.getStyleClass().add("alignment-center");
            this.columnReservedTicketCount.getStyleClass().add("alignment-center");
            this.columnButtonRemove.getStyleClass().add("alignment-center");
        });
        this.addOnInitializeWithSneakyThrow(() -> {
            this.columnTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
           this.columnGeneratedTicketCount.setCellFactory(new UniversalTableCell<Event, Node>().forTableColumn((Node node, Event event) -> {
                return new Label(String.valueOf(event.getTickets().size()));
            }));
            this.columnReservedTicketCount.setCellFactory(new UniversalTableCell<Event, Node>().forTableColumn((Node node, Event event) -> {
                return new Label(String.valueOf(event.getTickets().stream().filter(Ticket::getReserved).count()));
            }));
            this.columnButtonRemove.setCellFactory(new UniversalTableCell<Ticket, Node>().forTableColumn((Node node, Event event) -> {
                Button generateButton = new Button("Usuń");
                generateButton.setOnAction((e)->{
                    ExceptionDialogThrowSneaker.sneaky(() -> {
                        UserGlobal.getUser().getGeneratedEvents().remove(event);
                        DBOperator.save(UserGlobal.getUser());
                        for (Ticket ticket : event.getTickets()) {
                            DBOperator.delete(ticket);
                        }
                        DBOperator.delete(event);
                        loadItems();
                    });
                });
                return generateButton;
            }));
        });
    }
}
