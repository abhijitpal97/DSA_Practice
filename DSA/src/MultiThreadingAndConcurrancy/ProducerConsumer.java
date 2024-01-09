package MultiThreadingAndConcurrancy;

import java.util.concurrent.*;

class Producer implements Runnable
{
	BlockingQueue<Integer> bQ;

	Producer(BlockingQueue<Integer> bQ)
	{
		this.bQ = bQ;
	}

	@Override
	public void run()
	{
		try {
			for(int i = 1;i<=15; i++)
			{
				System.out.println("Produced - "+i);
				bQ.offer(i);
				//Thread.sleep(1000);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}


class Consumer implements Runnable
{
	BlockingQueue<Integer> bQ;

	Consumer(BlockingQueue<Integer> bQ)
	{
		this.bQ = bQ;
	}

	@Override
	public void run()
	{
		try {
			int taken = -1;

			while(taken != 15)
			{
				taken = bQ.take();
				System.out.println("Consumed - "+taken);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}


public class ProducerConsumer
{
	public static void main(String[] args)
	{
		BlockingQueue<Integer> bQ = new LinkedBlockingQueue<>(4);
		Producer prod = new Producer(bQ);
		Consumer cons = new Consumer(bQ);

		Thread t1 = new Thread(prod);
		Thread t2 = new Thread(cons);

		t1.start();
		t2.start();
	}
}