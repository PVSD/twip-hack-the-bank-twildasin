package com.company;


import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by dpennebacker on 2/13/17.
 */

public class bankAccount implements Comparable
{


    public bankAccount(String nm, double amt) {
        name = nm;
        balance = amt;
    }

    @Override
    public int compareTo(Object otherObject)
    {
        bankAccount otherAccount = (bankAccount) otherObject;
        int retValue;
        if (balance < otherAccount.balance) {
            retValue = -1;
        } else {
            if (balance > otherAccount.balance) {
                retValue = 1;
            } else {
                retValue = 0;
            }
        }
        return retValue;
    }

/*    @Override
    public int compareTo(bankAccount myBA)
    {
        return
    }*/

    public void deposit(double dp) throws IOException{

        balance = balance + dp;


    }

    public void withdraw(double wd) throws IOException {


        balance = balance - wd;


    }


    @Override
    public String toString()
    {
        return this.name + " $" + this.balance;
    }

    public String name;
    public double balance;

}
