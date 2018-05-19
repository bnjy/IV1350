package iv1350.saleprocess.model;

import java.util.*;
import iv1350.saleprocess.dbhandler.ItemDTO;

/**
 * Represents the end session of an sale.
 */
public class EndSale {
	public double change;
	public double paidAmount;
	public double currentTotalIncTax;
	
	/**
	 * Creates a new instance.
	 */
	public EndSale() {
		
	}
	
	/**
	 * Calculates the change to give back to the customer.
	 * @param paidAmount The amount of money the customer gave the cashier. Hardcoded amount.
	 * @param cartPrice Is the total price of the current sale, including tax.
	 * @return
	 */
	public void change(double paidAmount, double cartPrice) {
		change = paidAmount - cartPrice;
	}
	
	public double getChange() {
		return this.change;
	}
	
	public String amountToString() {
		return "Cash back: " + change + " SEK inc tax.";
	}
}
