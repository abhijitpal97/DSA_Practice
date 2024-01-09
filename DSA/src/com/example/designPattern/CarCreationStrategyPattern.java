package com.example.designPattern;
interface Drive
{
	void gear();
}

class ManualDrive implements Drive
{
	public void gear()
	{
		System.out.println("Manual Drive");
	}
}

class AutoDrive implements Drive
{
	public void gear()
	{
		System.out.println("Auto Drive");
	}
}

interface CarLook
{
	void look();
}

class SportyCar implements CarLook
{
	public void look()
	{
		System.out.println("Sporty Car");
	}
}

class SuvCar implements CarLook
{
	public void look()
	{
		System.out.println("Suv Car");
	}
}

class CarStrategy
{
	Drive drive;
	CarLook carlook;

	CarStrategy(Drive drive, CarLook carlook)
	{
		this.drive = drive;
		this.carlook = carlook;
	}

	public void setDrive(Drive drive)
	{
		this.drive = drive;
	}

	public Drive getDrive()
	{
		return drive;
	}

	public void setCarLook(CarLook carlook)
	{
		this.carlook = carlook;
	}

	public CarLook getCarLook()
	{
		return carlook;
	}

	public void gear()
	{
		drive.gear();
	}

	public void look()
	{
		carlook.look();
	}
}


public class CarCreationStrategyPattern
{
	public static void main(String[] args)
	{
		Drive manual = new ManualDrive();
		Drive auto = new AutoDrive();

		CarLook sporty = new SportyCar();
		CarLook suv = new SuvCar();

		CarStrategy manspo = new CarStrategy(manual , sporty);
		CarStrategy autsuv = new CarStrategy(auto , suv);

		manspo.gear();
		manspo.look();

		manspo.setCarLook(suv);
		manspo.look();

		autsuv.gear();
		autsuv.look();
		autsuv.setDrive(manual);
		autsuv.gear();
	}
}