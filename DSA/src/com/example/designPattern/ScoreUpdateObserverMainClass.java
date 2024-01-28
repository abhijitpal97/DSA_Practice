package com.example.designPattern;

import java.util.*;

class ScoreUpdate
{
	int score = 0;;
	List<ObserverScore> observers;

	public ScoreUpdate() {
		// TODO Auto-generated constructor stub
		observers = new ArrayList<>();
	}

	void register(ObserverScore ob1)
	{
		observers.add(ob1);
	}

	void deregister(ObserverScore ob2)
	{
		observers.remove(observers.indexOf(ob2));
	}

	void updateScore(int newScore)
	{
		score = newScore;
		sendNotification(score);
	}

	void sendNotification(int score)
	{
		for(ObserverScore ob : observers)
		{
			ob.display(score);
		}
	}
}

class ObserverScore
{
	private int id;
	ObserverScore(int id)
	{
		this.id = id;
	}

	public void display(int score)
	{
		System.out.println("Id - "+id + " - score - "+score);
	}
}


public class ScoreUpdateObserverMainClass
{
	public static void main(String[] args)
	{
		ObserverScore o1 = new ObserverScore(1);
		ObserverScore o2 = new ObserverScore(2);
		ObserverScore o3 = new ObserverScore(3);

		ScoreUpdate scoreUpdate = new ScoreUpdate();
		scoreUpdate.register(o1);
		scoreUpdate.register(o2);
		scoreUpdate.register(o3);

		scoreUpdate.updateScore(10);
		scoreUpdate.updateScore(20);

		scoreUpdate. deregister(o2);

		scoreUpdate.updateScore(30);
	}
}