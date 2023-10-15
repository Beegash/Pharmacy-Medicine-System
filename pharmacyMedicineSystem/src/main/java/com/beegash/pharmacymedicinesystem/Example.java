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
public class Example {
    public static void main(String[] args) {
        String url="jdbc:derby://localhost:1527/pharmacydb";
        String userName="beegash";
        String password="1234";
        
        try {
            Connection con=DriverManager.getConnection(url,userName,password);
            Statement s=con.createStatement();
            String sqlString="SELECET * FROM logintable";
            ResultSet rs=s.executeQuery(sqlString);
            rs.next();
        } catch (SQLException ex) {
            Logger.getLogger(Example.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
