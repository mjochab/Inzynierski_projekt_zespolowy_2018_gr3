package patron.mains.managers.database;

import com.appscharles.libs.databaser.configurators.HibernateC3P0Configurator;
import com.appscharles.libs.databaser.exceptions.DatabaserException;
import com.appscharles.libs.databaser.initializers.IDatabaseConfigurationInitializer;
import com.appscharles.libs.databaser.initializers.MySqlDatabaseConfigurationInitializer;
import com.appscharles.libs.databaser.managers.SFManager;
import com.sun.javafx.application.PlatformImpl;

/**
 * The type Database manager.
 */
public class DatabaseManager {

    private static DatabaseManagerConfiguration configuration;

    /**
     * Init.
     *
     * @throws DatabaserException the databaser exception
     */
    public static void init() throws DatabaserException {
        checkConfiguration();
        PlatformImpl.setImplicitExit(false);
        HibernateC3P0Configurator.setProperties(configuration.getHibernateC3P0());
        IDatabaseConfigurationInitializer initializer = new MySqlDatabaseConfigurationInitializer(
                configuration.getSaltPassword(), configuration.getRememberAccessFile(),
                configuration.getPort(), configuration.getServerDir(), configuration.getAppName(), "patron/mains/managers/database/migrations",
                (sessionFactory) ->{
                    sessionFactory.addPackageToScan("patron");
                    sessionFactory.addPackageToScan("com.appscharles.libs.logger");
                });
        initializer.initialize();
        SFManager.getDefaultSessionFactory();
    }

    private static void checkConfiguration() {
        if (configuration == null) {
            throw new IllegalArgumentException("Set database manager configuration");
        }
    }

    /**
     * Sets configuration.
     *
     * @param configuration the configuration
     */
    public static void setConfiguration(DatabaseManagerConfiguration configuration) {
        DatabaseManager.configuration = configuration;
    }

    /**
     * Gets configuration.
     *
     * @return the configuration
     */
    public static DatabaseManagerConfiguration getConfiguration() {
        return configuration;
    }
}
