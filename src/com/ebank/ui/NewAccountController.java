 package com.ebank.ui;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Scanner;

import com.ebank.bo.NewAccountBO;
import com.ebank.vo.Account;
public class NewAccountController {
	
	
	
	
	public String formatDate(Date input) {
		String dateString = null;
		SimpleDateFormat sdfr = new SimpleDateFormat("dd-MM-yyyy");
		try {
			dateString = sdfr.format(input);
			System.out.println("Date Of Birth"+dateString);
		} catch (Exception ex) {
			System.out.println(ex);
		}
		return dateString;

	}
	public void create() throws SQLException {
		System.out.println("Please enter the following details to open an account:");
		System.out.println("Please enter Account holder Name");
		Scanner sc = new Scanner(System.in);
		String  accountname=sc.nextLine();
		
		System.out.println("Please Enter your Date Of Birth");
		String dateOfBirth=sc.nextLine(); // 22-12=2012. test


		
		System.out.println("Do you want to create an account?\nPlease confirm (Y or N):");
		String confirmation=sc.nextLine();
		
		if("Y".equalsIgnoreCase(confirmation)) {
			Account account=new Account();
			account.name=accountname;
			System.out.println("Name"+account.name);
			
			Date date1 = null;
			try {
				date1 = new SimpleDateFormat("dd-MM-yyyy").parse(dateOfBirth);
				//formatDate(date1);
				//System.out.println(date1);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} //Checked Exception
			account.dateOfBirth=date1;		
			
			
		
			account.balance = 100; 
			System.out.println("Balance"+account.balance);
			
			NewAccountBO newAccountBO = new NewAccountBO();
			newAccountBO.create(account);
			
		} else {
			System.out.println("Account not created !!");
		}
		
	}
}
