//package com.praise.greenbay_stores.dao;
//
//import com.praise.greenbay_stores.model.Admin;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.SQLException;
//
//public class CustomerDAO {
//    public int registerAdmin(Admin admin)throws ClassNotFoundException{
//        String INSERT_USERS_SQL = "INSERT INTO customer" +
//                " (cust_id, cfname, clname, password, username) VALUES  " +
//                " (?, ?, ?, ?, ?); ";
//
//        int result = 0;
//        Class.forName("com.mysql.jdbc.Driver");
//
//        //create a statement using connection object.
//        try(Connection connection = DriverManager.getConnection("jdbc:mysql://http://localhost:8080/",
//                "root", "Judith28@");
//            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
//                preparedStatement.setInt(1,1);
//                preparedStatement.setString(2, admin.getUsername());
//                preparedStatement.setString(3, admin.getPassword());
//                preparedStatement.setString(4, admin.getFname());
//                preparedStatement.setString(5, admin.getAddress());
//                preparedStatement.setString(6, admin.getContact());
//            System.out.println(preparedStatement);
//
//            //Execute the query or Update the query.
//            result  = preparedStatement.executeUpdate();
//        } catch (SQLException e) {
//            System.out.println("Internal Error");
////            throw new RuntimeException(e);
//        }
//    }
//}
