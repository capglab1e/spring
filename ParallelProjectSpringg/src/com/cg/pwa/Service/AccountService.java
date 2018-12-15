package com.cg.pwa.Service;

import java.util.List;

import com.cg.pwa.Dto.PrintTransactions;
import com.cg.pwa.Dto.Account;
import com.cg.pwa.Exception.MyException;
import com.cg.pwa.Exception.InvalidAmount;
import com.cg.pwa.Exception.InvalidPhoneNumber;


public interface AccountService {
	public Account createAccount(Account c) throws MyException;
	public double showBalance (String mobileno) throws InvalidPhoneNumber, MyException;
	public Account fundTransfer (String sourceMobileNo,String targetMobileNo, double amount) throws MyException;
	public Account depositAmount (String mobileNo, double amount ) throws InvalidPhoneNumber, InvalidAmount, MyException;
	public Account withdrawAmount(String mobileNo, double amount) throws MyException;
	public List<PrintTransactions> getTransactions(String mobileNo) throws MyException, InvalidPhoneNumber;
}
