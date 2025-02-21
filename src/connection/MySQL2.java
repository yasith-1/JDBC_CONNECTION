package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class MySQL2 {

    private static Connection connection;
    private static final String Username ="root";
    private static final String Password ="Yasith@1.";
    private static final String Database ="sad12";

    public static void createConnection() throws Exception {

        if (connection == null) {
            Class.forName("com.mysql.cj.jdbc.Driver");
             connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/" +Database,Username,Password);
        }
    }

    public static ResultSet executeSearch(String query) throws Exception {                                     //"String query" is a variable to store the type of query

        createConnection();
        return connection.createStatement().executeQuery(query);
    }

    public static Integer executeIUD(String query) throws Exception {                                     //"String query" is a variable to store the type of query

        createConnection();
        return connection.createStatement().executeUpdate(query);
    }
}
