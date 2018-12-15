package com.cg.pwa.dao;

import java.util.HashMap;
import java.util.Map;
import com.cg.pwa.beans.Account;
import com.cg.pwa.exception.MyException;


public class AccountDaoImpl implements AccountDao
{
	Map<String,Account> accountEntry;

	public AccountDaoImpl()
	{
		accountEntry=new HashMap<String,Account>();

		accountEntry.put("9949170543", new Account("Amma",2000,"9949170543"));
		accountEntry.put("9948666186", new Account("Nanna",25000,"9948666186"));
		accountEntry.put("7386759303", new Account("Bhuvana",5000,"7386759303"));
		accountEntry.put("9154737580", new Account("Krishna",2000,"9154737580"));
		accountEntry.put("9573432184", new Account("Sanjay",15000,"9573432184"));

	}

	@Override
	public Account createAccount(Account a) throws MyException 
	{
		// TODO Auto-generated method stub
		accountEntry.put(a.getMobileNumber(), a);
		return a;
	}

	@Override
	public Account getAccount(String mobileno)
	{
		// TODO Auto-generated method stub
		Account aShow=accountEntry.get(mobileno);
		return aShow;
	}


	@Override
	public boolean setAccount(String mobileNo, double amount)
	{
		// TODO Auto-generated method stub
		Account aSet = accountEntry.get(mobileNo);
		aSet.setAccountBalance(amount);
		System.out.println(aSet);
		accountEntry.put(mobileNo, aSet);
		return true;
	}

}
