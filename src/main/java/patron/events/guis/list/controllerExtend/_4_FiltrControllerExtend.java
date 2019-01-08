package patron.events.guis.list.controllerExtend;

import com.appscharles.libs.fxer.models.NavigationPage;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import patron.auth.globals.UserGlobal;
import patron.events.models.Event;
import patron.events.respositories.EventRepository;

import java.util.List;

/**
 * The type 4 filtr controller extend.
 */
public class _4_FiltrControllerExtend extends _2_NavigationControllerExtend {

    /**
     * The Items.
     */
    protected ObservableList<Event> items;

    /**
     * The Filtered items.
     */
    protected ObservableList<Event> filteredItems;

    /**
     * Instantiates a new 4 filtr controller extend.
     */
    protected _4_FiltrControllerExtend() {
        this.addOnInitializeWithSneakyThrow(() -> {
            this.items = FXCollections.observableArrayList();
            this.filteredItems = FXCollections.observableArrayList();
        });

        this.addOnInitializeWithSneakyThrow(() -> {
            this.navigationPageCombobox.setOnAction((event) -> {
                filterItems();
            });
        });

        this.addOnInitializeWithSneakyThrow(() -> {
            loadItems();
        });
    }

    private void filterItems() {
        this.filteredItems.clear();
        NavigationPage navigationPage = this.navigationPageCombobox.getSelectionModel().getSelectedItem();
        if (navigationPage == null){
            return;
        }
        int fromIndex = (navigationPage.getPage() - 1) * ITEMS_PER_PAGE;
        List<Event> filtered = this.items.subList(fromIndex, Math.min(fromIndex + ITEMS_PER_PAGE, this.items.size()));
        this.filteredItems.addAll(filtered);
    }

    /**
     * Load items.
     */
    protected void loadItems() {
        sneakyThrow(() -> {
            this.items.clear();
            List<Event> events = EventRepository.getByType(this.eventType);
            for (Event event : events) {
                if (event.getCreatedBy().equals(UserGlobal.getUser())){
                    this.items.add(event);
                }
            }
        });
        filterItems();
    }
}
