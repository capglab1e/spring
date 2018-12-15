package com.cg.pwa.service;

import com.cg.pwa.beans.Account;
import com.cg.pwa.exception.MyException;
import com.cg.pwa.exception.InvalidAmount;
import com.cg.pwa.exception.InvalidPhoneNumber;
import com.cg.pwa.exception.NameException;


public interface AccountService 
{
	public Account createAccount(Account a) throws MyException;
	public double showBalance (String mobileno) throws InvalidPhoneNumber, MyException;
	public Account fundTransfer (String sourceMobileNo,String targetMobileNo, double amount) throws MyException;
	public Account depositAmount (String mobileNo, double amount ) throws InvalidPhoneNumber, InvalidAmount, MyException;
	public Account withdrawAmount(String mobileNo, double amount) throws MyException;
	public boolean validateUserName(String name) throws NameException;
	public boolean validatePhoneNumber(String mobNo) throws InvalidPhoneNumber;
	public boolean validateTargetMobNo(String targetMobNo) throws InvalidPhoneNumber;
	public boolean validateAmount(double amt) throws InvalidAmount;
	public boolean validateAll(Account a) throws MyException, NameException, InvalidAmount, InvalidPhoneNumber;
	
}
