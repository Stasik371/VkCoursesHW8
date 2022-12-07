package datamanagers;

import commons.database.JDBCCredentials;
import model.Organization;
import org.jetbrains.annotations.NotNull;
import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static generated.tables.Organizations.ORGANIZATIONS;

public class DAOOrganizations {
    private @NotNull final Connection connection;
    private @NotNull final DSLContext context;
    private static final JDBCCredentials CREDS = JDBCCredentials.DEFAULT;

    public DAOOrganizations() {
        try {
            connection = DriverManager.getConnection(CREDS.url(), CREDS.login(), CREDS.password());
            context = DSL.using(connection, SQLDialect.POSTGRES);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException("No connection");
        }
    }


    public void save(@NotNull Organization organization) {
        context.insertInto(ORGANIZATIONS, ORGANIZATIONS.NAME)
                .values(organization.getName())
                .execute();
    }

    public boolean isExist(String name) {
        var result = context.select()
                .from(ORGANIZATIONS)
                .where(ORGANIZATIONS.NAME.eq(name))
                .fetchOne();
        return result == null;
    }
}
