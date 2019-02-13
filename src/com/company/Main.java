package com.company;

import java.awt.*;
import java.io.*;
import java.util.*;
import java.text.*;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException
    {
        NumberFormat fmt = NumberFormat.getNumberInstance();
        fmt.setMinimumFractionDigits(2);
        fmt.setMaximumFractionDigits(2);
        String name;
        FileWriter fw = new FileWriter("accounts.txt"); //page 142 in Blue Pelican
        PrintWriter pw = new PrintWriter(fw);

        //pw.print("one");

        bankAccount hack = new bankAccount("Mr. Pennebacker", 0);


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


        fw.close();
        pw.close();
        
        // Search aryLst and print out the name and amount of the largest bank
        // account
        List <bankAccount> myArray =  new ArrayList();
        bankAccount ba = (bankAccount) iter.previous();
        myArray.add(ba);
        myArray.add(hack);
        double maxBalance = ba.balance; // set last account as the winner so far
        String maxName = ba.name;
        while (iter.hasPrevious())
        {

            ba = (bankAccount) iter.previous();
            myArray.add(ba);
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


        //bankAccount [] modArray = new bankAccount[myArray.size()];
        //Color.sort(modArray);
        //System.out.println(myArray);

        boolean con = true;
        boolean debug = false;
        Scanner slct = new Scanner(System.in);
        bankAccount modify = null;
        int inpt = 0;
        String tstIn;
        while (con)
        {


            System.out.println("\n\nWhich account would you like to make a transactions to? (Enter the number or type exit)");

            int selector = 1;
            for(bankAccount b: myArray)
            {
                System.out.println(selector + ")\t" + b.name);
                selector++;
            }

            while (true)
            {
                try {
                    tstIn = slct.nextLine();
                    if(tstIn.equalsIgnoreCase("exit"))
                    {
                        con = false;
                        break;
                    }
                    else if(tstIn.equalsIgnoreCase("Debug"))
                    {
                        debug = true;
                        break;
                    }
                    inpt = Integer.parseInt(tstIn);
                    try {
                        modify = myArray.get(inpt - 1);
                        System.out.println(modify.name + " account selected.");
                        break;
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println("Please enter one of the numbers above");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Numbers only please");
                }
            }

            if(debug)
            {
                int dSlct = 0;
                System.out.println("");

                while (true)
                {
                    System.out.println("Which action would you like to perform? (Please choose a number)\n1)\tListing of deposit\n2)\tListing of Balances\n3)\tDrain an account");

                    try
                    {
                        dSlct = Integer.parseInt(slct.nextLine());
                        if (dSlct == 1 || dSlct == 2 || dSlct == 3)
                        {
                            break;
                        }
                        else
                            System.out.println("Please enter one of the numbers above");
                    }
                    catch (NumberFormatException e)
                    {
                        System.out.println("Numbers only please");
                    }
                }
                //Deposits
                if(dSlct == 1)
                {

                }

                //Balances
                else if(dSlct == 2)
                {
                    Collections.sort(myArray);
                    Collections.reverse(myArray);
                    System.out.println(myArray);
                }

                //Drain
                else if(dSlct == 3)
                {


                    System.out.println("\n\nWhich account would you like to Drain? (Enter the number or type exit");

                    selector = 1;
                    for(bankAccount b: myArray)
                    {
                        System.out.println(selector + ")\t" + b.name);
                        selector++;
                    }

                    while (true)
                    {
                        try {
                            inpt = Integer.parseInt(slct.nextLine());
                            try {
                                modify = myArray.get(inpt - 1);
                                System.out.println(modify.name + " account selected.");
                                break;
                            } catch (IndexOutOfBoundsException e) {
                                System.out.println("Please enter one of the numbers above");
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("Numbers only please");
                        }
                    }

                    double dBalance = (myArray.get(inpt-1)).balance;
                    (myArray.get(inpt-1)).withdraw(dBalance);
                    hack.deposit(dBalance);
                    System.out.println("$" + dBalance + " successfully drained from " + (myArray.get(inpt-1)).name + "'s account to Mr. Pennebacker's account.");

                }


            }

            if(!debug)
            {
                while (con && !debug) {
                    System.out.println("Would you like to deposit or withdraw? (Please choose a number)\n1)\tDeposit\n2)\tWithdraw");

                    try {
                        inpt = Integer.parseInt(slct.nextLine());
                        if (inpt == 1 || inpt == 2) {
                            break;
                        } else
                            System.out.println("Please enter one of the numbers above");
                    } catch (NumberFormatException e) {
                        System.out.println("Numbers only please");
                    }
                }

                double addSub;
                //Deposit
                if(inpt == 1)
                {
                    System.out.println("Please enter the amount you would like to deposit");
                    addSub = Double.parseDouble(slct.nextLine());
                    modify.deposit(addSub);
                }
                //Withdraw
                else if(inpt == 2)
                {
                    System.out.println("Please enter the amount you would like to withdraw");
                    addSub = Double.parseDouble(slct.nextLine());
                    modify.withdraw(addSub);
                }

            }

            debug = false;

        }










    }
}
