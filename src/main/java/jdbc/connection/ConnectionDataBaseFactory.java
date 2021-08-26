package jdbc.connection;
import org.postgresql.ds.PGSimpleDataSource;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionDataBaseFactory {

    private final DataSource dataSource;

    public static Connection getConnection() throws SQLException {
        return SingletonHelper.INSTANCE.dataSource.getConnection();
    }



    private ConnectionDataBaseFactory() {

        PGSimpleDataSource pgSimpleDataSource = new PGSimpleDataSource();
        try {
            String name = "postgres";
            String url = "jdbc:postgresql://localhost:5432/university";
            String password = "postgres";
            pgSimpleDataSource.setUser(name);
            pgSimpleDataSource.setUrl(url);
            pgSimpleDataSource.setPassword(password);
            String driveClazz = "org.postgresql.Driver";
            Class.forName(driveClazz);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException();
        }

        dataSource = pgSimpleDataSource;

    }

    private static class SingletonHelper {
        private static final ConnectionDataBaseFactory INSTANCE = new ConnectionDataBaseFactory();
    }



}


