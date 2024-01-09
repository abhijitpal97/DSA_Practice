package com.example.designPattern;
interface State
{
	void alert(AlertState alertState);
}

class AlertState
{
	private State state;

	AlertState()
	{
		state = new VibrateState();
	}

	public void changeState(State newState)
	{
		state = newState;
	}

	public void alert()
	{
		state.alert(this);
	}
}

class VibrateState implements State
{
	public void alert(AlertState state)
	{
		System.out.println("Vibrating");
	}
}

class SilentState implements State
{
	public void alert(AlertState state)
	{
		System.out.println("Silent");
	}
}

public class StateDesignPattern
{
	public static void main(String[] args)
	{
		AlertState currState = new AlertState();
		currState.alert();
		currState.alert();

		currState.changeState(new SilentState());

		currState.alert();

		currState.changeState(new VibrateState());

		currState.alert();
	}
}