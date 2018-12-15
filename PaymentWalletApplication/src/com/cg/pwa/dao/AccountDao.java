package com.cg.pwa.dao;

import com.cg.pwa.beans.Account;
import com.cg.pwa.exception.MyException;

public interface AccountDao 
{
	public Account createAccount(Account a) throws MyException;
	public Account getAccount(String mobileno);
	public boolean setAccount(String mobileNo, double amount);
	
}
