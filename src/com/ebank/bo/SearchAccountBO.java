package com.ebank.bo;

import java.util.Scanner;

import com.ebank.vo.Account;

public class SearchAccountBO {
	public void parseData(String line) {
		
		String myString = line;
		String[] splitString = myString.split("\\|");
		System.out.println("Name:"+splitString[0]);
		System.out.println("Account Number:"+splitString[2]);
		System.out.println("Balance"+splitString[3]);
	}

}