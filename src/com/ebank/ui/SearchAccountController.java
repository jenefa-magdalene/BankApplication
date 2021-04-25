package com.ebank.ui;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

import com.ebank.bo.SearchAccountBO;

public class SearchAccountController {
	public void search() throws IOException, SQLException {
		System.out.println("Searching...");
		System.out.println("Enter the Account number to search");
		Scanner sc = new Scanner(System.in);
		long searchNumber = sc.nextLong();
	
		SearchAccountBO searchAccountBO = new SearchAccountBO();
		searchAccountBO.searchBO(searchNumber);
}
		
	/*	// Get the file
		File f = new File("D:\\data\\bank-accounts\\" + SearchNumber + ".txt");

		// File Existence check
		if (f.exists())
			
		{
			System.out.println("Account Exists");
			BufferedReader br = new BufferedReader(new FileReader(f)); 
			 String line=line=br.readLine();
			 //System.out.println(line);
			 /*do
			  {
				  line=br.readLine();
				  System.out.println(line);
			  } while(line!=null);*/
				// parse each line using delimiter*\
				
		/*else
		{
			System.out.println("Account not exist");
		}
		System.out.println("search completed");*/
}
