package datamanagers;

import commons.database.JDBCCredentials;
import model.Product;
import org.jetbrains.annotations.NotNull;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.Result;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static generated.tables.Products.PRODUCTS;

public class DAOProducts {

    private @NotNull
    final Connection connection;
    private @NotNull DSLContext context;
    private static final JDBCCredentials CREDS = JDBCCredentials.DEFAULT;

    public DAOProducts() {
        try {
            connection = DriverManager.getConnection(CREDS.url(), CREDS.login(), CREDS.password());
            context = DSL.using(connection, SQLDialect.POSTGRES);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException("No connection");
        }
    }


    public Result<Record> all() {
        var result = context
                .select()
                .from(PRODUCTS)
                .fetch();
        return result;
    }

    public Result<Record> getProductsWithRightOrg(String org) {
        var result = context
                .select()
                .from(PRODUCTS)
                .where(PRODUCTS.ORGANIZATION.eq(org))
                .fetch();
        return result;
    }

    public List<Product> getListOfProductFromRecord(Result<Record> result){
        var listOfProducts = new ArrayList<Product>();
        for (var record : result) {
            listOfProducts.add(new Product(
                    record.getValue(PRODUCTS.ID),
                    record.getValue(PRODUCTS.ORGANIZATION),
                    record.getValue(PRODUCTS.NAME),
                    record.getValue(PRODUCTS.AMOUNT)));
        }
        return listOfProducts;
    }

    public void save(String name, String org, int amount) {
        context.insertInto(PRODUCTS, PRODUCTS.NAME, PRODUCTS.ORGANIZATION, PRODUCTS.AMOUNT)
                .values(name, org, amount)
                .execute();
    }

    public void delete(String name) {
        context.deleteFrom(PRODUCTS)
                .where(PRODUCTS.NAME.eq(name))
                .execute();
    }

    public boolean isExist(@NotNull String nameOfProduct) {
        var result = context.select()
                .from(PRODUCTS)
                .where(PRODUCTS.NAME.eq(nameOfProduct))
                .fetchOne();
        return result != null;
    }
}
