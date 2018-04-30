package Figure_16_17;

public class ServicesFactory {

	static ServicesFactory instance;

	IAccountingAdapter accountingAdapter;
	IInventoryAdapter inventoryAdapter;
	ITaxCalculatorAdapter taxCalculatorAdapter;

	public ServicesFactory() {
		instance = new ServicesFactory();
	};

	public static ServicesFactory getInstance() {
		return new ServicesFactory();
	}

	public IInventoryAdapter getInventoryAdapter() {
		return inventoryAdapter;
	}

	public ITaxCalculatorAdapter getTaxCalculatorAdapter() {
		return taxCalculatorAdapter;
	}
}