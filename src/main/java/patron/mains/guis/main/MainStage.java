package patron.mains.guis.main;

import patron.mains.managers.app.AppManager;
import com.appscharles.libs.fxer.exceptions.FxerException;
import com.appscharles.libs.fxer.factories.FXStageFactory;
import com.appscharles.libs.fxer.factories.IFXStageFactory;
import com.appscharles.libs.fxer.stages.FXStage;

/**
 * The type Main stage.
 */
public class MainStage {

    /**
     * Launch.
     *
     * @throws FxerException the fxer exception
     */
    public static void launch() throws FxerException {
        IFXStageFactory stageFactory = new FXStageFactory("/patron/mains/guis/main/MainView.fxml",
                "patron/mains/guis/main/translations/Main");
        stageFactory.setIcon(AppManager.getResourceIcon());
        stageFactory.addStylesheet("com/appscharles/libs/fxer/guis/commons/styles/Root.css");
        stageFactory.setController(new MainController());
        FXStage stage = stageFactory.create();
        stage.setOpacity(0);
        stage.showAndWaitFX();
    }
}
