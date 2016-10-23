package Main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Zhenya on 28.02.2016.
 */
public class Connect {
    String url = "jdbc:oracle:thin:@localhost:1521:xe";
    String name = "Zhenya";
    String password = "crazygarbuz";
  //  Connection cn;

    public Connection GetConnection() {
        Connection con = null;
        try {
            try {
                Class.forName("oracle.jdbc.driver.OracleDriver");
            } catch (ClassNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            con = DriverManager.getConnection(url, name, password);
          //  System.out.println("Connected");
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return con;

    }

}
