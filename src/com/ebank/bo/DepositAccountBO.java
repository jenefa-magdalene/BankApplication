package com.ebank.bo;

import java.sql.SQLException;
import java.util.Scanner;

import com.ebank.db.AccountDB;
import com.ebank.vo.Account;

public class DepositAccountBO {

	public void depositBO(long accNumber,float balanceToDeposited) throws SQLException {
		// TODO Auto-generated method stub
		System.out.println("Deposited...");
		
		long accountNumber=accNumber;
		float balanceTobeDeposited=balanceToDeposited;
		
		AccountDB accountDB=new AccountDB();
		 accountDB.depositAccount(accountNumber,balanceTobeDeposited);
		//accountDB.depositAccount(account);
		
		
	}

}
