package patron.users.guis.list.controllerExtend;

import patron.mains.guis.popups.CommonPopup;
import patron.users.factories.UserEditViewFactory;
import patron.users.models.User;
import com.appscharles.libs.databaser.operators.DBOperator;
import com.appscharles.libs.fxer.abstracts.AbstractViewControllerFxExtend;
import com.appscharles.libs.fxer.builders.MenuButtonBuilder;
import com.appscharles.libs.fxer.tables.cells.UniversalTableCell;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * The type 10 table view controller extend.
 */
public class _10_TableViewControllerExtend extends AbstractViewControllerFxExtend {

    /**
     * The Table.
     */
    @FXML
    protected TableView<User> table;

    /**
     * The Column login.
     */
    @FXML
    protected TableColumn<String, User> columnLogin;

    /**
     * The Column manager.
     */
    @FXML
    protected TableColumn<User, Node> columnManager;

    /**
     * The Users.
     */
    protected ObservableList<User> users;

    /**
     * Instantiates a new 10 table view controller extend.
     */
    protected _10_TableViewControllerExtend() {


        this.addOnInitializeWithSneakyThrow(() -> {
            this.users = FXCollections.observableArrayList();
            this.table.setItems(this.users);
        });

        this.addOnInitializeWithSneakyThrow(() -> {
            this.columnLogin.setCellValueFactory(new PropertyValueFactory<>("login"));
            this.columnManager.setCellFactory(new UniversalTableCell<User, Node>().forTableColumn((Node node, User user) -> {
                MenuButtonBuilder builder = MenuButtonBuilder.create(this.resourceBundle.getString("view.table.button_menu.manager"))
                        .addMenuItem(this.resourceBundle.getString("view.table.button_menu.item.edit"), (event) -> {
                            sneakyThrow(() -> {
                                CommonPopup.showAndWaitFx(new UserEditViewFactory(user));
                            });
                            loadUsers();
                        }).addMenuItem(this.resourceBundle.getString("view.table.button_menu.item.remove"), (event) -> {
                            sneakyThrow(() -> {
                                DBOperator.delete(user);
                            });
                            loadUsers();
                        });
                return builder.build();
            }));
        });
        this.addOnInitializeWithSneakyThrow(() -> {
            loadUsers();
        });
    }

    /**
     * Load users.
     */
    protected void loadUsers() {
        sneakyThrow(() -> {
            this.users.clear();
            this.users.addAll(DBOperator.getAll(User.class));
        });
    }
}
