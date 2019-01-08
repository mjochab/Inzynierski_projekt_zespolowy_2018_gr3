package patron.mains.bootstraps;

import patron.mains.guis.main.MainStage;
import com.appscharles.libs.fxer.sneakers.ExceptionDialogThrowSneaker;
import javafx.application.Platform;

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
            MainStage.launch();
        });

        Platform.exit();
        System.exit(0);
    }
}
