package com.example.designPattern;
import java.util.*;

interface Queues
{
	void registerObject(Subscriber o);
	void deregisterObject(Subscriber o);
	void notifySubscribers();	
}


class Messages implements Queues
{
	private List<String> messages;
	private int index;
	private List<Subscriber> list;
	private String m1;

	Messages()
	{
		list = new ArrayList<>();
		messages = new ArrayList<>();
		index = 0;
	}
	public void registerObject(Subscriber o1)
	{
		list.add(o1);
	}

	public void deregisterObject(Subscriber o1)
	{
		list.remove(list.indexOf(o1));
	}

	public void notifySubscribers()
	{
		for(Subscriber o1 : list)
		{
			o1.update(m1);
		}
	}

	public void pushMessage(String str)
	{
		messages.add(str);
		dataModified();
	}

	private String getMessages()
	{
		String msg = messages.get(index);
		index++;
		return msg;
	}

	public void dataModified()
	{
		m1 = getMessages();

		notifySubscribers();
	}

}


interface Subscriber
{
	void update(String msg);
}


class Client1Q implements Subscriber
{
	public void update(String msg)
	{
		System.out.println("Client 1 - "+msg);
	}
}


class Client2Q implements Subscriber
{
	public void update(String msg)
	{
		System.out.println("Client 2 - "+msg);
	}
}


public class MQDesign
{
	public static void main(String[] args)
	{
		Client1Q client1 = new Client1Q();
		Client2Q client2 = new Client2Q();

		Messages messages = new Messages();
		messages.registerObject(client1);
		messages.registerObject(client2);

		messages.pushMessage("Abhijit");
		messages.pushMessage("Abhijit1");
		messages.pushMessage("Abhijit2");
		messages.pushMessage("Abhijit3");

		messages.deregisterObject(client2);

		messages.pushMessage("Abhijit4");

		messages.deregisterObject(client1);

	}
}