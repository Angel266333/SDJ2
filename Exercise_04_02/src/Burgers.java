
public class Burgers {

	public static void main(String[] args) {
		Burgerbar bar = new Burgerbar(20);
		BurgerbarEmployee emp = new BurgerbarEmployee("Huan", bar);
		BurgerbarCustomer customer1 = new BurgerbarCustomer("Dave Hungary", bar, 5);
		BurgerbarCustomer customer2 = new BurgerbarCustomer("Joe Peppersome", bar, 10);

		Thread empThread = new Thread(emp);
		Thread cust1thread = new Thread(customer1);
		Thread cust2thread = new Thread(customer2);

		empThread.start();
		cust1thread.start();
		cust2thread.start();

	}
}