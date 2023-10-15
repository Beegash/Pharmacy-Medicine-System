/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.beegash.pharmacymedicinesystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author fener
 */
public class DataTest {

    public static void main(String[] args) {

        Connection c = null;
        DBhelper helper = new DBhelper();
        try {

            /* String url = "jdbc:mysql://localhost:3306/pharmacy?zeroDateTimeBehavior=CONVERT_TO_NULL";
            String username = "root"; 
            String password = "1287";*/
            c = helper.getConnection();
            System.out.println("Connection Succeed");
        } catch (SQLException exception) {
            Logger.getLogger(DataTest.class.getName()).log(Level.SEVERE, null, exception);
            helper.showErrorMessage(exception);
        }
    }

}
