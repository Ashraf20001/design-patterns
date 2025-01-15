package org.dp.structural.adapter;

public class BankClient {

    public static void main(String[] args) {
        BankCustomer bankCustomer = new BankCustomer();    // Adapter
        bankCustomer.giveBankDetails();
        bankCustomer.creditCard();
    }
}

