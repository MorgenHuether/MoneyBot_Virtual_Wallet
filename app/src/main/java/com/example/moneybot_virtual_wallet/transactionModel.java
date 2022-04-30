package com.example.moneybot_virtual_wallet;

public class transactionModel {
    String transactionLineItem;
    int transactionPrice;
    int currentBalance;
    boolean isBalanceNegative; // for checking if currentBalance - transactionPrice > 0
    boolean isDepositTransaction; // for checking if transactionPrice is a deposit into account
    int image; // for icons to prettify the code

    public transactionModel(String transactionLineItem, int transactionPrice,
                            int currentBalance, boolean isBalanceNegative, boolean isDepositTransaction,
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

    public int getTransactionPrice() {
        return transactionPrice;
    }

    public int getCurrentBalance() {
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
}// end transactionModel
