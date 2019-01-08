package patron.tickets.guis.list.controllerExtend;

import com.appscharles.libs.fxer.cells.UniversalListCell;
import com.appscharles.libs.fxer.counters.ItemsPageCounter;
import com.appscharles.libs.fxer.models.NavigationPage;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import patron.tickets.respositories.TicketRepository;

/**
 * The type 2 navigation controller extend.
 */
public class _2_NavigationControllerExtend extends _1_TypeTicketControllerExtend {

    /**
     * The constant ITEMS_PER_PAGE.
     */
    protected static final Integer ITEMS_PER_PAGE = 30;

    /**
     * The Navigation from label.
     */
    @FXML
    protected Label navigationFromLabel;

    /**
     * The Navigation page combobox.
     */
    @FXML
    protected ComboBox<NavigationPage> navigationPageCombobox;

    /**
     * The Navigation pages.
     */
    protected ObservableList<NavigationPage> navigationPages;

    /**
     * Instantiates a new 2 navigation controller extend.
     */
    protected _2_NavigationControllerExtend(){
        this.addOnInitializeWithSneakyThrow(() -> {
            this.navigationPages = FXCollections.observableArrayList();
            this.navigationPageCombobox.setItems(this.navigationPages);
        });
        this.addOnInitializeWithSneakyThrow(()->{
            this.navigationPageCombobox.setCellFactory(new UniversalListCell<NavigationPage>().forCellFactory((NavigationPage navigationPage) -> {
                return new Label(navigationPage.getPage().toString());
            }));
            this.navigationPageCombobox.setButtonCell(new UniversalListCell<NavigationPage>().forButtonCell((NavigationPage navigationPage) -> {
                return new Label(navigationPage.getPage().toString());
            }));
        });
       this.addOnInitializeWithSneakyThrow(()->{
           loadNavigation();
       });
    }

    /**
     * Load navigation.
     */
    protected void loadNavigation(){
        sneakyThrow(()->{
            Long items = TicketRepository.count();
            Integer pages = new ItemsPageCounter().count(items, ITEMS_PER_PAGE);
            this.navigationFromLabel.setText(pages.toString());
            this.navigationPages.clear();
            for (Integer i = 1; i <= pages; i++) {
                this.navigationPages.add(new NavigationPage(i));
            }
            this.navigationPageCombobox.getSelectionModel().selectFirst();
        });
    }
}
