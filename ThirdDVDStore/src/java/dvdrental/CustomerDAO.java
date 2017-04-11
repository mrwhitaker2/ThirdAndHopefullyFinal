/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dvdrental;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author mrwhi
 */
public class CustomerDAO
{

    private Connection connection;

    public CustomerDAO()
    {
        connection = DBConnectionUtil.getConnection();
    }

    public void addCustomer(Customer customer)
    {
        try
        {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("insert into CustomerNoBS(Username,Password,Customer_Pref,Payment,Email) values ( ?, ?, ?, ?, ? )");

            preparedStatement.setString(1, customer.getUsername());
            preparedStatement.setString(2, customer.getPassword());
            preparedStatement.setString(3, customer.getCustomer_Pref());
            preparedStatement.setString(4, customer.getPayment());
            preparedStatement.setString(5, customer.getEmail());

            preparedStatement.executeUpdate();

        } catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    public void checkLogin(Customer customer)
    {
        try
        {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("select * from CustomerNoBS where Username=?");

            preparedStatement.setString(1, customer.getUsername());
            

            preparedStatement.executeUpdate();

        } catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
}
