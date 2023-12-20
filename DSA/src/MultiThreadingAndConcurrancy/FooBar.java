package MultiThreadingAndConcurrancy;
public class FooBar
{
	int n;
	int i;

	FooBar(int n) 
	{
		this.n = n;
		this.i = 0;
	}

	public void printBar()
	{
		synchronized(this)
		{
			while(i<=n)
			{
				try
				{
					if(i%2 == 1)
					{
						System.out.println("Bar");
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

	public void printFoo()
	{
		synchronized(this)
		{
			while(i<=n)
			{
				try
				{
					if(i%2 == 0)
					{
						System.out.println("Foo");
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
		FooBar oe = new FooBar(14);

		Thread t1 = new Thread(() -> oe.printBar());
		Thread t2 = new Thread(() -> oe.printFoo());

		t1.start();
		t2.start();
	}
}