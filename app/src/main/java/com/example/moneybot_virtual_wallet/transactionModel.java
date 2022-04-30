package com.example.moneybot_virtual_wallet;

public class transactionModel {
    String transactionLineItem;
    double transactionPrice;
    double currentBalance;
    boolean isBalanceNegative; // for checking if currentBalance - transactionPrice > 0
    boolean isDepositTransaction; // for checking if transactionPrice is a deposit into account
    int image; // for icons to prettify the code

    public transactionModel(String transactionLineItem, double transactionPrice,
                            double currentBalance, boolean isBalanceNegative, boolean isDepositTransaction,
                            int image) {
        this.transactionLineItem = transactionLineItem;
        this.transactionPrice = transactionPrice;
        this.currentBalance = currentBalance;
        this.isBalanceNegative = isBalanceNegative;
        this.isDepositTransaction = isDepositTransaction;
        this.image = image;
    }

    public String getTransactionLineItem() {
        return transactionLineItem;
    }

    public double getTransactionPrice() {
        return transactionPrice;
    }

    public double getCurrentBalance() {
        return currentBalance;
    }

    public boolean isBalanceNegative() {
        return isBalanceNegative;
    }

    public boolean isDepositTransaction() {
        return isDepositTransaction;
    }

    public int getImage() {
        return image;
    }

    public void setTransactionLineItem(String transactionLineItem) {
        this.transactionLineItem = transactionLineItem;
    }

    public void setTransactionPrice(int transactionPrice) {
        this.transactionPrice = transactionPrice;
    }

    public void setCurrentBalance(int currentBalance) {
        this.currentBalance = currentBalance;
    }

    public void setBalanceNegative(boolean balanceNegative) {
        isBalanceNegative = balanceNegative;
    }

    public void setDepositTransaction(boolean depositTransaction) {
        isDepositTransaction = depositTransaction;
    }

    public void setImage(int image) {
        this.image = image;
    }
}// end transactionModel
