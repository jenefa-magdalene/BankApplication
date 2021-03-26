package com.ebank.filesystem;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.ebank.vo.Account;

public class AccountDao {
	
	
	

	public String formatDate(Date input) {
		String dateString = null;
		SimpleDateFormat sdfr = new SimpleDateFormat("dd-MM-yyyy");
		try {
			dateString = sdfr.format(input);
		} catch (Exception ex) {
			System.out.println(ex);
		}
		return dateString;

	}
	
	
	public static final String DELIMITER = "|";
	
	public boolean createAccount(Account account) {
		//Create a file name with account number
		System.out.println("account Number="+account.accountNumber);
		String file = account.accountNumber+"";
		String fileName = "D:\\data\\bank-accounts\\" + file+".txt";
		
		try {
		      File fileObject = new File(fileName);
		      if (fileObject.createNewFile()) {
		        System.out.println("File created: " + fileObject.getName());
		     
		      } else {
		        System.out.println("File already exists.");
		      }
		    } catch (IOException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
		
		
		
		//Save all details from account object to file in any format
		try
		{
		FileWriter myWriter = new FileWriter(fileName);
		 myWriter.write(account.name);
		 myWriter.write(DELIMITER);
		 myWriter.write( formatDate(account.dateOfBirth) );
		 myWriter.write(DELIMITER);
		 myWriter.write(account.accountNumber+"");
		 myWriter.write(DELIMITER);
		 myWriter.write(account.balance+"");
		 myWriter.write(DELIMITER);
		   
		 myWriter.close();
		}
	catch (IOException e) {
	      System.out.println("An error occurred.");
	      e.printStackTrace();
	}
		/*finally {
	        System.out.println("Success write to File");
	      }
		 */
		return true;
	}
}
