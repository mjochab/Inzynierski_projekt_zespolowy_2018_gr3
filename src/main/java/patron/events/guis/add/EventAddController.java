package patron.events.guis.add;


import patron.auth.globals.UserGlobal;
import patron.events.enums.EventType;
import patron.events.guis.add.controllerExtend._50_StageControllerExtend;
import patron.events.models.Event;

/**
 * The type Event add controller.
 */
public class EventAddController extends _50_StageControllerExtend {


    /**
     * Instantiates a new Event add controller.
     *
     * @param title     the title
     * @param eventType the event type
     */
    public EventAddController(String title, EventType eventType) {
        this.title = title;
        this.event = new Event();
        this.event.setCreatedBy(UserGlobal.getUser());
        this.event.setType(eventType);
    }
}
