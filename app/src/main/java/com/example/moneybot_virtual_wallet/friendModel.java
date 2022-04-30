package com.example.moneybot_virtual_wallet;

public class friendModel {
    String name;
    String amountToTransfer;
    boolean didAccept;

    public friendModel(String name, String amountToTransfer, boolean didAccept) {
        this.name = name;
        this.amountToTransfer = amountToTransfer;
        this.didAccept = didAccept;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAmountToTransfer() {
        return amountToTransfer;
    }

    public void setAmountToTransfer(String amountToTransfer) {
        this.amountToTransfer = amountToTransfer;
    }

    public boolean isDidAccept() {
        return didAccept;
    }

    public void setDidAccept(boolean didAccept) {
        this.didAccept = didAccept;
    }
}
