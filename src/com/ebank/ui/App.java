package com.ebank.ui;

import java.io.IOException;
import java.util.Scanner;

/*
 * 
 * MAIN CLASS - This class list home menu selection options
 * 
 * Welcome to ICICI Bank
Please select below option to continue ____
1.Create Account
2.Search Account
3.Delete Account
4.Exit
 * 
 */

public class App {
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Welcome To HDFC Bank");
		System.out.println("1.Create Account\n\n2.Search Account\n\n3.Delete Account\n\n4.Deposit\n\n5.Exit");
		System.out.println("Please Select Below Option to continue");
		Scanner sc = new Scanner(System.in);
		int option = sc.nextInt();
		switch (option) {
		case 1:
			NewAccountController newAccountController = new NewAccountController();
			newAccountController.create();
			break;
		case 2:
			SearchAccountController SearchAccountController=new SearchAccountController();
			SearchAccountController.search();
			// Call search controller
			break;
		case 3:
			// Call delete controller
			DeleteAccountController DeleteAccountController=new  DeleteAccountController();
			DeleteAccountController.delete();
			break;
			
		case 4:
			DepositAccountController DepositAccountController =new DepositAccountController ();
			DepositAccountController.deposit();
			
		default:

		}
	}
}
