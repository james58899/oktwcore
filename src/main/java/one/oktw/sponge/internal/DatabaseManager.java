package one.oktw.sponge.internal;

import org.slf4j.Logger;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.service.sql.SqlService;

import javax.sql.DataSource;
import java.sql.SQLException;

import static one.oktw.sponge.Core.getCore;

public class DatabaseManager {
    private Logger logger = getCore().getLogger();
    private DataSource database;

    public DatabaseManager() {
        logger.info("Init Database...");
        try {
            database = Sponge.getServiceManager().provide(SqlService.class).get().getDataSource("jboc:h2:core.db");
        } catch (SQLException e) {
            logger.error(e.getMessage());
        }
    }
}
