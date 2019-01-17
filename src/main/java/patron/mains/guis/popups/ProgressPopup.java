package patron.mains.guis.popups;

import patron.mains.managers.app.AppManager;
import com.appscharles.libs.dialoger.builders.AsyncProgressBuilder;
import com.appscharles.libs.fxer.abstracts.IStatusProgressAsynchable;
import com.appscharles.libs.fxer.exceptions.ThrowingConsumer;
import com.appscharles.libs.fxer.sneakers.ExceptionDialogThrowSneaker;

/**
 * The type Progress popup.
 */
public class ProgressPopup {

    /**
     * Show and wait fx.
     *
     * @param statusProgressAsynchable the status progress asynchable
     * @param title                    the title
     * @param statusLabel              the status label
     * @param async                    the async
     * @param inFxThreadAsyncCompleted the in fx thread async completed
     */
    public static void showAndWaitFx(IStatusProgressAsynchable statusProgressAsynchable, String title, String statusLabel, ThrowingConsumer<Exception> async, ThrowingConsumer<Exception> inFxThreadAsyncCompleted){
        ExceptionDialogThrowSneaker.sneaky(() -> {
            AsyncProgressBuilder asyncProgressBuilder = AsyncProgressBuilder.create(statusProgressAsynchable, title, statusLabel, async, inFxThreadAsyncCompleted);
            asyncProgressBuilder.progressStage(progressStage -> {
                progressStage.setResourceIcon(AppManager.getResourceIcon());
                progressStage.getStylesheets().add("patron/mains/guis/main/style.css");
                progressStage.getStylesheets().add("com/appscharles/libs/fxer/guis/commons/styles/Buttons.css");
            });
            asyncProgressBuilder.build().showFx();
        });
    }
}
