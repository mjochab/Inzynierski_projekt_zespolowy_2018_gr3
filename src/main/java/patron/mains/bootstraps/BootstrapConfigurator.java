package patron.mains.bootstraps;

import com.appscharles.libs.aller.exceptions.AllerException;
import com.appscharles.libs.databaser.exceptions.DatabaserException;
import com.appscharles.libs.dialoger.factories.AlertFactory;
import com.appscharles.libs.fxer.exceptions.FxerException;
import com.appscharles.libs.ioer.services.FileWriter;
import com.appscharles.libs.logger.configurators.Log4j2ConsoleFileRoller;
import com.appscharles.libs.logger.services.LoggerConfigurator;
import com.appscharles.libs.proper.exceptions.ProperException;
import com.sun.javafx.application.PlatformImpl;
import javafx.application.Platform;
import javafx.scene.control.Alert;
import jdk.nashorn.internal.objects.Global;
import org.apache.logging.log4j.Level;
import patron.auth.configurations.DefaultAdminConfiguration;
import patron.auth.globals.UserGlobal;
import patron.auth.guis.login.LoginViewFactory;
import patron.mains.guis.popups.CommonPopup;
import patron.mains.managers.app.AppManager;
import patron.mains.managers.app.AppManagerConfiguration;
import patron.mains.managers.database.DatabaseManager;
import patron.mains.managers.database.DatabaseManagerConfiguration;

import java.io.File;
import java.io.IOException;

/**
 * The type Bootstrap configurator.
 */
public class BootstrapConfigurator {

    /**
     * Config.
     *
     * @throws ProperException    the proper exception
     * @throws IOException        the io exception
     * @throws DatabaserException the databaser exception
     * @throws FxerException      the fxer exception
     */
    public void config() throws ProperException, IOException, DatabaserException, FxerException {
        PlatformImpl.startup(() -> {
        });
        AppManager.setConfiguration(new AppManagerConfiguration());
        AppManager.init();
        LoggerConfigurator.config(new Log4j2ConsoleFileRoller(Level.INFO).setLogsDir(new File(AppManager.getDirApp(), "Logs")));
        DatabaseManager.setConfiguration(new DatabaseManagerConfiguration(AppManager.getDirApp(), AppManager.getName(), AppManager.getDatabasePort(), AppManager.getSaltPassword()));
        try{
            File f = new File("app/pro.settings");
            f.getParentFile().mkdirs();
            FileWriter.write(f, "t");
        }catch (Exception e){
            PlatformImpl.runAndWait(()->{
                AlertFactory.create(Alert.AlertType.ERROR, "Brak uprawnień. Nie można utworzyć pliku.", "Aby program działał poprawnie, należy przenieść go do innego folderu lub uruchomić z uprawnieniami administratora.").build().showAndWait();
            });
            Platform.exit();
            System.exit(0);
        }
        DatabaseManager.init();

//        Event ticket = new Event("Title", "Description", 23.33, false, EventType.FLIGHT, UserGlobal.getUser());
//        DBOperator.save(ticket);
//        DBOperator.save(UserGlobal.getUser());

    }
}
