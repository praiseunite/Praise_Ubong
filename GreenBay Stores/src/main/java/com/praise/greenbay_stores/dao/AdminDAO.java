package com.praise.greenbay_stores.dao;

import com.praise.greenbay_stores.model.Admin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AdminDAO {
    public int registerAdmin(Admin admin)throws ClassNotFoundException{
        String INSERT_USERS_SQL = "INSERT INTO Min-page" +
                " (admin_id, username, password, fname, address, contact) VALUES  " +
                " (?, ?, ?, ?, ?, ?); ";

        int result = 0;
        Class.forName("com.mysql.jdbc.Driver");

        //create a statement using connection object.
        try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:8085/GreenBay_Stores_war_exploded/",
                "Praise", "Decagon");
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
                preparedStatement.setInt(1,1);
                preparedStatement.setString(2, admin.getUsername());
                preparedStatement.setString(3, admin.getPassword());
                preparedStatement.setString(4, admin.getFname());
                preparedStatement.setString(5, admin.getAddress());
                preparedStatement.setString(6, admin.getContact());
            System.out.println(preparedStatement);

            //Execute the query or Update the query.
            result  = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
//            System.out.println("Internal Error");
//            throw new RuntimeException(e);
        }
        return result;
    }
    private void printSQLException(SQLException ex) {
        for (Throwable e: ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}
