package com.ebank.db;

import java.math.BigInteger;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.ebank.vo.Account;

public class AccountDB {

	public boolean createAccount(Account account) throws SQLException {
		System.out.println("Account Creation Using DB");
		String sql = "insert into account values(?,?,?,?)";
		Connection anyconn = getConnection();
		PreparedStatement pst = anyconn.prepareStatement(sql);

		pst.setLong(1, account.accountNumber);
		pst.setString(2, account.name);
		java.sql.Date sDate = convertUtilToSql(account.dateOfBirth);
		pst.setDate(3, sDate);
		pst.setFloat(4, account.balance);
		pst.execute();
		System.out.println("Values Inserted");
		pst.close();
		anyconn.close();
		return true;

	}

	public boolean deleteAccount(long accountNumber) throws SQLException {
		String sql = "delete from account where accountnumber=?";
		Connection anyconn = getConnection();
		PreparedStatement pst = anyconn.prepareStatement(sql);
		pst.setLong(1, accountNumber);
		System.out.println(accountNumber + " :Account Deleted...");

		pst.close();
		anyconn.close();
		return false;
	}

	public Account searchAccount(long accountNumber) throws SQLException {
		String sql = "Select *from account where accountnumber=?";
		Connection anyconn = getConnection();
		PreparedStatement pst = anyconn.prepareStatement(sql);
		pst.setLong(1, accountNumber);
		ResultSet rs = pst.executeQuery();
		Account account = null;
		try {
			if (rs.next()) {
				account = new Account();
				Long userid = rs.getLong(1);
				String username = rs.getString(2);
				float balance = rs.getFloat(4);
				System.out.println("AccountNumber : " + userid);
				System.out.println("UserName : " + username);
				System.out.println("final Balance="+balance);
				account.accountNumber = userid;
				account.name = username;
				account.balance = balance;
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} finally {
			pst.close();
			anyconn.close();
		}

		return account;
	}

	public Account depositAccount(long accno,float depositAmount) throws SQLException {
		long accountNumber=accno;
		float balanceTobeDeposit=depositAmount;
		String sql = "UPDATE account SET balance = ? where accountnumber= ?"; 
		Connection anyconn = getConnection();
		PreparedStatement pst = anyconn.prepareStatement(sql);
		pst.setFloat(1,balanceTobeDeposit);
		pst.setLong(2,accountNumber);
		try {
			pst.executeUpdate();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} finally {
			pst.close();
			anyconn.close();
		}

		return null;

	}

	public Account depositAccountUsingStatement(long accno,float depositAmount) throws SQLException {
		long accountNumber=accno;
		float balanceTobeDeposit=depositAmount;
		String sql = "UPDATE account SET balance = "+ balanceTobeDeposit +" where accountnumber="+accountNumber; 
		Connection anyconn = getConnection();
		Statement pst = anyconn.createStatement();
		try {
			pst.execute(sql);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} finally {
			pst.close();
			anyconn.close();
		}

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

	private java.sql.Date convertUtilToSql(java.util.Date input) { // 12.12.2000
		java.sql.Date sDate = new java.sql.Date(input.getTime());
		return sDate;
	}

}
