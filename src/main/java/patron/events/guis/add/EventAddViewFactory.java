package patron.events.guis.add;

import com.appscharles.libs.fxer.exceptions.FxerException;
import com.appscharles.libs.fxer.factories.AbstractPrepareViewFactory;
import com.appscharles.libs.fxer.factories.FxViewFactory;
import com.appscharles.libs.fxer.views.FxView;
import javafx.scene.Parent;
import patron.events.enums.EventType;

import java.io.IOException;

/**
 * The type Event add view factory.
 */
public class EventAddViewFactory extends AbstractPrepareViewFactory {

    private String title;

    private EventType eventType;

    /**
     * Instantiates a new Event add view factory.
     *
     * @param title     the title
     * @param eventType the event type
     */
    public EventAddViewFactory(String title, EventType eventType) {
        this.title = title;
        this.eventType = eventType;
    }

    public Parent create() throws FxerException {
        try {
            FxViewFactory fxViewFactory = new FxViewFactory("/patron/events/guis/add/EventAddView.fxml",
                    "patron/events/guis/add/translations/EventAdd", new EventAddController(this.title, this.eventType), this.fXStage)
                    .addStylesheet("com/appscharles/libs/fxer/guis/commons/styles/Buttons.css");

            FxView fxView = fxViewFactory.create();

            return fxView.createView();
        } catch (IOException e) {
            throw new FxerException(e);
        }
    }

}