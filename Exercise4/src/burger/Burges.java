package burger;

public class Burges {

	public static void main(String[] args) {
		Burgerbar bar = new Burgerbar(20);
		BurgerbarEmployee emp = new BurgerbarEmployee("John", bar);
		BurgerbarCustomer customer1 = new BurgerbarCustomer("Stan", 5, bar);
		BurgerbarCustomer customer2 = new BurgerbarCustomer("Lee", 10, bar);

		Thread empThread = new Thread(emp);
		Thread cust1Thread = new Thread(customer1);
		Thread cust2Thread = new Thread(customer2);
		
		empThread.start();
		cust1Thread.start();
		cust2Thread.start();
		
	}

}
