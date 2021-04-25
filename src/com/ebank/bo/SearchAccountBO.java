package com.ebank.bo;

import java.sql.SQLException;
import java.util.Scanner;

import com.ebank.db.AccountDB;
import com.ebank.vo.Account;

public class SearchAccountBO {

	public void searchBO(long abc) throws SQLException {
		
		long idNumber=abc;
		System.out.println("Searchiong...");
		
		AccountDB accountDB=new AccountDB();
		accountDB.searchAccount (idNumber);
	}
	
	/*public void parseData(String line) {
		
		String myString = line;
		String[] splitString = myString.split("\\|");
		System.out.println("Name:"+splitString[0]);
		System.out.println("Account Number:"+splitString[2]);
		System.out.println("Balance"+splitString[3]);
	}*/

}