package com.example.designPattern;
interface Command
{
	void execute();
}

class Lights
{
	public void on() {System.out.println("Light is On"); }
	public void off() {System.out.println("Light is Off"); }
}

class Stereos
{
	public void on() {System.out.println("Stereo is On"); }
	public void off() {System.out.println("Stereo is Off"); }
	public void play() {System.out.println("Stereo is Playing"); }
}

class LightCommandOn implements Command
{
	Lights light;

	LightCommandOn(Lights light){this.light = light ;}

	public void execute()
	{
		light.on();
	}
}

class LightCommandOff implements Command
{
	Lights light;

	LightCommandOff(Lights light){this.light = light ;}

	public void execute()
	{
		light.off();
	}
}

class StereosCommandStart implements Command
{
	Stereos stereos;

	StereosCommandStart(Stereos stereos){this.stereos = stereos ;}

	public void execute()
	{
		stereos.on();
		stereos.play();
	}
}

class StereosCommandEnd implements Command
{
	Stereos stereos;

	StereosCommandEnd(Stereos stereos){this.stereos = stereos ;}

	public void execute()
	{
		stereos.off();
	}
}

class Client
{
	Command executer;

	void setCommand(Command executer)
	{
		this.executer=executer;
	}

	void buttonPressed()
	{
		executer.execute();
	}
}


public class CommandDesignPattern
{
	public static void main(String[] args)
	{
		Client client = new Client();
		Lights light = new Lights();
		Stereos stereos = new Stereos();

		client.setCommand(new LightCommandOn(light));
		client.buttonPressed();
		client.setCommand(new StereosCommandStart(stereos));
		client.buttonPressed();
		client.setCommand(new StereosCommandEnd(stereos));
		client.buttonPressed();
		client.setCommand(new LightCommandOff(light));
		client.buttonPressed();
	}
}
