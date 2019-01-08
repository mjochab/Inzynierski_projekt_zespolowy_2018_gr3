package patron.mains.managers.app;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLDecoder;
import java.util.Properties;

/**
 * The type App manager configuration.
 */
public class AppManagerConfiguration {

    private Properties properties;

    private String resourceIcon;

    private File profileSettingsFile;

    private File appSettingsFile;

    private Long maxTimeClose;

    private File appDir;

    private File dataDir;

    /**
     * Instantiates a new App manager configuration.
     *
     * @throws IOException the io exception
     */
    public AppManagerConfiguration() throws IOException {
        this.properties = new Properties();
        this.appDir =  new File(URLDecoder.decode(AppManagerConfiguration.class.getProtectionDomain().getCodeSource().getLocation().getPath(), "UTF-8"));
        if (this.appDir.isFile()){
            this.appDir = this.appDir.getParentFile();
        }
        this.resourceIcon = "/patron/mains/guis/main/images/MainIcon.png";
        this.profileSettingsFile = new File(System.getProperty("user.home"), "appscharles/apps/stocker/profileSettings.properties");
        this.appSettingsFile = new File( this.appDir , "Settings/app.properties");
        InputStream input = getClass().getClassLoader().getResourceAsStream("patron/mains/managers/app/AppManagerConfiguration.properties");
        this.properties.load(input);
        this.maxTimeClose = 60000L;
        this.dataDir = new File(this.appDir, "Data");
    }

    /**
     * Gets properties.
     *
     * @return the properties
     */
    public Properties getProperties() {
        return properties;
    }

    /**
     * Sets properties.
     *
     * @param properties the properties
     */
    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    /**
     * Gets resource icon.
     *
     * @return the resource icon
     */
    public String getResourceIcon() {
        return resourceIcon;
    }

    /**
     * Sets resource icon.
     *
     * @param resourceIcon the resource icon
     */
    public void setResourceIcon(String resourceIcon) {
        this.resourceIcon = resourceIcon;
    }

    /**
     * Gets profile settings file.
     *
     * @return the profile settings file
     */
    public File getProfileSettingsFile() {
        return profileSettingsFile;
    }

    /**
     * Sets profile settings file.
     *
     * @param profileSettingsFile the profile settings file
     */
    public void setProfileSettingsFile(File profileSettingsFile) {
        this.profileSettingsFile = profileSettingsFile;
    }

    /**
     * Gets app settings file.
     *
     * @return the app settings file
     */
    public File getAppSettingsFile() {
        return appSettingsFile;
    }

    /**
     * Sets app settings file.
     *
     * @param appSettingsFile the app settings file
     */
    public void setAppSettingsFile(File appSettingsFile) {
        this.appSettingsFile = appSettingsFile;
    }

    /**
     * Gets max time close.
     *
     * @return the max time close
     */
    public Long getMaxTimeClose() {
        return maxTimeClose;
    }

    /**
     * Sets max time close.
     *
     * @param maxTimeClose the max time close
     */
    public void setMaxTimeClose(Long maxTimeClose) {
        this.maxTimeClose = maxTimeClose;
    }

    /**
     * Gets app dir.
     *
     * @return the app dir
     */
    public File getAppDir() {
        return appDir;
    }

    /**
     * Sets app dir.
     *
     * @param appDir the app dir
     */
    public void setAppDir(File appDir) {
        this.appDir = appDir;
    }

    /**
     * Gets data dir.
     *
     * @return the data dir
     */
    public File getDataDir() {
        return dataDir;
    }

    /**
     * Sets data dir.
     *
     * @param dataDir the data dir
     */
    public void setDataDir(File dataDir) {
        this.dataDir = dataDir;
    }
}
