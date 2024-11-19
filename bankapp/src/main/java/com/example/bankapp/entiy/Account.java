package com.example.bankapp.entiy;

//import org.antlr.v4.runtime.misc.NotNull;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.*;;

@Entity
@Table(name ="cg_account")
@DynamicUpdate(true)
@DynamicInsert(true)
public class Account {
    @NotNull(message="AccountID Is Mandatory")
    @Id
    @Column(name = "acc_id")
    private Integer accId;

    @NotEmpty(message="Customer Name is Mandatory")
    @Size(min=3, max=25, message = "length can be 3 and 25 character")
    @Pattern(regexp= "([A-Za-z+])|([A-Za-z])+[ ][A-Za-z]+)",message="allow only alphabets ans a blank space is allowed")
    @Column(name = "cust_name", length=25)
    private String custName;

    @NotNull(message="Balance Is Mandatory")
    @Min(value=1000, message="Your OPening amount must be RS.1000")
    private Double balance;
    public Account(){

    }
    public Account(int accId, String custname, double balance){
        super();
        this.accId= accId;
        this.custName = custname;
        this.balance = balance;
    }
    public Integer getAccId() {
        return accId;
    }
    public void setAccId(Integer accId) {
        this.accId = accId;
    }
    public String getCustName() {
        return custName;
    }
    public void setCustName(String custName) {
        this.custName = custName;
    }
    public Double getBalance() {
        return balance;
    }
    public void setBalance(Double balance) {
        this.balance = balance;
    }
    public String toString(){
        return accId +" "+ custName+" "+balance;
    }
}
