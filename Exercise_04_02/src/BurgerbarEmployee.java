
public class BurgerbarEmployee implements Runnable {

	private Burgerbar burgerbar;

	private String name;

	public BurgerbarEmployee(String name, Burgerbar burgerbar) {
		this.burgerbar = burgerbar;
		this.name = name;
	}

	@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep(2000);
				burgerbar.makeBurger(name);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}