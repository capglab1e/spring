package com.cg.pwa.service;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.cg.pwa.beans.Account;
import com.cg.pwa.dao.AccountDao;
import com.cg.pwa.dao.AccountDaoImpl;
import com.cg.pwa.exception.MyException;
import com.cg.pwa.exception.InvalidAmount;
import com.cg.pwa.exception.InvalidPhoneNumber;
import com.cg.pwa.exception.NameException;


public class AccountServiceImpl implements AccountService
{
	AccountDao dao;

	public AccountServiceImpl() 
	{
		dao = new AccountDaoImpl();
	}


	@Override
	public boolean validateUserName(String name) throws NameException 
	{

		if(name==null) throw new NameException("Null value");
		Pattern p = Pattern.compile("[A-Z]{1}[a-z]{2,30}");
		Matcher mat = p.matcher(name);
		if(!mat.matches())
			System.out.println("Invalid Name");
		return mat.matches();
	}

	@Override
	public boolean validatePhoneNumber(String mobileNo) throws InvalidPhoneNumber 
	{
		if(mobileNo==null) 
			throw new InvalidPhoneNumber("Null value");
		Pattern pat = Pattern.compile("[6-9]{1}[0-9]{9}");
		Matcher mat = pat.matcher(mobileNo);
		if(!mat.matches())
			System.out.println("Invalid Mobile Number");
		return mat.matches();
	}

	@Override
	public boolean validateAmount(double amt) throws InvalidAmount 
	{

		Pattern pat = Pattern.compile("[1-9]{1}[0-9.]{0,9}");
		Matcher mat = pat.matcher(String.valueOf(amt));
		boolean b = mat.matches();

		if (!b)
			throw new InvalidAmount();

		return b;
	}

	@Override
	public boolean validateAll(Account a) throws MyException, NameException, InvalidAmount, InvalidPhoneNumber 
	{

		boolean b = false;

		if (validateUserName(a.getCustomerName()) == true && validatePhoneNumber(a.getMobileNumber()) == true && validateAmount(a.getAccountBalance()) == true)
			b = true;
		if (!b)
			throw new MyException("Invalid details");
		return b;
	}

	@Override
	public boolean validateTargetMobNo(String targetMobNo) throws InvalidPhoneNumber
	{
		if(targetMobNo==null) 
			throw new InvalidPhoneNumber("Null value");
		Pattern pat = Pattern.compile("[6-9]{1}[0-9]{9}");
		Matcher mat = pat.matcher(targetMobNo);
		boolean b = mat.matches();

		if (!b)
			throw new InvalidPhoneNumber("Invalid target Mobile Number");

		return b;
	}

	@Override
	public Account createAccount(Account a) throws MyException 
	{
		// TODO Auto-generated method stub
		Account create = dao.createAccount(a);

		if(create == null)
			throw new MyException("Mobile number doesn't exist");
		return create;
	}

	@Override
	public double showBalance(String mobileno) throws MyException,MyException 
	{
		// TODO Auto-generated method stub

		Account bal = dao.getAccount(mobileno);
		if (bal == null)
			throw new MyException("Mobile number doesn't exist");
		return bal.getAccountBalance();
	}

	@Override
	public Account fundTransfer(String sourceMobileNo, String targetMobileNo,double amount) throws MyException 
	{
		// TODO Auto-generated method stub

		Account smob = dao.getAccount(sourceMobileNo);
		Account tmob = dao.getAccount(targetMobileNo);
		if (smob == null)
			throw new MyException("Mobile number doesn't exist");
		if (tmob == null)
			throw new MyException("Mobile number doesn't exist");
		double tmp = (smob.getAccountBalance() - amount);
		if (tmp >= 0) 
		{
			dao.setAccount(targetMobileNo, tmob.getAccountBalance() + amount);
			dao.setAccount(sourceMobileNo, smob.getAccountBalance() - amount);
		}
		else
		{
			throw new MyException("Minimum balance of Rupees greater than zero should be available...");
		}

		return dao.getAccount(sourceMobileNo);
	}

	@Override
	public Account depositAmount(String mobileNo, double amount) throws InvalidPhoneNumber, InvalidAmount, MyException 
	{
		// TODO Auto-generated method stub

		Account aDep1 = dao.getAccount(mobileNo);
		if (aDep1 == null)
			throw new MyException("Mobile number doesn't exist");

		boolean a = dao.setAccount(mobileNo, aDep1.getAccountBalance() + amount);

		Account aDep = dao.getAccount(mobileNo);
		if (!a)
			throw new MyException("Unable to deposit");
		else
			return aDep;
	}

	@Override
	public Account withdrawAmount(String mobileNo, double amount) throws MyException 
	{
		// TODO Auto-generated method stub
		
		boolean a = false;
		Account aWit1 = dao.getAccount(mobileNo);
		if (aWit1 == null)
			throw new MyException("Mobile number doesn't exist");
		if ((aWit1.getAccountBalance() - amount) >= 0)
			a = dao.setAccount(mobileNo, aWit1.getAccountBalance() - amount);
		Account aWit = dao.getAccount(mobileNo);
		if (!a)
			throw new MyException("Unable to withdraw");
		else
			return aWit;
	}


	




}
