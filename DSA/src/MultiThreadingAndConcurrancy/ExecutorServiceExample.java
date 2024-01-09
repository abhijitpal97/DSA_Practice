package MultiThreadingAndConcurrancy;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Display implements Runnable
{
	String str;

	Display(String str)
	{
		this.str = str;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("Run By - "+Thread.currentThread().getName()+" - "+str);

	}
}
public class ExecutorServiceExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Display d1 = new Display("A");
		Display d2 = new Display("B");
		Display d3 = new Display("C");
		Display d4 = new Display("D");

		ExecutorService services = Executors.newFixedThreadPool(3);

		services.execute(d1);
		services.execute(d2);
		services.execute(d3);
		services.execute(d4);
	}

}
