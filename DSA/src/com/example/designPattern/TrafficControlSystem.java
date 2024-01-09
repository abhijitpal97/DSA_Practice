package com.example.designPattern;
interface TrafficInterface
{
	void red();
	void green();
	void orange();
}

class TrafficSystems implements TrafficInterface
{
	TrafficInterface systems;

	TrafficSystems()
	{
		systems = new TrafficRed();
	}

	public void red()
	{
		systems.red();
		if(systems instanceof TrafficRed)
		{
			systems = new TrafficOrange();
		}
	}

	public void green()
	{
		systems.green();

		if(systems instanceof TrafficGreen)
		{
			systems = new TrafficRed();
		}
	}

	public void orange()
	{
		systems.orange();

		if(systems instanceof TrafficOrange)
		{
			systems = new TrafficGreen();
		}
	}
}

class TrafficRed implements TrafficInterface
{
	public void red()
	{
		System.out.println("Red State");
	}

	public void green()
	{
		System.out.println("Can't Initiate Green State");
	}

	public void orange()
	{
		System.out.println("Can't Initiate Orange State");
	}
}


class TrafficOrange implements TrafficInterface
{
	public void red()
	{
		System.out.println("Can't Initiate Red State");
	}

	public void green()
	{
		System.out.println("Can't Initiate Green State");
	}

	public void orange()
	{
		System.out.println("Orange State");
	}
}


class TrafficGreen implements TrafficInterface
{
	public void red()
	{
		System.out.println("Can't Initiate Red State");
	}

	public void green()
	{
		System.out.println("Green State");
	}

	public void orange()
	{
		System.out.println("Can't Initiate Orange State");
	}
}


public class TrafficControlSystem
{
	public static void main(String[] args)
	{
		TrafficSystems systems = new TrafficSystems();

		systems.red();
		systems.orange();
		systems.red();
		systems.green();
		systems.red();
	}
}