package com.cg.pwa.exception;

@SuppressWarnings("serial")
public class NameException extends Exception
{
	public NameException(String msg) 
	{
		// TODO Auto-generated constructor stub
		super("*****Invalid Name declaration*****\n"+ "***First letter should be capital remaining should be small letter***");
	}

}
