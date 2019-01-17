package patron.auth.globals;

import patron.users.models.User;

/**
 * The type User global.
 */
public class UserGlobal {

    public static boolean isReAuth = false;

    private static User user;

    /**
     * Gets user.
     *
     * @return the user
     */
    public static User getUser() {
        if (user == null){
            throw new IllegalArgumentException("user is null");
        }
        return user;
    }

    /**
     * Sets user.
     *
     * @param user the user
     */
    public static void setUser(User user) {
        UserGlobal.user = user;
    }
}
