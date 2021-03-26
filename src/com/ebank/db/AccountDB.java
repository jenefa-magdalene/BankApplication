package com.ebank.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import com.ebank.vo.Account;


public class AccountDB {

	
	
	
	public boolean createAccount(Account account) throws SQLException {
		System.out.println("Account Creation Using DB");
		
		
		 String sql="insert into account values(?,?,?)";
		 Connection anyconn = getConnection();
	PreparedStatement pst=anyconn.prepareStatement(sql);
			
		 pst.setLong(1,account.accountNumber);
		 pst.setString(2,account.name);
		 java.sql.Date sDate = convertUtilToSql(account.dateOfBirth);  
		 pst.setDate(3, sDate);
		 pst.execute();
		 System.out.println("Values Inserted");
		 pst.close();
		return true;
		

	}	
	
	public boolean deleteAccount(String accountNumber) {
		return false;
	}	
	
	public Account searchAccount(String accountNumber) {
		return null;
	}
	

	public Connection getConnection() {
		Connection con = null;
		try {
			Class.forName("org.postgresql.Driver");
			con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/banking", "postgres", "admin");
		} catch (Exception e) {
			e.printStackTrace();
			
			System.exit(0);
		}
		System.out.println("Opened database successfully");
		return con;
	}
	
	
	 private java.sql.Date convertUtilToSql(java.util.Date input) {  //12.12.2000
	        java.sql.Date sDate = new java.sql.Date(input.getTime());
	        return sDate;
	    }
	 
	
	 }





