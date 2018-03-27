
public class ThreadDemo implements Runnable{
	
	@Override
	public void run() {
		for(int i=0;;i++)
			System.out.println(i);
	}	
}
