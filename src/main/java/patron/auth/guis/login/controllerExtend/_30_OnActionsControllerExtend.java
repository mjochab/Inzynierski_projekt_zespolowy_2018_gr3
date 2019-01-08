package patron.auth.guis.login.controllerExtend;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.util.Callback;
import patron.auth.globals.UserGlobal;
import patron.auth.validators.LoginValidator;
import patron.users.enums.RoleName;
import patron.users.respositories.UserRepository;

/**
 * The type 30 on actions controller extend.
 */
public class _30_OnActionsControllerExtend extends _10_FieldsControllerExtend {

    /**
     * The Authorized.
     */
    protected boolean authorized;

    /**
     * Instantiates a new 30 on actions controller extend.
     */
    public _30_OnActionsControllerExtend() {
        this.authorized = false;

        addOnInitializeWithSneakyThrow((resourceBundle)->{
            this.roleCombo.getItems().addAll(RoleName.values());

            this.roleCombo.setCellFactory(new Callback<ListView<RoleName>, ListCell<RoleName>>() {
                @Override public ListCell<RoleName> call(ListView<RoleName> p) {
                    return new ListCell<RoleName>() {

                        @Override protected void updateItem(RoleName item, boolean empty) {
                            super.updateItem(item, empty);

                            if (item == null || empty) {
                                setGraphic(null);
                                setText(null);
                            } else {
                                String trans = resourceBundle.getString("combo." + item.name().toLowerCase());
                                setText(trans);
                            }
                        }
                    };
                }
            });
            this.roleCombo.setButtonCell(new ListCell<RoleName>(){
                @Override
                protected void updateItem(RoleName item, boolean btl){
                    super.updateItem(item, btl);
                    if(item != null) {
                        setGraphic(null);
                        String trans = resourceBundle.getString("combo." + item.name().toLowerCase());
                        setText(trans);
                    }
                }
            });
        });

        addOnCloseWithSneakyThrow(()->{
            if (!this.authorized){
                Platform.exit();
                System.exit(0);
            }
        });
    }

    /**
     * Cancel.
     */
    @FXML
    public void cancel(){
        this.fxStage.close();
    }

    /**
     * Login.
     */
    @FXML
    public void login(){
       sneakyThrow(()->{
           if (LoginValidator.isValid(this.loginField.getText(), this.passwordField.getText(), this.roleCombo.getValue())){
               UserGlobal.setUser(UserRepository.getByLogin(this.loginField.getText()));
               this.authorized = true;
               cancel();
           }
       });
    }
}
