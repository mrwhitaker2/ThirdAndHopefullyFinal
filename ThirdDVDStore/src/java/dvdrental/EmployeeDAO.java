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
public class EmployeeDAO {
    
     private Connection connection;

    public EmployeeDAO() {
        connection = DBConnectionUtil.getConnection();
    }

    public void addEmployee(Employee employee) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("insert into staff(first_name,last_name,address_id,email,store_id,active,username,password,last_update,picture) values ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ? )");
          
            preparedStatement.setString(1, employee.getFirst_name());
            preparedStatement.setString(2, employee.getLast_name());
            preparedStatement.setString(3, employee.getAddress_id());
            preparedStatement.setString(4, employee.getEmail());
            preparedStatement.setString(5, employee.getStore_id());
            preparedStatement.setBoolean(6, employee.getActive());
            preparedStatement.setString(7, employee.getUsername());
            preparedStatement.setString(8, employee.getPassword());
            preparedStatement.setString(9, employee.getLast_update());
            preparedStatement.setString(10, employee.getPicture());
            

            preparedStatement.executeUpdate();
            
           

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
}
