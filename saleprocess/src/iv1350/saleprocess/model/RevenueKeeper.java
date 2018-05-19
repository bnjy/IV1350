package iv1350.saleprocess.model;

/**
 * This is the RevenueKeeper object for the saleprocess. the revenue are kept in this class.
 */
public class RevenueKeeper {
	public static double revenue;
	
	/**
	 * This is the saleprocess's revenue keeper. The total sale revenue are calculated here.
	 */
	public RevenueKeeper() {
	}

	/**
	 * Adds the current sales running total to the variable <revenue>.
	 * @param cartPrice is the current sales running total, inc tax.
	 */
	public void addRevenue(double cartPrice) {
		revenue = revenue + cartPrice;
	}
	
	public double getRevenue() {
		return revenue;
	}
}
