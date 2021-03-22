package com.ebank.ui;

import java.io.File;
import java.util.Scanner;

public class DeleteAccountController 
{

	public void delete() 
	{
		System.out.println("Account Deletion...");
		System.out.println("Enter the Account number to delete");
		Scanner sc = new Scanner(System.in);
		long SearchNumber = sc.nextLong();
		// Get the file
		File f = new File("D:\\data\\bank-accounts\\" + SearchNumber + ".txt");
		// File Existence check
		if (f.exists()) 
		{
			f.delete();
			System.out.println("Account"+ SearchNumber +"Deleted");
		}
		else
		{
			System.out.println("Account Does not Exist"); 
			
		}
			
	}
}
