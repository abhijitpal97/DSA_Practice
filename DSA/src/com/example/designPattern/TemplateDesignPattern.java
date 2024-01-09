package com.example.designPattern;
abstract class PaymentValidator
{
	boolean isDebitCard;
	void validateCard()
	{
		System.out.println("Card Validated");
	}
	void transactionValdiate()
	{
		System.out.println("Amount Available in Debit Card");
	}
	void initiateTransaction() {};
	void completeTransaction() {};
	void process(boolean isDebitCard)
	{
		initiateTransaction();
		validateCard();
		if(isDebitCard) transactionValdiate();
		completeTransaction();
	}
}


class DebitCard extends PaymentValidator
{
	public void initiateTransaction()
	{
		System.out.println("Debit Card Trasnction Initiated");
	}

	public void completeTransaction()
	{
		System.out.println("Debit Card Transaction Completed Successfully");
	}
}

class CreditCard extends PaymentValidator
{
	public void initiateTransaction()
	{
		System.out.println("Credit Card Trasnction Initiated");
	}

	public void completeTransaction()
	{
		System.out.println("Credit Card Transaction Completed Successfully");
	}
}


public class TemplateDesignPattern
{
	public static void main(String[] args)
	{
		PaymentValidator debit = new DebitCard();
		debit.process(true);

		PaymentValidator credit = new CreditCard();
		credit.process(false);
	}
}