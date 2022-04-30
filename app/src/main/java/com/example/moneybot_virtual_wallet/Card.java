package com.example.moneybot_virtual_wallet;

public class Card {

    private String cardNumber, expiration, cvv, username;

    public Card(String username, String cardNumber, String expiration, String cvv) {
        this.cardNumber = cardNumber;
        this.expiration = expiration;
        this.cvv = cvv;
        this.username = username;
    }

    public String getCardNumber() { return this.cardNumber; }
    public String getExpiration() { return this.expiration; }
    public String getCvv() { return this.cvv; }
    public String getUsername() { return this.cvv; }

    public String[] getCardInfo() {
        return new String[]{this.username, this.cardNumber,this.cvv, this.expiration};
    }

}