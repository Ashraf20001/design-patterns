package org.dp.structural.adapter;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// Adapter
public class BankCustomer implements CreditCard {

    private final BankDetails bankDetails;

    public BankCustomer(){
        this.bankDetails = new BankDetails();
    }

    /**
     *
     */
    @Override
    public void giveBankDetails() {
       try( BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
           System.out.println("Enter bank name : ");
           bankDetails.setBankName(br.readLine());
           System.out.println("\n");
           System.out.println("Enter account number : ");
           bankDetails.setAccountNumber(Long.parseLong(br.readLine()));
           System.out.println("\n");
           System.out.println("Enter your name : ");
           bankDetails.setAccountHolderName(br.readLine());

       }catch (Exception e){
           System.out.println(e.getMessage());
       }
    }

    /**
     *
     */
    @Override
    public void creditCard() {
        System.out.println("Your credit card is ready with" +
                "Account number :"+ this.bankDetails.getAccountNumber() +
                 "Account Holder name :"+ this.bankDetails.getAccountHolderName() +
                "Bank name :"+ this.bankDetails.getBankName());

    }
}
