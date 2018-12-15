package com.cg.pwa.Dao;

import java.util.List;

import com.cg.pwa.Dto.PrintTransactions;
import com.cg.pwa.Dto.Account;
import com.cg.pwa.Exception.MyException;
import com.cg.pwa.Exception.InvalidPhoneNumber;



public interface AccountDao {
	public Account createAccount(Account c) throws MyException;
	public Account getAccount(String mobileno);
	public boolean setAccount(String mobileNo, double amount);
	public List<PrintTransactions> getTransactions(String mobileNo) throws MyException, InvalidPhoneNumber;
	public void loadTransaction(PrintTransactions pt);

	
}
