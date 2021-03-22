package com.ebank.bo;

import java.util.Date;

import com.ebank.db.AccountDao;
import com.ebank.vo.Account;

public class NewAccountBO {
	
	public boolean create(Account account) {
		account.accountNumber = generateUniqueNumber();
		// TODO add logic for create account
		//EIther call DB or File
		AccountDao accountDao = new AccountDao();
		accountDao.createAccount(account);
		
		return true;
	}
	
	
	
	private long generateUniqueNumber() {
		return System.currentTimeMillis();
	}
}