package com.ebank.ui;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import com.ebank.bo.SearchAccountBO;

public class SearchAccountController {
	public void search() throws IOException {
		System.out.println("Searching...");
		System.out.println("Enter the Account number to search");
		Scanner sc = new Scanner(System.in);
		long SearchNumber = sc.nextLong();
		// Get the file
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
				// parse each line using delimiter
				SearchAccountBO searchAccountBO = new SearchAccountBO();
				searchAccountBO.parseData(line);
		}
		else
		{
			System.out.println("Account not exist");
		}
		System.out.println("search completed");
}}
