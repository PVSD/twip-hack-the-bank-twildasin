package com.company;

import java.io.*;
import java.util.*;
import java.text.*;
public class Main {

    public static void main(String[] args) throws IOException
    {
        NumberFormat fmt = NumberFormat.getNumberInstance();
        fmt.setMinimumFractionDigits(2);
        fmt.setMaximumFractionDigits(2);
        String name;
        FileWriter fw = new FileWriter("accounts.txt"); //page 142 in Blue Pelican
        PrintWriter pw = new PrintWriter(fw);

        FileWriter fwt = new FileWriter("transactions.txt");
        PrintWriter trans = new PrintWriter(fwt);



        ArrayList aryLst = new ArrayList();
        ListIterator iter = aryLst.listIterator();
        do {
            Scanner kbReader = new Scanner(System.in);
            System.out
                    .println("Please enter the name to whom the account belongs. (\"Exit\" to abort) ");
            name = kbReader.nextLine();
            if (!name.equalsIgnoreCase("EXIT"))
            {
                pw.print("\n" + name);
                System.out.println("Please enter the amount of the deposit. ");
                double amount = kbReader.nextDouble();
                pw.print(" : " + amount);
                System.out.println(" "); // gives an eye pleasing blank line
                // between accounts
                bankAccount theAccount = new bankAccount(name, amount);
                iter.add(theAccount);
            }
        } while (!name.equalsIgnoreCase("EXIT"));

        // Search aryLst and print out the name and amount of the largest bank
        // account
        bankAccount ba = (bankAccount) iter.previous();
        double maxBalance = ba.balance; // set last account as the winner so far
        String maxName = ba.name;
        while (iter.hasPrevious())
        {
            ba = (bankAccount) iter.previous();
            if (ba.balance > maxBalance)
            {
                // We have a new winner, chicken dinner
                maxBalance = ba.balance;
                maxName = ba.name;
            }
        }
        System.out.println(" ");
        System.out.println("The account with the largest balance belongs to "
                + maxName + ".");
        System.out.println("The amount is $" + fmt.format(maxBalance) + ".");


        fw.close();
        pw.close();
        fwt.close();
        trans.close();

    }
}
