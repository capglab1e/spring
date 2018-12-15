package com.cg.pwa.Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.cg.pwa.Dto.PrintTransactions;
import com.cg.pwa.Dto.Account;
import com.cg.pwa.Exception.MyException;
import com.cg.pwa.Exception.InvalidPhoneNumber;


@Repository("dao")
public class AccountDaoImpl implements AccountDao {
	@PersistenceContext
	EntityManager em;

	@Override
	public Account createAccount(Account c) throws MyException {
		// TODO Auto-generated method stub
		em.persist(c);
		em.flush();
		return c;
	}

	@Override
	public Account getAccount(String mobileno) {
		// TODO Auto-generated method stub
		 Account c=em.find(Account.class, mobileno);
		 System.out.println(c);
		 return c;
		
	}

	@Override
	public boolean setAccount(String mobileNo, double amount) {
		// TODO Auto-generated method stub
		Account cShow = em.find(Account.class, mobileNo);
		cShow.setBal(amount);
		em.merge(cShow);
		return true;
	}

	@Override
	public List<PrintTransactions> getTransactions(String mobileNo)
			throws MyException, InvalidPhoneNumber {
		// TODO Auto-generated method stub
		List<PrintTransactions> tranList = null;
		Query query = em.createQuery("from PrintTransactions where mobileNumber = :mobNo");
		query.setParameter("mobNo", mobileNo);
		tranList = query.getResultList();
		if(tranList.isEmpty())
			throw new MyException("No transactions are made yet");
		return tranList;
	}

	@Override
	public void loadTransaction(PrintTransactions pt) {
		// TODO Auto-generated method stub
		em.persist(pt);
	}
}
