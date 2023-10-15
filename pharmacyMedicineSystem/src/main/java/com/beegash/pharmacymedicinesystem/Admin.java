/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.beegash.pharmacymedicinesystem;

/**
 *
 * @author fener
 */
public class Admin extends User {
   private String position;

    public Admin(String username, String password, String phoneNumber, String email, String position) {
        super(username, password, phoneNumber, email);
        this.position = position;
    }
    public Admin(){
        
    }

    public String getPosition() {
        return position;
    }

}
