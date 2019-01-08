package patron.events.factories;

import com.appscharles.libs.fxer.exceptions.FxerException;
import com.appscharles.libs.fxer.factories.AbstractPrepareViewFactory;
import com.appscharles.libs.fxer.factories.FxViewFactory;
import com.appscharles.libs.fxer.views.FxView;
import javafx.scene.Parent;
import patron.events.enums.EventType;
import patron.events.guis.list.EventListController;

import java.io.IOException;

/**
 * The type Event view factory.
 */
public class EventViewFactory extends AbstractPrepareViewFactory {

    private EventType eventType;

    private String title;

    /**
     * Instantiates a new Event view factory.
     *
     * @param title     the title
     * @param eventType the event type
     */
    public EventViewFactory(String title, EventType eventType) {
        this.eventType = eventType;
        this.title = title;
    }

    public Parent create() throws FxerException {
        try {
            FxView fxView = new FxViewFactory("/patron/events/guis/list/EventListView.fxml",
                    "patron/events/guis/list/translations/EventList", new EventListController(this.title, this.eventType), this.fXStage)
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
