/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.beegash.pharmacymedicinesystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author fener
 */
public class DBhelper {

    private static final String url = "jdbc:mysql://localhost:3306/pharmacy?zeroDateTimeBehavior=CONVERT_TO_NULL";
    private static final String username = "root";
    private static final String password = "1287";
    
    public static Connection getConnection () throws SQLException{
        return DriverManager.getConnection(url, username, password);
    }
    public void showErrorMessage(SQLException exception){
        System.out.println("Error :"+ exception.getMessage());
        System.out.println("Error Code :"+exception.getErrorCode());
    }
}
