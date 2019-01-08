package patron.users.guis.form.controllerExtend;


import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import patron.users.enums.RoleName;
import patron.users.models.Role;
import patron.users.services.UserService;

/**
 * The type 30 controls roles controller extend.
 */
public class _30_ControlsRolesControllerExtend extends _20_FieldsControllerExtend {

    /**
     * The Roles client module checkbox.
     */
    @FXML
    protected CheckBox rolesClientModuleCheckbox;

    /**
     * The Roles agent module checkbox.
     */
    @FXML
    protected CheckBox rolesAgentModuleCheckbox;

    /**
     * The Roles travel agency module checkbox.
     */
    @FXML
    protected CheckBox rolesTravelAgencyModuleCheckbox;

    /**
     * The Roles aviation company module checkbox.
     */
    @FXML
    protected CheckBox rolesAviationCompanyModuleCheckbox;

    /**
     * The Roles admin module checkbox.
     */
    @FXML
    protected CheckBox rolesAdminModuleCheckbox;

    /**
     * Instantiates a new 30 controls roles controller extend.
     */
    protected _30_ControlsRolesControllerExtend(){
        addOnInitializeWithSneakyThrow(()->{
            for (Role role : this.user.getRoles()) {
                if (role.getRoleName().equals(RoleName.CLIENT)){
                    this.rolesClientModuleCheckbox.setSelected(true);
                } else if (role.getRoleName().equals(RoleName.AGENT)){
                    this.rolesAgentModuleCheckbox.setSelected(true);
                } else if (role.getRoleName().equals(RoleName.TRAVEL_AGENCY)){
                    this.rolesTravelAgencyModuleCheckbox.setSelected(true);
                } else if (role.getRoleName().equals(RoleName.AVIATION_COMPANY)){
                    this.rolesAviationCompanyModuleCheckbox.setSelected(true);
                } else if (role.getRoleName().equals(RoleName.ADMIN)){
                    this.rolesAdminModuleCheckbox.setSelected(true);
                }

            }
            this.rolesClientModuleCheckbox.selectedProperty().addListener((args, oldVal, newVal)->{
                if (newVal){
                    UserService.addRole(this.user, RoleName.CLIENT);
                } else {
                    UserService.removeRole(this.user, RoleName.CLIENT);
                }
            });
            this.rolesAgentModuleCheckbox.selectedProperty().addListener((args, oldVal, newVal)->{
                if (newVal){
                    UserService.addRole(this.user, RoleName.AGENT);
                } else {
                    UserService.removeRole(this.user, RoleName.AGENT);
                }
            });
            this.rolesTravelAgencyModuleCheckbox.selectedProperty().addListener((args, oldVal, newVal)->{
                if (newVal){
                    UserService.addRole(this.user, RoleName.TRAVEL_AGENCY);
                } else {
                    UserService.removeRole(this.user, RoleName.TRAVEL_AGENCY);
                }
            });
            this.rolesAviationCompanyModuleCheckbox.selectedProperty().addListener((args, oldVal, newVal)->{
                if (newVal){
                    UserService.addRole(this.user, RoleName.AVIATION_COMPANY);
                } else {
                    UserService.removeRole(this.user, RoleName.AVIATION_COMPANY);
                }
            });
            this.rolesAdminModuleCheckbox.selectedProperty().addListener((args, oldVal, newVal)->{
                if (newVal){
                    UserService.addRole(this.user, RoleName.ADMIN);
                } else {
                    UserService.removeRole(this.user, RoleName.ADMIN);
                }
            });
        });
    }
}
