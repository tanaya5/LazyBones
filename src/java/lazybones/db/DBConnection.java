package lazybones.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    static Connection conn = null;

    public static Connection connect() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://127.0.0.1:3306/summarization";
            conn = DriverManager.getConnection(url, "root", "system");
        } catch (Exception e) {
            System.out.println(e);
        }
        return conn;
    }
}
