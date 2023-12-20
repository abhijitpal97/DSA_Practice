package MultiThreadingAndConcurrancy;
public class OddEven
{
	int n;
	int i;

	OddEven(int n) 
	{
		this.n = n;
		this.i = 1;
	}

	public void printOdd()
	{
		synchronized(this)
		{
			while(i<=n)
			{
				try
				{
					if(i%2 == 1)
					{
						System.out.println(i);
						i++;
						notifyAll();
					}
					else wait();
				}
				catch(Exception e) 
				{
					System.out.println(e.getMessage());
				}
			}
		}
	}

	public void printEven()
	{
		synchronized(this)
		{
			while(i<=n)
			{
				try
				{
					if(i%2 == 0)
					{
						System.out.println(i);
						i++;
						notifyAll();
					}
					else wait();
				}
				catch(Exception e) 
				{
					System.out.println(e.getMessage());
				}
			}
		}
	}

	public static void main(String[] args)
	{
		OddEven oe = new OddEven(14);

		Thread t1 = new Thread(() -> oe.printOdd());
		Thread t2 = new Thread(() -> oe.printEven());

		t1.start();
		t2.start();
	}
}