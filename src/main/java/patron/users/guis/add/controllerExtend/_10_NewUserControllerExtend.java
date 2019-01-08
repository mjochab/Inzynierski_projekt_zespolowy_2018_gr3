package patron.users.guis.add.controllerExtend;

import patron.users.models.User;
import com.appscharles.libs.fxer.abstracts.AbstractViewControllerFxExtend;

/**
 * The type 10 new user controller extend.
 */
public class _10_NewUserControllerExtend extends AbstractViewControllerFxExtend {

    /**
     * The User.
     */
    protected User user;

    /**
     * Instantiates a new 10 new user controller extend.
     */
    protected _10_NewUserControllerExtend(){
        this.user = new User();
    }
}
