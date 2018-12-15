package com.cg.pwa.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.pwa.Dao.AccountDao;
import com.cg.pwa.Dao.AccountDaoImpl;
import com.cg.pwa.Dto.PrintTransactions;
import com.cg.pwa.Dto.Account;
import com.cg.pwa.Exception.MyException;
import com.cg.pwa.Exception.InvalidAmount;
import com.cg.pwa.Exception.InvalidPhoneNumber;


@Service("service")
@Transactional
public class AccountServiceImpl implements AccountService {
	@Autowired
	AccountDao dao;
	public AccountServiceImpl() {

		dao = new AccountDaoImpl();
	}
	@Override
	public Account createAccount(Account c) throws MyException {
		// TODO Auto-generated method stub
		Account create = dao.createAccount(c);
		if(create == null)
			throw new MyException("Mobile number doesn't exist");
		return create;
	}
	@Override
	public double showBalance(String mobileno) throws InvalidPhoneNumber,
			MyException {
		// TODO Auto-generated method stub
		String tranType = "Check balance";
		Account bal = dao.getAccount(mobileno);
		if (bal == null)
			throw new MyException("Mobile number doesn't exist");
		dao.loadTransaction(new PrintTransactions(mobileno, tranType, bal.getBal()));
		return bal.getBal();
	
	}
	@Override
	public Account fundTransfer(String sourceMobileNo, String targetMobileNo,
			double amount) throws MyException {
		// TODO Auto-generated method stub
		String tranType = "Transfer";
		Account sbal = dao.getAccount(sourceMobileNo);
		Account tbal = dao.getAccount(targetMobileNo);
		if (sbal == null)
			throw new MyException("Mobile number doesn't exist");
		if (tbal == null)
			throw new MyException("Mobile number doesn't exist");
		double tmp = (sbal.getBal()- amount);
		if (tmp >= 0) {
			dao.setAccount(targetMobileNo, tbal.getBal() + amount);
			dao.setAccount(sourceMobileNo, sbal.getBal() - amount);
		} else {
			throw new MyException(
					"Minimum balance of Rupees greater than zero should be available...");
		}
//		System.out.println(dao.getAccount(sourceMobileNo));
		dao.loadTransaction(new PrintTransactions(sourceMobileNo, tranType, -amount));
		dao.loadTransaction(new PrintTransactions(targetMobileNo, tranType, amount));
		return dao.getAccount(sourceMobileNo);
		
	}
	@Override
	public Account depositAmount(String mobileNo, double amount)
			throws InvalidPhoneNumber, InvalidAmount, MyException {
		System.out.println("hii");
		// TODO Auto-generated method stub
		String tranType = "Deposit";
		Account cDep1 = dao.getAccount(mobileNo);
		System.out.println(cDep1.getBal());
		if (cDep1 == null)
			throw new MyException("Mobile number doesn't exist");
		boolean c = dao.setAccount(mobileNo, cDep1.getBal() + amount);
System.out.println(c);
		
		Account cDep = dao.getAccount(mobileNo);
		dao.loadTransaction(new PrintTransactions(mobileNo, tranType, amount));
		if (!c)
			throw new MyException("Unable to deposit");
		else
			return cDep;
		

	}
	@Override
	public Account withdrawAmount(String mobileNo, double amount)
			throws MyException {
		// TODO Auto-generated method stub
		String tranType = "Withdraw";
		boolean c = false;
		Account cDep1 = dao.getAccount(mobileNo);
		if (cDep1 == null)
			throw new MyException("Mobile number doesn't exist");
		if ((cDep1.getBal() - amount) >= 0)
			c = dao.setAccount(mobileNo, cDep1.getBal() - amount);
		Account cDep = dao.getAccount(mobileNo);
		dao.loadTransaction(new PrintTransactions(mobileNo, tranType, amount));
		if (!c)
			throw new MyException("Unable to withdraw");
		else
			return cDep;
		
	}
	@Override
	public List<PrintTransactions> getTransactions(String mobileNo)
			throws MyException, InvalidPhoneNumber {
		// TODO Auto-generated method stub
		
		if(dao.getAccount(mobileNo) == null)
			throw new MyException("Mobile number doesn't exist");
		
		List<PrintTransactions> list = null;
		
		list = dao.getTransactions(mobileNo);
		
		return list;
		
	}
	
	
}
