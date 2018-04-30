
public class BurgerbarCustomer implements Runnable {

	private Burgerbar burgerbar;

	private int burgersToEat;
	private String name;

	public BurgerbarCustomer(String name, Burgerbar burgerbar, int burgersToEat) {
		this.burgerbar = burgerbar;
		this.burgersToEat = burgersToEat;
		this.name = name;
	}

	@Override
	public void run() {
		for (int i = 0; i < burgersToEat; i++) {
			try {
				Thread.sleep(2000);
				burgerbar.eatBurger(name);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}