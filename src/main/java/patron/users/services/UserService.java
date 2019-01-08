package patron.users.services;

import patron.users.enums.RoleName;
import patron.users.models.Role;
import patron.users.models.User;

/**
 * The type User service.
 */
public class UserService {

    /**
     * Add role.
     *
     * @param user     the user
     * @param roleName the role name
     */
    public static void addRole(User user, RoleName roleName){
        if (!hasRole(user, roleName)){
            user.getRoles().add(new Role(roleName));
        }
    }

    /**
     * Remove role.
     *
     * @param user     the user
     * @param roleName the role name
     */
    public static void removeRole(User user, RoleName roleName){
        if (hasRole(user, roleName)){
            user.getRoles().removeIf(role -> role.getRoleName().equals(roleName));
        }
    }

    /**
     * Has role boolean.
     *
     * @param user     the user
     * @param roleName the role name
     * @return the boolean
     */
    public static boolean hasRole(User user, RoleName roleName){
        return user.getRoles().stream().filter(u -> u.getRoleName().equals(roleName)).count() >0;
    }

    /**
     * Has role boolean.
     *
     * @param user      the user
     * @param roleNames the role names
     * @return the boolean
     */
    public static boolean hasRole(User user, RoleName ... roleNames){
        for (RoleName roleName : roleNames) {
            if (hasRole(user, roleName)){
                return true;
            }
        }
        return false;
    }


}
