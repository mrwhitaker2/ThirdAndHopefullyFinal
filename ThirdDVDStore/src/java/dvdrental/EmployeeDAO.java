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
                    .prepareStatement("insert into StaffNoBS(Username,Password,first_name,last_name,email) values ( ?, ?, ?, ?, ? )");
          
            preparedStatement.setString(1, employee.getUsername());
            preparedStatement.setString(2, employee.getPassword());
            preparedStatement.setString(3, employee.getFirst_name());
            preparedStatement.setString(4, employee.getLast_name());
            preparedStatement.setString(5, employee.getEmail());
     
            

            preparedStatement.executeUpdate();
            
           

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
}
