package com.company;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class myDebug {

    public static void listOfDeposits () throws IOException
    {
        Scanner sb = new Scanner(new File("transactions.txt"));


        sb.close();
    }
}
