package MultiThreadingAndConcurrancy;

public class FizzBuzz
{
	int n;
	int i;

	FizzBuzz(int n)
	{
		this.n = n;
		this.i = 1;
	}

	void printFizz() throws InterruptedException
	{
		//System.out.println("Fizz - " +Thread.currentThread().getName());
		synchronized (this) {
			while(i<=n)
			{
				if(i%3 == 0 && i%5 != 0)
				{
					System.out.println("Fizz - "+i);
					i++;
					notifyAll();
				}
				else wait();
			}
		}
	}

	void printBizz() throws InterruptedException
	{
		//System.out.println("Bizz - " +Thread.currentThread().getName());
		synchronized (this) {
			while(i<=n)
			{
				if(i%3 != 0 && i%5 == 0)
				{
					System.out.println("Bizz - "+i);
					i++;
					notifyAll();
				}
				else wait();
			}
		}
	}

	void printFizzBuzz() throws InterruptedException
	{
		//System.out.println("FizzBuzz - " +Thread.currentThread().getName());
		synchronized (this) {
			while(i<=n)
			{
				if(i%3 == 0 && i%5 == 0)
				{
					System.out.println("FizzBizz - "+i);
					i++;
					notifyAll();
				}
				else wait();
			}			
		}
	}

	void printNumber() throws InterruptedException
	{
		//System.out.println("Number - " +Thread.currentThread().getName());
		synchronized (this) {
			while(i<=n)
			{
				if(i%3 != 0 && i%5 != 0)
				{
					System.out.println(i);
					i++;
					notifyAll();
				}
				else wait();
			}
		}
	}

	public static void main(String[] args) 
	{
		FizzBuzz fb = new FizzBuzz(25);

		Thread t1 = new Thread(() -> {
			try {
				fb.printFizz();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		Thread t2 = new Thread(() -> {
			try {
				fb.printBizz();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		Thread t3 = new Thread(() -> {
			try {
				fb.printFizzBuzz();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		Thread t4 = new Thread(() -> {
			try {
				fb.printNumber();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});

		t1.start();
		t2.start();
		t3.start();
		t4.start();


	}
}