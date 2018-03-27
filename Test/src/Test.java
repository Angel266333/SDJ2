
public class Test {
	
	public static void main(String[] args) {
		
		Runnable r = new ThreadDemo();
		Thread t = new Thread(r);
		t.start();
		
		Runnable z = new PrintingLetters();
		Thread t1 = new Thread(z);
		t1.start();
		
		for(int i=0;i<50;i++)
			System.out.println("MAIN");
	}

}
