package patron.mains.bootstraps;

import patron.auth.configurations.DefaultAdminConfiguration;
import patron.auth.globals.UserGlobal;
import patron.auth.guis.login.LoginViewFactory;
import patron.mains.guis.main.MainStage;
import com.appscharles.libs.fxer.sneakers.ExceptionDialogThrowSneaker;
import javafx.application.Platform;
import patron.mains.guis.popups.CommonPopup;

/**
 * The type Bootstrap.
 */
public class Bootstrap {
    /**
     * Main.
     *
     * @param args the args
     */
    public static void main(String[] args){
        ExceptionDialogThrowSneaker.sneaky(()->{
            new BootstrapConfigurator().config();
            DefaultAdminConfiguration.init();
            while(true){
                CommonPopup.showAndWaitFx(new LoginViewFactory());
                MainStage.launch();
                if (!UserGlobal.isReAuth){
                    break;
                } else {
                    UserGlobal.isReAuth = false;
                }
            }

        });

        Platform.exit();
        System.exit(0);
    }
}
