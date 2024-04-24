package MultiThreadingAndConcurrancy;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ThreadParallelCalls
{
	public static String printA() throws InterruptedException
	{
		Thread.sleep(100);
		return "A";
	}

	public static String printB() throws InterruptedException
	{
		Thread.sleep(200);
		return "B";
	}

	public static String printC() throws InterruptedException
	{
		Thread.sleep(100);
		return "C";
	}

	public static String printD() throws InterruptedException
	{
		Thread.sleep(100);
		return "D";
	}

	public static void main(String[] args) throws InterruptedException, ExecutionException
	{
		long l1 = System.currentTimeMillis();
		ThreadParallelCalls s = new ThreadParallelCalls();

		StringBuilder sb = new StringBuilder();

		sb.append(s.printA());

		ExecutorService executors = Executors.newFixedThreadPool(4);
		Future<String> r1 = executors.submit(() -> s.printB());
		Future<String> r2 = executors.submit(() -> s.printC());

		sb.append(r1.get());
		sb.append(r2.get());

		sb.append(s.printD());
		
		long l2 = System.currentTimeMillis();
		System.out.println(sb+" - "+ (l2-l1));
	}
}