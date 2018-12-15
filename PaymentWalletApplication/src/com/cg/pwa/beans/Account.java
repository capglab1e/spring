package com.cg.pwa.beans;

public class Account 
{
	private String mobileNumber;
	private String customerName;
	private double accountBalance;

	public Account(String name,double accBal,String mobNo)
	{
		this.customerName=name;
		this.mobileNumber = mobNo;
		this.accountBalance=accBal;
	}

	public String getMobileNumber() 
	{
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) 
	{
		this.mobileNumber = mobileNumber;
	}

	public String getCustomerName() 
	{
		return customerName;
	}

	public void setCustomerName(String customerName)
	{
		this.customerName = customerName;
	}

	public double getAccountBalance() 
	{
		return accountBalance;
	}

	public void setAccountBalance(double accountBalance) 
	{
		this.accountBalance = accountBalance;
	}

	public void fundTransfer(double amount) 
	{
		this.accountBalance = this.accountBalance - amount;
	}
	@Override
	public String toString() 
	{
		return "Account [mobileNumber=" + mobileNumber + ", customerName="
				+ customerName + ", accountBalance=" + accountBalance + "]";
	}

	public Account() 
	{

	}

}
