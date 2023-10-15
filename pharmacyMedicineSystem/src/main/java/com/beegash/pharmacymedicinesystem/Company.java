/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.beegash.pharmacymedicinesystem;

/**
 *
 * @author fener
 */
public class Company {

    private int companyId;
    private String name;
    private String address;
    private String phoneNumber;

    public Company(int companyId, String name, String address, String phoneNumber) {
        this.companyId = companyId;
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    // getters and setters for all properties
    public String getCompanyName() {
        return name;
    }

    public void setCompanyName(String name) {
        this.name = name;
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int medicineId) {
        this.companyId = medicineId;
    }

    public String getCompanyAddress() {
        return address;
    }

    public void setCompanyAddress(String address) {
        this.address = address;
    }

    public String getCompanyPhoneNumber() {
        return phoneNumber;
    }

    public void setCompanyPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
