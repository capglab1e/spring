package com.cg.pwa.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.cg.pwa.Dto.PrintTransactions;
import com.cg.pwa.Dto.Account;
import com.cg.pwa.Exception.MyException;
import com.cg.pwa.Exception.InvalidAmount;
import com.cg.pwa.Exception.InvalidPhoneNumber;
import com.cg.pwa.Service.AccountService;

@Controller
public class AccountController 
{
	@Autowired
	AccountService service;

	@RequestMapping(value="CreateAccount")
	public String menu(@ModelAttribute("y") Account account)
	{
		return "Createaccount";
	}

	@RequestMapping(value = "adddata", method = RequestMethod.POST)
	public ModelAndView addCustomerNow(@ModelAttribute("y") Account account) 
	{
		String res = null;
		System.out.println(account);
		try {
			service.createAccount(account);
			res = "Account was created successfully!!!";
		} catch (MyException e) {
			// TODO Auto-generated catch block
			res = e.getMessage();
		}
		return new ModelAndView("welcome", "result", res);
	}


	@RequestMapping(value = "DepositAmount")
	public String deposit(@ModelAttribute("z") Account account) {
		return "Depositamount";
	}

	@RequestMapping(value = "depdata", method = RequestMethod.POST)
	public ModelAndView depositNow(@ModelAttribute("z") Account account) {
		//System.out.println("hi");
		String res = null;
		try {
			System.out.println(account.getMobileno());
			Account customer = service.depositAmount(account.getMobileno(), account.getBal());
			res = "Your current balance is "+customer.getBal();
			System.out.println(res);
		} catch (InvalidPhoneNumber e) {
			// TODO Auto-generated catch block
			res = e.getMessage();
		} catch (InvalidAmount e) {
			// TODO Auto-generated catch block
			res = e.getMessage();
		} catch (MyException e) {
			// TODO Auto-generated catch block
			res = e.getMessage();
		}
		return new ModelAndView("welcome1", "result", res);
	}


	@RequestMapping(value = "ShowBalance")
	public String showBalance(@ModelAttribute("f") Account account) {
		return "showBalance";
	}

	@RequestMapping(value = "shodata", method = RequestMethod.POST)
	public ModelAndView showBalanceNow(@ModelAttribute("f") Account account) {
		double balance = 0;
		String res = "Nothing updated ";
		try {
			balance = service.showBalance(account.getMobileno());
			res = "Your current balance is "+balance;
		} catch (InvalidPhoneNumber | MyException e) {
			res = e.getMessage();
		}
		return new ModelAndView("welcome4", "result", res);
	}

	@RequestMapping(value = "FundTransfer")
	public String funds(@ModelAttribute("s") Account account) {
		return "funds";
	}

	@RequestMapping(value = "fundata", method = RequestMethod.POST)
	public ModelAndView fundsTransferNow(@ModelAttribute("s") Account account) {
		String res = null;
		String[] mobile = account.getMobileno().split(",");
		for(String s : mobile)
			System.out.println(s);
		try {
			Account customer = service.fundTransfer(mobile[0], mobile[1], account.getBal());
			res = "Your current balance is "+customer.getBal();
		} catch (MyException e) {
			// TODO Auto-generated catch block
			res = e.getMessage();
		}
		return new ModelAndView("welcome3", "result", res);
	}



	@RequestMapping(value = "Withdraw")
	public String withdraw(@ModelAttribute("e") Account account) {
		return "Withdrawamount";
	}

	@RequestMapping(value = "withdata", method = RequestMethod.POST)
	public ModelAndView withdrawNow(@ModelAttribute("e") Account account) {
		String res = null;
		try {
			Account customer = service.withdrawAmount(account.getMobileno(), account.getBal());
			res = "Your current balance is "+customer.getBal();
		} catch (MyException e) {
			// TODO Auto-generated catch block
			res = e.getMessage();
		}
		return new ModelAndView("welcome2", "result", res);
	}

	@RequestMapping(value = "PrintTrans")
	public String print(@ModelAttribute("k") PrintTransactions printTran) {
		return "printTransactions";
	}

	@RequestMapping(value = "printdata", method = RequestMethod.POST)
	public ModelAndView printNow(@ModelAttribute("k") PrintTransactions printTran) {
		String res = null;
		List<PrintTransactions> list = null;
		try {
			list = service.getTransactions(printTran.getMobileNumber());
		} catch (MyException e) {
			// TODO Auto-generated catch block
			res = e.getMessage();
		} catch (InvalidPhoneNumber e) {
			// TODO Auto-generated catch block
			res = e.getMessage();
		}
		return new ModelAndView("Transaction", "result", list);
	}
}

