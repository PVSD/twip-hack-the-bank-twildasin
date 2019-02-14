package com.company;

public class transactionFunction implements Comparable{

    public String name;
    public double deposit;

    public transactionFunction ( String n, double dps)
    {
        name = n;
        deposit = dps;
    }

    @Override
    public int compareTo(Object otherObject)
    {
        transactionFunction otherAccount = (transactionFunction) otherObject;
        int retValue;
        if (deposit < otherAccount.deposit) {
            retValue = -1;
        } else {
            if (deposit > otherAccount.deposit) {
                retValue = 1;
            } else {
                retValue = 0;
            }
        }
        return retValue;
    }

    @Override
    public String toString()
    {
        return this.name + " $" + this.deposit;
    }


}
