package iv1350.saleprocess.model;

import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import iv1350.saleprocess.dbhandler.ItemDTO;

/**
 * This is the Sale object for the saleprocess. Creating a new instance, representing the current sale.
 */
public class Sale {
	List<ItemDTO> shoppingCart = new ArrayList<ItemDTO>();
	private SaleDTO activeSaleDTO;
	private double runningTotal;
	private double runningTotalIncTax;
	private final double TAX = 1.1;
	
	/**
	 * Creates a new instance, records the time that the sale took place. 
	 */
	public void sale() {
	}
	
	/**
	 * Method addItem adds the current item to the sale, calculates the price and creates a {@Link SaleDTO}.
	 * @param currentItem The ItemDTO that are going to be added in the sale.
	 * @return The current SaleDTO, including all the sale information.
	 */
	public SaleDTO addItem(ItemDTO currentItem) {
		shoppingCart.add(currentItem);
		calculateRunningTotalExTax(shoppingCart);
		calculateRunningTotalIncTax();
		activeSaleDTO = new SaleDTO(currentItem, runningTotal, runningTotalIncTax, shoppingCart);
		return activeSaleDTO;
	}
	/**
	 * Calculates the running total without tax.
	 * @param updateShoppingCart is the current shopping cart with all the sales items.
	 * @return The price of the sale, without tax.
	 */
	private double calculateRunningTotalExTax(List<ItemDTO> updateShoppingCart) {
		runningTotal = 0;
		for(ItemDTO item : updateShoppingCart) {
		runningTotal += item.getPrice();
		}
		return runningTotal;
	}
	/**
	 * Calculates the running total with tax.
	 * @return The price of the sale, with tax.
	 */
	public double calculateRunningTotalIncTax() {
		runningTotalIncTax = runningTotal * TAX;
		return runningTotalIncTax;
	}
}

