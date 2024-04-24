package MultiThreadingAndConcurrancy;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class A implements Callable<String>
{
	@Override
	public String call()
	{
		return "A";
	}
}

class B implements Callable<String>
{
	@Override
	public String call()
	{
		return "B";
	}
}

class C implements Callable<String>
{
	@Override
	public String call()
	{
		return "C";
	}
}

class D implements Callable<String>
{
	@Override
	public String call()
	{
		return "D";
	}
}
public class CallableClassParallel
{

	public static void main(String[] args) throws InterruptedException, ExecutionException
	{
		long l1 = System.currentTimeMillis();

		A a = new A();
		B b = new B();
		C c = new C();
		D d = new D();

		StringBuilder sb = new StringBuilder();

		sb.append(a.call());

		ExecutorService executors = Executors.newFixedThreadPool(2);
		Future<String> r1 = executors.submit(b);
		Future<String> r2 = executors.submit(c);

		sb.append(r1.get());
		sb.append(r2.get());

		sb.append(d.call());

		long l2 = System.currentTimeMillis();
		System.out.println(sb+" - "+ (l2-l1));
	}
}