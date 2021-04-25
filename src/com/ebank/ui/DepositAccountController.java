package com.ebank.ui;

import java.util.Scanner;

import com.ebank.bo.DepositAccountBO;
import com.ebank.db.AccountDB;
import com.ebank.vo.Account;

public class DepositAccountController {

	public void deposit() throws Exception {
	
		System.out.println("enter the accountNumber ");
		Scanner sc=new Scanner(System.in);
		long accno=sc.nextLong();
		
		AccountDB accountDB=new AccountDB();
		Account userDetails = accountDB.searchAccount (accno);
		
		if(userDetails == null) {
			System.out.println("Account not available ! Please provide a valid accountnumber");
		} else {
			System.out.println("You have a minimun balance of Rs."+userDetails.balance);
			// TODO CAll deposit amount logic
			
			System.out.println("Please enter your deposit amount.");
			float userprovidedbalance=sc.nextFloat();
			
			float balanceToBeDeposited = userprovidedbalance + userDetails.balance;
			
			
			DepositAccountBO  depositAccountBO=new DepositAccountBO();
			depositAccountBO.depositBO(accno, balanceToBeDeposited);
			
			
			userDetails = accountDB.searchAccount (accno);
		}
		
	
		//DepositAccountBO  depositAccountBO=new DepositAccountBO();
		//depositAccountBO.depositBO(accno);
		
		
		/*File f = new File("D:\\data\\bank-accounts\\" + accnumber + ".txt");
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
			 
		}*/

	}
}
