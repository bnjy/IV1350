package iv1350.saleprocess.model;

import java.util.*;
import iv1350.saleprocess.dbhandler.ItemDTO;

/**
 * This is the SaleDTO object for the saleprocess. All the sale information are stored in this object.
 */
public class SaleDTO {
	private ItemDTO item;
	private double priceExTax;
	List<ItemDTO> shoppingCart;
	
	private List<SaleObserver> saleObservers = new ArrayList<>();
	private double runningTotalIncTax;
	private double currentTotalIncTax;
	RevenueKeeper revenueKeeper = new RevenueKeeper();
	
	/**
	 * The SaleDTO creates a DTO of the sale.
	 * @param item The ItemDTO.
	 * @param runningTotal The sale total price, without tax.
	 * @param runningTotalIncTax The sale total price, with tax.
	 * @param shoppingCart The list with all the sale items.
	 * @param saleTime Time stamp when the sale took place.
	 */
	public SaleDTO(ItemDTO item, double runningTotal, double runningTotalIncTax, List<ItemDTO> shoppingCart) {
		this.item = item;
		this.priceExTax = runningTotal;
		this.runningTotalIncTax = runningTotalIncTax;
		this.shoppingCart = shoppingCart;
	}
	/**
	 * A text representation of the items in the current sale. Collects all the information
	 * about the items in the current sale and make them able to be text represented.
	 */
	public void itemsToString() {
		StringBuilder sb = new StringBuilder();
		System.out.println("********** ITEMS **********" + "\n");
		for(ItemDTO item : shoppingCart) {
			sb.append(item.getItemId() + "." + " " +
					  item.getName() + " " +
					  item.getPrice() + " SEK" +  "\n");
		} 
		System.out.println(sb);
	}
	
	public ItemDTO getItemDTO() {
		return this.item;
	}
	
	public List<ItemDTO> getShoppingCart(){
		return this.shoppingCart;
	}
	
	public double getPriceExTax() {
		return this.priceExTax;
	}
	
	public double getPriceIncTax() {
		return this.runningTotalIncTax;
	}
	
    /**
     * The specified observer will be notified when a sale has ended.
     * @param observer The observer to notify.
     */
	public void addSaleObserver(SaleObserver observer) {
		saleObservers.add(observer);
	}
	
    /**
     * Method nextSaleRevenue will call method notifyObserver.
     */
    public void nextSaleRevenue() {
        notifyObservers();
    }
    
    /**
     * Method notifyObservers will go thru all observers in the list and send
     * them the current revenue value.
     */
	private void notifyObservers() {
		 for (SaleObserver saleObserver : saleObservers) {
			 saleObserver.saleRevenueChanged(revenueKeeper.getRevenue());
	     }
	}
}
