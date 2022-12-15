package commons.database;

import org.flywaydb.core.Flyway;
import org.jetbrains.annotations.NotNull;

public class FlyWayInitializer {
    private static final @NotNull
    JDBCCredentials CREDS = JDBCCredentials.DEFAULT;

    public static void initDB() {
        final Flyway flyway = Flyway
                .configure()
                .dataSource(CREDS.url(), CREDS.login(), CREDS.password())
                .locations("")
                .cleanDisabled(false)
                .load();
        flyway.clean();
        flyway.migrate();
    }
}

