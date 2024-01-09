package com.example.designPattern;
import java.util.*;

interface Subject
{
	void registerObject(Observer o);
	void deregisterObject(Observer o);
	void notifyObservers();	
}


class Cricket implements Subject
{
	int run ;
	int over;
	int wicket;
	List<Observer> list;

	Cricket()
	{
		list = new ArrayList<>();
	}

	public void registerObject(Observer o1)
	{
		list.add(o1);
	}

	public void deregisterObject(Observer o1)
	{
		list.remove(list.indexOf(o1));
	}

	public void notifyObservers()
	{
		for(Observer o1 : list)
		{
			o1.update(run , over, wicket);
		}
	}

	private int getRun() { return 10; }
	private int getOver() { return 2; }
	private int getWicket() { return 1; }

	public void dataModified()
	{
		run = getRun();
		over = getOver();
		wicket = getWicket();

		notifyObservers();
	}

}


interface Observer
{
	void update(int run , int over , int wicket);
}


class Client1 implements Observer
{
	public void update(int run  , int over , int wicket)
	{
		System.out.println("Client 1 - "+run + " - "+over+ " - "+wicket);
	}
}


class Client2 implements Observer
{
	public void update(int run  , int over , int wicket)
	{
		System.out.println("Client 2 - "+run + " - "+over+ " - "+wicket + " - Average - " + (double)(run/over));
	}
}


public class ObserverDesignPattern
{
	public static void main(String[] args)
	{
		Client1 client1 = new Client1();
		Client2 client2 = new Client2();

		Cricket cricket = new Cricket();
		cricket.registerObject(client1);
		cricket.registerObject(client2);

		cricket.dataModified();

		cricket.deregisterObject(client2);

		cricket.dataModified();

		cricket.deregisterObject(client1);

		cricket.dataModified();
	}
}