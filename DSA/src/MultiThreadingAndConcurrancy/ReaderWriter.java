package MultiThreadingAndConcurrancy;

import java.util.concurrent.Semaphore;

public class ReaderWriter
{
	private static Semaphore readLock = new Semaphore(1);
	private static Semaphore writeLock = new Semaphore(1);
	static volatile int counter = 0;

	static class Reader implements Runnable
	{
		@Override
		public void run()
		{
			try
			{
				readLock.acquire();
				counter++;
				if(counter == 1) writeLock.acquire();
				readLock.release();

				System.out.println("Read in Progress by Thread - " +Thread.currentThread().getName());
				Thread.sleep(2500);
				System.out.println("Read completed by Thread - " + Thread.currentThread().getName());

				counter--;

				if(counter == 0) writeLock.release();
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
		}
	}

	static class Writer implements Runnable
	{
		@Override
		public void run()
		{
			try
			{
				writeLock.acquire();


				System.out.println("Write in Progress by Thread - " +Thread.currentThread().getName());
				Thread.sleep(1000);
				System.out.println("Write completed by Thread - " +Thread.currentThread().getName());

				writeLock.release();
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
		}
	}

	public static void main(String[] args)
	{
		Reader read = new Reader();
		Writer write = new Writer();

		Thread t1 = new Thread(read);
		Thread t2 = new Thread(read);
		Thread t3 = new Thread(write);
		Thread t4 = new Thread(read);
		Thread t5 = new Thread(read);
		Thread t6 = new Thread(write);
		Thread t7 = new Thread(write);
		Thread t8 = new Thread(read);
		Thread t9 = new Thread(read);
		Thread t10 = new Thread(read);


		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
		t6.start();
		t7.start();
		t8.start();
		t9.start();
		t10.start();
	}
}