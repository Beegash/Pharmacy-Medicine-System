/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.beegash.pharmacymedicinesystem;

import java.util.ArrayList;

/**
 *
 * @author fener
 */
public class Medicine {

    private int medicineId;
    private String medicineName;
    private String dose;
    private String issuedDate;
    private String expDate;
    private String storageConditions;
    private String howToUse;
    private String dailyDose;
    private int stock;

    public Medicine(int medicineId, String medicineName, String dose, String issuedDate, String expDate, String storageConditions, String howToUse, String dailyDose, int stock) {
        this.medicineId = medicineId;
        this.medicineName = medicineName;
        this.dose = dose;
        this.issuedDate = issuedDate;
        this.expDate = expDate;
        this.storageConditions = storageConditions;
        this.howToUse = howToUse;
        this.dailyDose = dailyDose;
        this.stock = stock;
    }

   
    public String getMedicineName() {
        return medicineName;
    }

    public void setMedicineName(String medicineName) {
        this.medicineName = medicineName;
    }

    public String getDose() {
        return dose;
    }

    public void setDose(String dose) {
        this.dose = dose;
    }

    public String getIssuedDate() {
        return issuedDate;
    }

    public void setIssuedDate(String issuedDate) {
        this.issuedDate = issuedDate;
    }

    public String getExpDate() {
        return expDate;
    }

    public void setExpDate(String expDate) {
        this.expDate = expDate;
    }

    public String getStorageConditions() {
        return storageConditions;
    }

    public void setStorageConditions(String storageConditions) {
        this.storageConditions = storageConditions;
    }

    public String getHowToUse() {
        return howToUse;
    }

    public void setHowToUse(String howToUse) {
        this.howToUse = howToUse;
    }

    public String getDailyDose() {
        return dailyDose;
    }

    public void setDailyDose(String dailyDose) {
        this.dailyDose = dailyDose;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
    
   public int getMedicineId() {
        return medicineId;
    }

    public void setMedicineId(int medicineId) {
        this.medicineId = medicineId;
    }
}
