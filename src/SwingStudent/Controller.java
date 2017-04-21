/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SwingStudent;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author nnd2890
 */
public class Controller {
    // Insert the Admin
    public static void insert(Contact contact) throws SQLException {
        try {
            String query = "INSERT INTO ct (email, password, confirmPassword, phoneNumber)"
                    + "VALUES (?, ?, ?, ?)";
            PreparedStatement preparedStatement = DAO.getConection().prepareStatement(query);
            preparedStatement.setString(1, contact.getEmail());
            preparedStatement.setString(2, contact.getPassword());
            preparedStatement.setString(3, contact.getConfirmPassword());
            preparedStatement.setString(4, contact.getPhone());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
