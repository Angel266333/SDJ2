package burger;

public class Burgerbar {

	private int numberOfBurgers;
	private int maxNumberOfBurgers;
	
	public Burgerbar(int maxNumberOfBurgers) {
		this.numberOfBurgers = 0;
		this.maxNumberOfBurgers = maxNumberOfBurgers;
	}
	
	public synchronized void makeBurger(String who) {
		while(numberOfBurgers >= maxNumberOfBurgers) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println(who + " is ready to make a burger (" +
				numberOfBurgers + " left)");

		numberOfBurgers++;
		notifyAll();
	}
	
	public synchronized void eatBurger(String who) {
		while(numberOfBurgers <= 0) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println(who + " is ready to eat a burger (" +
				numberOfBurgers + " left)");

		numberOfBurgers--;
		notifyAll();
	}
	
	public synchronized int getNumberOfBurgers() {
		return numberOfBurgers;
	}
	
	
	
	
}
