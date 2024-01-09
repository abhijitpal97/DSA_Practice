package com.example.designPattern;
enum AuthType
{
	PATTERN,
	QR
}

class DesignAuthenticator
{

	DesignAuthenticator auth;

	public DesignAuthenticator(DesignAuthenticator auth)
	{
		this.auth = auth;
	}

	public String generateKey(AuthType type)
	{
		if(auth != null) return auth.generateKey(type);
		return "Default";
	}

	public void isValidated(AuthType type , String token)
	{
		if(auth != null) auth.isValidated(type , token);
	}

}

class PatternAuthenticator extends DesignAuthenticator
{

	PatternAuthenticator(DesignAuthenticator auth)
	{
		super(auth);
	}

	public String generateKey(AuthType type)
	{
		if(type == AuthType.PATTERN) return "Pattern";
		else return super.generateKey(type);
	}

	public void isValidated(AuthType type, String token)
	{
		if(type == AuthType.PATTERN) System.out.println("Pattern Validate with token - "+token);
		else super.isValidated(type,token);
	}
}

class QRAuthenticator extends DesignAuthenticator
{

	QRAuthenticator(DesignAuthenticator auth)
	{
		super(auth);
	}

	public String generateKey(AuthType type)
	{
		if(type == AuthType.QR) return "QR";
		else return super.generateKey(type);
	}


	public void isValidated(AuthType type,String token)
	{
		if(type == AuthType.QR) System.out.println("QR Validate with token - "+token);
		else super.isValidated(type,token);
	}
}

class FactoryAuthenticator
{
	public void runValidate(String token , DesignAuthenticator auth )
	{
		if(token.equals("Pattern"))
		{
			auth.isValidated(AuthType.PATTERN,token);
		}
		else if(token.equals("QR"))
		{
			auth.isValidated(AuthType.QR,token);
		}
	}
}
public class AuthenticationClient
{
	public static void main(String[] args)
	{
		DesignAuthenticator auth = new DesignAuthenticator(
				new PatternAuthenticator(new QRAuthenticator(null)));

		String token = auth.generateKey(AuthType.QR);

		FactoryAuthenticator factory = new FactoryAuthenticator();
		factory.runValidate(token, auth);

	}
}