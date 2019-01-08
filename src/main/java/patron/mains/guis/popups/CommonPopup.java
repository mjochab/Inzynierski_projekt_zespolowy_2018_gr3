package patron.mains.guis.popups;

import patron.mains.managers.app.AppManager;
import com.appscharles.libs.fxer.exceptions.FxerException;
import com.appscharles.libs.fxer.factories.IPrepareViewFactory;
import com.appscharles.libs.fxer.guis.popup.PopupStage;

/**
 * The type Common popup.
 */
public class CommonPopup {

    /**
     * Show and wait fx.
     *
     * @param prepareViewFactory the prepare view factory
     * @throws FxerException the fxer exception
     */
    public static void showAndWaitFx(IPrepareViewFactory prepareViewFactory) throws FxerException {
        newPopupStage(prepareViewFactory, true).showFx();
    }

    /**
     * Show fx.
     *
     * @param prepareViewFactory the prepare view factory
     * @throws FxerException the fxer exception
     */
    public static void showFx(IPrepareViewFactory prepareViewFactory) throws FxerException {
        newPopupStage(prepareViewFactory, false).showFx();
    }

    private static PopupStage newPopupStage(IPrepareViewFactory prepareViewFactory, Boolean withWait) {
        return new PopupStage(prepareViewFactory)
                .setResourceIcon(AppManager.getResourceIcon())
                .addStylesheet("com/appscharles/libs/fxer/guis/commons/styles/Root.css")
                .setWithWait(withWait);
    }

}
