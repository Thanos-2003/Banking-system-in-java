package com.example.bankapp.dto;

import jakarta.validation.constraints.*;

public class TransferBean {
    @NotNull(message="From Account ID is Mandatory")
    private Integer fromAccountId;
    @NotNull(message="To Account ID is Mandatory")
    private Integer toAccountId;
    @NotNull(message="Amount is Mandatory")
    @Min(value=1000, message="can transfer minimum Rs. 1000")
    @Max(value=50000, message="can transfer maximum Rs. 50000")
    private double amt;
    public Integer getFromAccountId() {
        return fromAccountId;
    }
    public void setFromAccountId(Integer fromAccountId) {
        this.fromAccountId = fromAccountId;
    }
    public Integer getToAccountId() {
        return toAccountId;
    }
    public void setToAccountId(Integer toAccountId) {
        this.toAccountId = toAccountId;
    }
    public double getAmt() {
        return amt;
    }
    public void setAmt(double amt) {
        this.amt = amt;
    }

    
}
