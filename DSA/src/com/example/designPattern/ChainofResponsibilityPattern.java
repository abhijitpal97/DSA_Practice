package com.example.designPattern;
class ChainAuthentication
{
	static int OAUTH = 1;
	static int OTP = 2;
	static int USER = 3;

	ChainAuthentication authentication;

	ChainAuthentication(ChainAuthentication authentication)
	{
		this.authentication=authentication;
	}

	public void authorize(int type , String message)
	{
		if(authentication != null) authentication.authorize(type , message);		
	}
}

class OAuthAuthentication extends ChainAuthentication
{
	OAuthAuthentication(ChainAuthentication authentication)
	{
		super(authentication);
	}

	public void authorize(int type , String message)
	{
		System.out.println(3);
		if(type == OAUTH) System.out.println(message);
		else super.authorize(type,message);
	}	
}

class OTPAuthentication extends ChainAuthentication
{
	OTPAuthentication(ChainAuthentication authentication)
	{
		super(authentication);
	}

	public void authorize(int type , String message)
	{
		System.out.println(2);
		if(type == OTP) System.out.println(message);
		else super.authorize(type,message);
	}
}

class UserAuthentication extends ChainAuthentication
{
	UserAuthentication(ChainAuthentication authentication)
	{
		super(authentication);
	}

	public void authorize(int type , String message)
	{
		System.out.println(1);
		if(type == USER) System.out.println(message);
		else super.authorize(type,message);
	}
}



public class ChainofResponsibilityPattern
{
	public static void main(String[] args)
	{
		ChainAuthentication authentication = new ChainAuthentication(new OAuthAuthentication
				(new OTPAuthentication(
						new UserAuthentication(null))));

		authentication.authorize(ChainAuthentication.OAUTH , "OAuth Authentication");
	}
}