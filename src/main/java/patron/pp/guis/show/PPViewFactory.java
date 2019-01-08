package patron.pp.guis.show;

import com.appscharles.libs.fxer.exceptions.FxerException;
import com.appscharles.libs.fxer.factories.AbstractPrepareViewFactory;
import com.appscharles.libs.fxer.factories.FxViewFactory;
import com.appscharles.libs.fxer.views.FxView;
import javafx.scene.Parent;

import java.io.IOException;

/**
 * The type Pp view factory.
 */
public class PPViewFactory extends AbstractPrepareViewFactory {

    public Parent create() throws FxerException {
        try {
            FxViewFactory fxViewFactory = new FxViewFactory("/patron/pp/guis/show/PPView.fxml",
                    "patron/pp/guis/show/translations/PP", new PPController(), this.fXStage)
                    .addStylesheet("com/appscharles/libs/fxer/guis/commons/styles/Buttons.css");

            FxView fxView = fxViewFactory.create();

            return fxView.createView();
        } catch (IOException e) {
            throw new FxerException(e);
        }
    }

}