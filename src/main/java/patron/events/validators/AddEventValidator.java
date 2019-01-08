package patron.events.validators;

import com.appscharles.libs.dialoger.factories.AlertFactory;
import com.appscharles.libs.fxer.controls.UTF8Control;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import patron.mains.managers.app.AppManager;

import java.util.ResourceBundle;

/**
 * The type Add event validator.
 */
public class AddEventValidator {

    /**
     * Is valid boolean.
     *
     * @param ticketTitleField     the ticket title field
     * @param ticketPriceField     the ticket price field
     * @param ticketQuantityField  the ticket quantity field
     * @param titleField           the title field
     * @param agentReductionField  the agent reduction field
     * @param agentCommissionField the agent commission field
     * @return the boolean
     */
    public static boolean isValid(TextField ticketTitleField,
                                  TextField ticketPriceField,
                                  TextField ticketQuantityField,
                                  TextField titleField,
                                  TextField agentReductionField,
                                  TextField agentCommissionField) {
        ResourceBundle resourceBundle = ResourceBundle.getBundle("patron/events/validators/translations/AddEventDialogValidator", new UTF8Control());
        if (ticketTitleField.getText().isEmpty()){
            AlertFactory.create(Alert.AlertType.WARNING, resourceBundle.getString("alert.warning.title"), "Brak tytułu biletu.").setIconStageResource(AppManager.getResourceIcon()).build().showAndWait();
            return false;
        }
        if (ticketPriceField.getText().isEmpty()){
            AlertFactory.create(Alert.AlertType.WARNING, resourceBundle.getString("alert.warning.title"), "Brak ceny biletu.").setIconStageResource(AppManager.getResourceIcon()).build().showAndWait();
            return false;
        }
        if (ticketQuantityField.getText().isEmpty()){
            AlertFactory.create(Alert.AlertType.WARNING, resourceBundle.getString("alert.warning.title"), "Brak ilości biletów.").setIconStageResource(AppManager.getResourceIcon()).build().showAndWait();
            return false;
        }
        if (titleField.getText().isEmpty()){
            AlertFactory.create(Alert.AlertType.WARNING, resourceBundle.getString("alert.warning.title"), "Brak nazwy wydarzenia.").setIconStageResource(AppManager.getResourceIcon()).build().showAndWait();
            return false;
        }
        if (agentReductionField.getText().isEmpty()){
            AlertFactory.create(Alert.AlertType.WARNING, resourceBundle.getString("alert.warning.title"), "Brak obniżki dla agenta.").setIconStageResource(AppManager.getResourceIcon()).build().showAndWait();
            return false;
        }
        if (agentCommissionField.getText().isEmpty()){
            AlertFactory.create(Alert.AlertType.WARNING, resourceBundle.getString("alert.warning.title"), "Brak prowizji dla agenta.").setIconStageResource(AppManager.getResourceIcon()).build().showAndWait();
            return false;
        }
        return true;
    }
}
