package com.example.designPattern;
interface ATMState
{
	void insertDebitCard();
	void insertpinAndWithdraw();
	void ejectDebitCard();	
}

class NoATMState implements ATMState
{
	public void insertDebitCard()
	{
		System.out.println("Insert Card");
	}
	public void insertpinAndWithdraw()
	{
		System.out.println("No Card to withdraw");
	}
	public void ejectDebitCard()
	{
		System.out.println("No Card");
	}
}

class HasATMState implements ATMState
{
	public void insertDebitCard()
	{
		System.out.println("Card is already inserted");
	}
	public void insertpinAndWithdraw()
	{
		System.out.println("Eject Card");
	}
	public void ejectDebitCard()
	{
		System.out.println("Pin Entered for Withdrawl");
	}
}


class ATM implements ATMState
{
	private ATMState state;

	ATM()
	{
		state = new NoATMState();
	}

	public ATMState getATMState()
	{
		return state;
	}

	public void setATMState(ATMState state)
	{
		this.state = state;
	}



	public void insertDebitCard()
	{
		state.insertDebitCard();

		if(state instanceof NoATMState)
		{
			setATMState(new HasATMState());
			System.out.println("State Moved to Has ATM");
		}
	}
	public void insertpinAndWithdraw()
	{
		state.insertpinAndWithdraw();
	}
	public void ejectDebitCard()
	{
		state.ejectDebitCard();

		if(state instanceof HasATMState)
		{
			setATMState(new NoATMState());
			System.out.println("State Moved to No ATM");
		}
	}
}


public class ATMMachineStateDesign
{
	public static void main(String[] args)
	{
		ATM atm = new ATM();
		atm.insertpinAndWithdraw();
		atm.ejectDebitCard();

		atm.insertDebitCard();
		atm.insertpinAndWithdraw();
		atm.insertDebitCard();
		atm.ejectDebitCard();
	}
}