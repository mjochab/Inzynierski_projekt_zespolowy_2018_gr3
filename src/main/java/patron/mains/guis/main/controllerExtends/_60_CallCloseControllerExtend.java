package patron.mains.guis.main.controllerExtends;

import com.appscharles.libs.fxer.bootstraps.BootstrapCloser;
import com.appscharles.libs.fxer.models.BootstrapCloserContainer;
import com.sun.javafx.application.PlatformImpl;

/**
 * The type 60 call close controller extend.
 */
public class _60_CallCloseControllerExtend extends _40_EventsControllerExtend {

    /**
     * Instantiates a new 60 call close controller extend.
     */
    protected _60_CallCloseControllerExtend(){
        this.addOnShownWithSneakyThrow((event)-> {
            BootstrapCloser.addBootstrapCloserContainer(new BootstrapCloserContainer(100, ()->{
                PlatformImpl.runAndWait(()->{
                    _60_CallCloseControllerExtend.this.fXStage.close();
                });
            }));
        });
    }

}
