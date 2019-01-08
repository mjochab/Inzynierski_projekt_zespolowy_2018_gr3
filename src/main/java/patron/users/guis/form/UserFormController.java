package patron.users.guis.form;


import patron.users.guis.form.controllerExtend._30_ControlsRolesControllerExtend;
import patron.users.models.User;

import javax.annotation.Nonnull;

/**
 * The type User form controller.
 */
public class UserFormController extends _30_ControlsRolesControllerExtend {


    /**
     * Instantiates a new User form controller.
     *
     * @param user the user
     */
    public UserFormController(@Nonnull User user) {
        this.user = user;
    }
}
