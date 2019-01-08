package patron.users.guis.edit;


import patron.users.guis.edit.controllerExtend._50_StageControllerExtend;
import patron.users.models.User;

/**
 * The type User edit controller.
 */
public class UserEditController extends _50_StageControllerExtend {

    /**
     * Instantiates a new User edit controller.
     *
     * @param user the user
     */
    public UserEditController(User user){
        this.user = user;
    }
}
