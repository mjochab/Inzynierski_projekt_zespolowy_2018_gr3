package patron.mains.managers.database;

import java.io.File;
import java.util.Properties;

/**
 * The type Database manager configuration.
 */
public class DatabaseManagerConfiguration {

    private File serverDir;

    private File rememberAccessFile;

    private String saltPassword;

    private String appName;

    private Integer port;

    private Properties hibernateC3P0;

    /**
     * Instantiates a new Database manager configuration.
     *
     * @param dirApp       the dir app
     * @param appName      the app name
     * @param port         the port
     * @param saltPassword the salt password
     */
    public DatabaseManagerConfiguration(File dirApp, String appName, Integer port,  String saltPassword) {
        this.appName = appName;
        this.port = port;
        this.saltPassword = saltPassword;
        this.serverDir = new File(File.listRoots()[0], "AppsCharles/Apps/Stocker/Databases");
        this.rememberAccessFile = new File(dirApp, "Settings/RememberAccessDatabase.properties");
        this.hibernateC3P0 = new Properties();
        this.hibernateC3P0.put("hibernate.connection.provider_class", "org.hibernate.c3p0.internal.C3P0ConnectionProvider");
        this.hibernateC3P0.put("hibernate.c3p0.min_size", "1");
        this.hibernateC3P0.put("hibernate.c3p0.max_size", "19");
        this.hibernateC3P0.put("hibernate.c3p0.timeout", "120");
        this.hibernateC3P0.put("hibernate.c3p0.max_statements", "10");
        this.hibernateC3P0.put("hibernate.c3p0.idle_test_period", "3000");

    }

    /**
     * Gets server dir.
     *
     * @return the server dir
     */
    public File getServerDir() {
        return serverDir;
    }

    /**
     * Sets server dir.
     *
     * @param serverDir the server dir
     */
    public void setServerDir(File serverDir) {
        this.serverDir = serverDir;
    }

    /**
     * Gets port.
     *
     * @return the port
     */
    public Integer getPort() {
        return port;
    }

    /**
     * Gets remember access file.
     *
     * @return the remember access file
     */
    public File getRememberAccessFile() {
        return rememberAccessFile;
    }

    /**
     * Sets remember access file.
     *
     * @param rememberAccessFile the remember access file
     */
    public void setRememberAccessFile(File rememberAccessFile) {
        this.rememberAccessFile = rememberAccessFile;
    }

    /**
     * Gets salt password.
     *
     * @return the salt password
     */
    public String getSaltPassword() {
        return saltPassword;
    }

    /**
     * Gets app name.
     *
     * @return the app name
     */
    public String getAppName() {
        return appName;
    }

    /**
     * Gets hibernate c 3 p 0.
     *
     * @return the hibernate c 3 p 0
     */
    public Properties getHibernateC3P0() {
        return hibernateC3P0;
    }

    /**
     * Sets hibernate c 3 p 0.
     *
     * @param hibernateC3P0 the hibernate c 3 p 0
     */
    public void setHibernateC3P0(Properties hibernateC3P0) {
        this.hibernateC3P0 = hibernateC3P0;
    }
}
