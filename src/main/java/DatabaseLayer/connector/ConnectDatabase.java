package DatabaseLayer.connector;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectDatabase {

    public static Connection connect(){
        try {
            String url = "jdbc:mysql://localhost:3306/";
            String dbName = "student_data";
            String username = "root";
            String password = "root";
            Connection connection = DriverManager.getConnection(url+dbName, username, password);
            return connection;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

}
