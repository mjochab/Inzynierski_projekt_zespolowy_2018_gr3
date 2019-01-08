package patron.events.guis.list;

import patron.events.enums.EventType;
import patron.events.guis.list.controllerExtend._30_OnActionsControllerExtend;

/**
 * The type Event list controller.
 */
public class EventListController extends _30_OnActionsControllerExtend {

    /**
     * Instantiates a new Event list controller.
     *
     * @param title     the title
     * @param eventType the event type
     */
    public EventListController(String title, EventType eventType){
        this.title = title;
        this.eventType = eventType;
    }
}
