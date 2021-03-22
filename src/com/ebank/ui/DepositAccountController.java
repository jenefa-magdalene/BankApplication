package com.ebank.ui;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class DepositAccountController {

	public void deposit() throws Exception {
		System.out.println("Enter the account Number");
		Scanner sc = new Scanner(System.in);
		long accnumber = sc.nextLong();
		File f = new File("D:\\data\\bank-accounts\\" + accnumber + ".txt");
		if (f.exists()) {
			BufferedReader br = new BufferedReader(new FileReader(f));
				 
				String line = br.readLine();
			System.out.println("Account Details ::");

			String[] splitString = line.split("\\|");
			System.out.println("Name :"+splitString[0]);
			System.out.println("Account NO :"+splitString[2]);
			System.out.println("Balance in Account :"+splitString[3]);
			
			
			System.out.println("Enter the amount to deposit");
			Scanner sc1 = new Scanner(System.in);
			float depositamount = sc1.nextFloat();
		
			float floatbalance=Float.parseFloat(splitString[3]);
			float finalamount=depositamount+floatbalance;
			System.out.println("Total Amount"+finalamount);
		
	
			/*
			 * 
			 */
		}

	}
}
