package patron.mains.managers.app;

import com.appscharles.libs.processer.extractors.CurrentPIDExtractor;
import com.appscharles.libs.proper.containers.CryptedProperties;
import com.appscharles.libs.proper.exceptions.ProperException;

import java.io.File;

/**
 * The type App manager.
 */
public class AppManager {

    private static AppManagerConfiguration configuration;

    private static CryptedProperties profileSettings;

    private static CryptedProperties appSettings;

    /**
     * Get configuration app manager configuration.
     *
     * @return the app manager configuration
     */
    public static AppManagerConfiguration getConfiguration(){
        return configuration;
    }

    /**
     * Get name string.
     *
     * @return the string
     */
    public static String getName(){
        checkConfiguration();
        return configuration.getProperties().getProperty("name");
    }

    /**
     * Get version string.
     *
     * @return the string
     */
    public static String getVersion(){
        checkConfiguration();
        return configuration.getProperties().getProperty("version");
    }

    /**
     * Get display name string.
     *
     * @return the string
     */
    public static String getDisplayName(){
        checkConfiguration();
        return configuration.getProperties().getProperty("displayName");
    }

    /**
     * Get my pid long.
     *
     * @return the long
     */
    public static Long getMyPid(){
        return CurrentPIDExtractor.extract();
    }


    /**
     * Get salt password string.
     *
     * @return the string
     */
    public static String getSaltPassword(){
        checkConfiguration();
        return configuration.getProperties().getProperty("saltPassword");
    }

    /**
     * Get executable file name string.
     *
     * @return the string
     */
    public static String getExecutableFileName(){
        checkConfiguration();
        return configuration.getProperties().getProperty("executableFileName");
    }


    /**
     * Get resource icon string.
     *
     * @return the string
     */
    public static String getResourceIcon(){
        checkConfiguration();
        return configuration.getResourceIcon();
    }

    private static void checkConfiguration() {
        if (configuration == null) {
            throw new IllegalArgumentException("Set app manager configuration");
        }
    }

    private static void checkInit() {
       if (appSettings == null) {
            throw new IllegalArgumentException("App settings is not init.");
        } else if (profileSettings == null) {
            throw new IllegalArgumentException("Profile settings is not init.");
        }
    }

    /**
     * Sets configuration.
     *
     * @param configuration the configuration
     */
    public static void setConfiguration(AppManagerConfiguration configuration) {
        AppManager.configuration = configuration;
    }

    /**
     * Get dir app file.
     *
     * @return the file
     */
    public static File getDirApp(){
        checkConfiguration();
        return configuration.getAppDir();
    }

    /**
     * Get database port integer.
     *
     * @return the integer
     */
    public static Integer getDatabasePort(){
        checkConfiguration();
        return Integer.valueOf(configuration.getProperties().getProperty("databasePort"));

    }

    /**
     * Gets profile settings.
     *
     * @return the profile settings
     */
    public static CryptedProperties getProfileSettings() {
        checkConfiguration();
        checkInit();
        return profileSettings;
    }


    /**
     * Init.
     *
     * @throws ProperException the proper exception
     */
    public static void init() throws ProperException {
        profileSettings = new CryptedProperties();
        profileSettings.load(configuration.getProfileSettingsFile(), getSaltPassword());
        appSettings = new CryptedProperties();
        appSettings.load(configuration.getAppSettingsFile(), getSaltPassword());
    }

    /**
     * Gets app settings.
     *
     * @return the app settings
     */
    public static CryptedProperties getAppSettings() {
        checkConfiguration();
        checkInit();
        return appSettings;
    }

    /**
     * Get dir images auter file.
     *
     * @return the file
     */
    public static File getDirImagesAuter(){
        checkConfiguration();
        checkInit();
        return new File(configuration.getDataDir(), "Auter");
    }
}
