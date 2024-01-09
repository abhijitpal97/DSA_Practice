package com.example.designPattern;
interface BreathImplmenter
{
	void breath();
}

class AnimalBreathImplementer implements BreathImplmenter
{
	public void breath()
	{
		System.out.println("Animal Breath");
	}
}

class WaterBreathImplementer implements BreathImplmenter
{
	public void breath()
	{
		System.out.println("Water Breath");
	}
}

class TreeBreathImplementer implements BreathImplmenter
{
	public void breath()
	{
		System.out.println("Tree Breath");
	}
}

class BreathBridgeClass
{
	BreathImplmenter bridgeClass;

	BreathBridgeClass(BreathImplmenter bridgeClass)
	{
		this.bridgeClass = bridgeClass;
	}

	public void breathObject()
	{}
}

class Dog extends BreathBridgeClass
{
	Dog(BreathImplmenter bridgeClass)
	{
		super(bridgeClass);
	}

	public void breathObject()
	{
		System.out.println("Dog Breath");
		bridgeClass.breath();
	}
}

class Fish extends BreathBridgeClass
{
	Fish(BreathImplmenter bridgeClass)
	{
		super(bridgeClass);
	}
	public void breathObject()
	{
		System.out.println("Fish Breath");
		bridgeClass.breath();
	}
}

class Tree extends BreathBridgeClass
{
	Tree(BreathImplmenter bridgeClass)
	{
		super(bridgeClass);
	}
	public void breathObject()
	{
		System.out.println("Tree Breath");
		bridgeClass.breath();
	}
}

public class BreathBridgeDesignPattern
{
	public static void main(String[] args)
	{
		BreathBridgeClass dog = new Dog(new AnimalBreathImplementer());
		BreathBridgeClass fish = new Fish(new WaterBreathImplementer());
		BreathBridgeClass tree = new Tree(new TreeBreathImplementer());

		dog.breathObject();
		fish.breathObject();
		tree.breathObject();
	}
}