/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SwingStudent;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author nnd2890
 */
public class DAO {
    private static final String CONECTION_STRING_PREFIX = "jdbc:mysql:";
    private static final String HOST_WITH_PORT = "//localhost:3306/";
    private static final String DATABASE = "contact";
    private static final String DATABASE_USER = "?user=root";
    private static final String DATABASE_PASSWORD = "";
    
    public static Connection getConection() throws SQLException{
        String connectionString = CONECTION_STRING_PREFIX 
                + HOST_WITH_PORT 
                + DATABASE 
                + DATABASE_USER 
                + DATABASE_PASSWORD;
        Connection conn = DriverManager.getConnection(connectionString);
        System.out.println(connectionString);
        return conn;
    }
}
