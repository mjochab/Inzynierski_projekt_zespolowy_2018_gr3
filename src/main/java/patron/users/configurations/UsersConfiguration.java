package patron.users.configurations;

/**
 * The type Users configuration.
 */
public class UsersConfiguration {

    private static final String LOG_SECTION = "users";

    private static final String TASK_ID = "users";

    /**
     * Get log section string.
     *
     * @return the string
     */
    public static String getLogSection(){
        return LOG_SECTION;
    }

    /**
     * Get task id string.
     *
     * @return the string
     */
    public static String getTaskId(){
        return TASK_ID; 
    }
}
