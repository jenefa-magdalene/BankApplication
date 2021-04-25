package com.ebank.bo;

import java.sql.SQLException;

import com.ebank.db.AccountDB;
import com.ebank.filesystem.AccountDao;
import com.ebank.vo.Account;

public class NewAccountBO {
	
//	AccountDB accountDB = new AccountDB();
	
	public boolean create(Account account) throws SQLException {
		account.accountNumber = generateUniqueNumber();
		System.out.println("Account Number:"+	account.accountNumber);
		// TODO add logic for create account
		AccountDB accountDB=new AccountDB();
		accountDB.createAccount(account);
		
		//EIther call DB or File
		/*AccountDao accountFile = new AccountDao();
		accountFile.createAccount(account);*/
		
		
		
		return true;
	}
	
	
	
	private long generateUniqueNumber() {
		return System.currentTimeMillis();
	}
}