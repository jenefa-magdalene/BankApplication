package com.ebank.bo;

import java.sql.SQLException;

import com.ebank.db.AccountDB;

public class DeleteAccountBO {

public void deleteBO(long abc) throws SQLException {
		
		long idNumber=abc;
		System.out.println("Deletion...");
		
		AccountDB accountDB=new AccountDB();
		accountDB.deleteAccount (idNumber);
	}
	
}
