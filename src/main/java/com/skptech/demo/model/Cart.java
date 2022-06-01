package com.skptech.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(value = { "greaterThanTwoHundred" })
public class Cart {

    private int quantity;
    private int totalAmount;
    private int totalDiscount;
    private int amountAfterDiscount;
    private boolean eligibleForDiscount;
    private boolean greaterThanTwoHundred;


    public Cart(int quantity, int totalAmount) {
        this.quantity = quantity;
        this.totalAmount = totalAmount;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(int totalAmount) {
        this.totalAmount = totalAmount;
    }

    public int getTotalDiscount() {
        return totalDiscount;
    }

    public void setTotalDiscount(int totalDiscount) {
        this.totalDiscount = totalDiscount;
    }

    public int getAmountAfterDiscount() {
        return totalAmount - totalDiscount;
    }

    public void setAmountAfterDiscount(int amountAfterDiscount) {
        this.amountAfterDiscount = amountAfterDiscount;
    }

    public boolean isEligibleForDiscount() {
        return eligibleForDiscount;
    }

    public void setEligibleForDiscount(boolean eligibleForDiscount) {
        this.eligibleForDiscount = eligibleForDiscount;
    }

    public boolean isGreaterThanTwoHundred() {
        return this.totalAmount > 200;
    }

    public void setGreaterThanTwoHundred(boolean greaterThanTwoHundred) {
        this.greaterThanTwoHundred = greaterThanTwoHundred;
    }

}
