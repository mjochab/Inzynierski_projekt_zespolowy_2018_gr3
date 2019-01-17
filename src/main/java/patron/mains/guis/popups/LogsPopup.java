package patron.mains.guis.popups;

import patron.mains.managers.app.AppManager;
import com.appscharles.libs.fxer.controls.UTF8Control;
import com.appscharles.libs.fxer.guis.popup.PopupStage;
import com.appscharles.libs.fxer.sneakers.ExceptionDialogThrowSneaker;
import com.appscharles.libs.logger.factories.LogListViewFactory;

import java.util.ResourceBundle;

/**
 * The type Logs popup.
 */
public class LogsPopup {

    /**
     * Show and wait fx.
     */
    public static void showAndWaitFx(){
        ExceptionDialogThrowSneaker.sneaky(() -> {
            new PopupStage(new LogListViewFactory()
                    .setSectionsResourceBundle(ResourceBundle.getBundle("patron/mains/guis/popups/translations/LogsPopup", new UTF8Control()))
                    .addStylesheet("com/appscharles/libs/fxer/guis/commons/styles/TableView.css")
                    .addStylesheet("com/appscharles/libs/fxer/guis/commons/styles/Buttons.css")
                    .setAlertDetailsLogResourceIcon(AppManager.getResourceIcon())
            ).setResourceIcon(AppManager.getResourceIcon())
                    .addStylesheet("patron/mains/guis/main/style.css")
                    .showFx();

        });
    }
}
