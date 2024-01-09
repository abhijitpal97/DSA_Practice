package com.example.designPattern;
interface KickStrategy
{
	void kick();
}

class HeightKick implements KickStrategy
{
	public void kick()
	{
		System.out.println("Height Kick");
	}
}

class GroundKick implements KickStrategy
{
	public void kick()
	{
		System.out.println("Ground Kick");
	}
}


interface JumpStrategy
{
	void jump();
}

class LongJump implements JumpStrategy
{
	public void jump()
	{
		System.out.println("Long Jump");
	}
}

class ShortJump implements JumpStrategy
{
	public void jump()
	{
		System.out.println("Short Jump");
	}
}


abstract class Fighter
{
	KickStrategy kickStrategy;
	JumpStrategy jumpStrategy;

	Fighter(KickStrategy kickStrategy , JumpStrategy jumpStrategy)
	{
		this.kickStrategy = kickStrategy;
		this.jumpStrategy = jumpStrategy;
	}

	public void setKickStrategy(KickStrategy kickStrategy)
	{
		this.kickStrategy = kickStrategy;
	}

	public void setJumpStrategy(JumpStrategy jumpStrategy)
	{
		this.jumpStrategy = jumpStrategy;
	}

	public void jump()
	{
		jumpStrategy.jump();
	}

	public void kick()
	{
		kickStrategy.kick();
	}

	public void otherAction()
	{
		System.out.println("Any Action Fine");
	}

}

class X extends Fighter
{
	X(KickStrategy kickStrategy , JumpStrategy jumpStrategy)
	{
		super(kickStrategy , jumpStrategy);
	}

	public void display()
	{
		System.out.println("X");
	}
}

class Y extends Fighter
{
	Y(KickStrategy kickStrategy , JumpStrategy jumpStrategy)
	{
		super(kickStrategy , jumpStrategy);
	}

	public void display()
	{
		System.out.println("Y");
	}
}



public class StrategyDesignPattern
{
	public static void main(String[] args)
	{
		KickStrategy heightK = new HeightKick();
		KickStrategy groundK = new GroundKick();

		JumpStrategy longJ = new LongJump();
		JumpStrategy shortJ = new ShortJump();

		X x = new X(heightK , longJ);
		Y y = new Y(groundK , shortJ);

		x.display();
		x.jump();
		x.kick();
		x.otherAction();
		x.setJumpStrategy(shortJ);
		x.jump();

		y.display();
		y.jump();
		y.kick();
		y.otherAction();
		y.setKickStrategy(heightK);
		y.kick();
	}
}