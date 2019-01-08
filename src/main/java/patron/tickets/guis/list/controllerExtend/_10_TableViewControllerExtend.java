package patron.tickets.guis.list.controllerExtend;

import com.appscharles.libs.databaser.operators.DBOperator;
import com.appscharles.libs.dialoger.factories.FileChooserFactory;
import com.appscharles.libs.fxer.sneakers.ExceptionDialogThrowSneaker;
import com.appscharles.libs.fxer.tables.cells.UniversalTableCell;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import patron.auth.globals.UserGlobal;
import patron.events.models.Event;
import patron.tickets.generators.TicketGenerator;
import patron.tickets.models.Ticket;
import patron.users.enums.RoleName;
import patron.users.services.UserService;

import java.io.File;
import java.text.NumberFormat;

/**
 * The type 10 table view controller extend.
 */
public class _10_TableViewControllerExtend extends _4_FiltrControllerExtend {

    private static final Logger logger = LogManager.getLogger(_10_TableViewControllerExtend.class);

    /**
     * The Table.
     */
    @FXML
    protected TableView<Ticket> table;

    /**
     * The Column company.
     */
    @FXML
    protected TableColumn<Ticket, Node> columnCompany;

    /**
     * The Column title.
     */
    @FXML
    protected TableColumn<String, Ticket> columnTitle;

    /**
     * The Column description.
     */
    @FXML
    protected TableColumn<String, Ticket> columnDescription;

    /**
     * The Column price.
     */
    @FXML
    protected TableColumn<Ticket, Node> columnPrice;

    /**
     * The Column reserved.
     */
    @FXML
    protected TableColumn<Ticket, Node> columnReserved;

    /**
     * The Column button reserve.
     */
    @FXML
    protected TableColumn<Ticket, Node> columnButtonReserve;

    /**
     * The Column button generate.
     */
    @FXML
    protected TableColumn<Ticket, Node> columnButtonGenerate;

    /**
     * Instantiates a new 10 table view controller extend.
     */
    protected _10_TableViewControllerExtend() {


        this.addOnInitializeWithSneakyThrow(resourceBundle -> {
            this.table.setItems(this.filteredItems);
        });
        this.addOnInitializeWithSneakyThrow(() -> {
            this.columnPrice.getStyleClass().add("alignment-center");
            this.columnReserved.getStyleClass().add("alignment-center");
            this.columnButtonReserve.getStyleClass().add("alignment-center");
            this.columnButtonGenerate.getStyleClass().add("alignment-center");
        });
        this.addOnInitializeWithSneakyThrow(() -> {
            this.columnCompany.setCellFactory(new UniversalTableCell<Ticket, Node>().forTableColumn((Node node, Ticket ticket) -> {
                return new Label(ticket.getCreatedBy().getLogin());
            }));
            this.columnTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
            this.columnDescription.setCellValueFactory(new PropertyValueFactory<>("description"));
            this.columnReserved.setCellFactory(new UniversalTableCell<Ticket, Node>().forTableColumn((Node node, Ticket ticket) -> {
                CheckBox checkbox = new CheckBox();
                checkbox.setSelected(ticket.getReserved());
                checkbox.setDisable(true);
                return checkbox;
            }));
            this.columnPrice.setCellFactory(new UniversalTableCell<Ticket, Node>().forTableColumn((Node node, Ticket ticket) -> {
                Double price = ticket.getPrice();
                Event event = ticket.getEvent();
                if (!UserService.hasRole(UserGlobal.getUser(), RoleName.ADMIN) && UserService.hasRole(UserGlobal.getUser(), RoleName.AGENT)) {
                    price = ticket.getPrice() - (ticket.getPrice() * ( event.getAgentReduction() / 100));
                }
                return new Label(NumberFormat.getCurrencyInstance().format(price));
            }));
            this.columnButtonGenerate.setCellFactory(new UniversalTableCell<Ticket, Node>().forTableColumn((Node node, Ticket ticket) -> {
               if (ticket.getReserved() && ticket.getReservedBy().equals(UserGlobal.getUser())){
                   Button generateButton = new Button("Generuj bilet");
                   generateButton.setOnAction((event)->{
                       ExceptionDialogThrowSneaker.sneaky(() -> {
                           File file = FileChooserFactory.create("Zapisz wygenerowany bilet")
                                   .addExtensionFilter("Plik PDF (*.pdf)", "*.pdf")
                                   .build().showSaveDialog(null);
                           TicketGenerator.generate(file, ticket);
                       });
                   });
                   return generateButton;
               }
                return new Label();
            }));
            this.columnButtonReserve.setCellFactory(new UniversalTableCell<Ticket, Node>().forTableColumn((Node node, Ticket ticket) -> {
                if (ticket.getReserved()){
                    Button unreserve = new Button("Anuluj rezerwację");
                    unreserve.setOnAction(event -> {
                        ExceptionDialogThrowSneaker.sneaky(() -> {
                            ticket.setReserved(false);
                            ticket.setReservedBy(null);
                            DBOperator.save(ticket);
                            UserGlobal.getUser().getReservedTickets().remove(ticket);
                            DBOperator.save(UserGlobal.getUser());
                            table.getColumns().get(0).setVisible(false);
                            table.getColumns().get(0).setVisible(true);
                        });
                    });
                   return unreserve;
                } else {
                    Button reserve = new Button("Rezerwuj");
                    reserve.setOnAction(event -> {
                        ExceptionDialogThrowSneaker.sneaky(() -> {
                            ticket.setReserved(true);
                            ticket.setReservedBy(UserGlobal.getUser());
                            DBOperator.save(ticket);
                            UserGlobal.getUser().getReservedTickets().add(ticket);
                            DBOperator.save(UserGlobal.getUser());
                            table.getColumns().get(0).setVisible(false);
                            table.getColumns().get(0).setVisible(true);
                        });
                    });
                    return reserve;
                }
            }));
        });
    }
}
