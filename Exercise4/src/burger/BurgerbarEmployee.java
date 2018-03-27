package burger;

public class BurgerbarEmployee implements Runnable{

	private String name;
	private Burgerbar burgerbar;
	
	public BurgerbarEmployee(String name, Burgerbar burgerbar) {
		this.name = name;
		this.burgerbar = burgerbar;
	}
	
	@Override
	public void run() {
		while(true) {
			try {
				Thread.sleep(1000);
				burgerbar.makeBurger(name);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
