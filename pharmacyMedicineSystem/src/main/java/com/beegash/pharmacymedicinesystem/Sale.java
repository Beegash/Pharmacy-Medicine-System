/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.beegash.pharmacymedicinesystem;

/**
 *
 * @author fener
 */
public class Sale {

    private int saleId;
    private String medicineName;
    private String companyName;
    private int numberOfPieces;
    private String shipment;

    public Sale(int saleId, String companyName ,String medicineName, int numberOfPieces, String shipmentOption) {
        this.saleId = saleId;
        this.medicineName = medicineName;
        this.companyName = companyName;
        this.numberOfPieces = numberOfPieces;
        this.shipment = shipmentOption;
    }

    public boolean checkStock() {
        for (Medicine medicine : MedicineList.medicineList) {
            if (medicine.getMedicineName().equals(this.medicineName)) {
                if (medicine.getStock() < this.numberOfPieces) {
                    return false;
                }
                return true;
            }
        }
        return false;
    }

    public String getMedicineName() {
        return medicineName;
    }

    public void setMedicineName(String medicineName) {
        this.medicineName = medicineName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public int getNumberOfPieces() {
        return numberOfPieces;
    }

    public void setNumberOfPieces(int saleId) {
        this.numberOfPieces = saleId;
    }
     public int getSaleId() {
        return saleId;
    }

    public void setSaleId(int saleId) {
        this.numberOfPieces = saleId;
    }

    public String getShipment() {
        return shipment;
    }

    public void setShipment(String shipment) {
        this.shipment = shipment;
    }
}
