package burger;

public class BurgerbarCustomer implements Runnable{

	private String name;
	private int burgersToEat;
	private Burgerbar burgerbar;
	
	public BurgerbarCustomer(String name,int burgersToEat, Burgerbar burgerbar) {
		this.name = name;
		this.burgersToEat = burgersToEat;
		this.burgerbar = burgerbar;
	}
	
	@Override
	public void run() {
		for(int i = 0;i<burgersToEat;i++) {
			try {
				Thread.sleep(2000);
				burgerbar.eatBurger(name);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	} 
	
}
