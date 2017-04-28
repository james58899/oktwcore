package one.oktw.sponge.internal;

import org.slf4j.Logger;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.service.sql.SqlService;

import javax.sql.DataSource;
import java.nio.file.Path;
import java.sql.SQLException;

import static one.oktw.sponge.Core.getCore;

public class DatabaseManager {
    private Logger logger = getCore().getLogger();
    private DataSource database;

    public DatabaseManager(Path privatePluginDir) {
        logger.info("Loading Database...");
        try {
            database = Sponge.getServiceManager().provide(SqlService.class).get().getDataSource(getCore(), "jdbc:h2:database");
        } catch (SQLException e) {
            logger.error("Load database failed!", e);
        }
    }

    public DataSource getDatabase() {
        return database;
    }
}
