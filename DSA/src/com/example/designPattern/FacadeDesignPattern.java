package com.example.designPattern;
interface CarInterface
{
	void startKey();
	void startAc();
	void startMusic();

	void stopKey();
	void stopAc();
	void stopMusic();
}

class Vehicle implements CarInterface
{
	public void startKey()
	{
		System.out.println("Key Started");
	}

	public void startAc()
	{
		System.out.println("Ac Started");
	}

	public void startMusic()
	{
		System.out.println("Music Started");
	}

	public void stopMusic()
	{
		System.out.println("Key Started");
	}

	public void stopAc()
	{
		System.out.println("Ac Started");
	}

	public void stopKey()
	{
		System.out.println("Music Started");
	}

}

class FacadeVechile
{
	Vehicle vehicle;
	FacadeVechile(Vehicle vehicle)
	{
		this.vehicle=vehicle;
	}

	public void startProcess()
	{
		vehicle.startKey();
		vehicle.startAc();
		vehicle.startMusic();
	}

	public void stopProcess()
	{
		vehicle.stopMusic();
		vehicle.stopAc();
		vehicle.stopKey();
	}
}


public class FacadeDesignPattern
{
	public static void main(String[] args)
	{
		Vehicle vehicle  = new Vehicle();
		FacadeVechile facade = new FacadeVechile(vehicle);

		facade.startProcess();
		facade.stopProcess();
	}
}