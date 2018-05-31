package iv1350.saleprocess.controller;

import iv1350.saleprocess.model.EndSale;
import iv1350.saleprocess.model.ItemIdentifierException;
import iv1350.saleprocess.model.Receipt;
import iv1350.saleprocess.model.RevenueKeeper;
import iv1350.saleprocess.model.Sale;
import iv1350.saleprocess.model.SaleDTO;
import iv1350.saleprocess.model.SaleObserver;
import iv1350.saleprocess.dbhandler.AccountingSystem;
import iv1350.saleprocess.dbhandler.DatabaseFailException;
import iv1350.saleprocess.dbhandler.ItemDTO;
import iv1350.saleprocess.dbhandler.ItemInventory;
import iv1350.saleprocess.dbhandler.Printer;

/**
 * This is the saleprocess's controller. All model calls pass through here.
 */
public class Controller {
	private Sale sale;
	private ItemDTO currentItem;
	private ItemInventory inventory;
	private SaleDTO activeSaleDTO;
	RevenueKeeper revenueKeeper = new RevenueKeeper();
	
    /**
     * The Controller creates an empty instance of {@link Sale}.
     * @param inventory This parameter is used for calls to the {@link ItemInventory}.
     */
	public Controller(ItemInventory inventory) {
		this.inventory = inventory;
	}

	public void startSale() {
		sale = new Sale();
	}
	/**
	 * The method scanItem searches the inventory for the current item. If the current item is found,
     * the sale instance adds the current item to the sell and creates a {@link SaleDTO}.
	 * @param itemId is the item identifier of the scanned item.
	 * @return activeSaleDTO the gathered information about the sale.
	 * @throws ItemIdentifierException
	 */
	public SaleDTO scanItem(String itemId) throws OperationFailedException, ItemIdentifierException {
		try {
		currentItem = inventory.searchItem(itemId);
		}
		catch(DatabaseFailException databaseFailExc) {
			throw new OperationFailedException(databaseFailExc);
		}
		return activeSaleDTO = sale.addItem(currentItem);
	}
	/**
	 * The method payment creates an instance of {@link EndSale} and calculates the change to
     * bring back to the customer.
	 * @param amountPaid is the hardcoded value of customer payment.
	 * @return endSale is the returned object including information about 
	 * the change that the customer receives.
	 */
	public EndSale payment(double amountPaid) {
		EndSale endSale = new EndSale();
		endSale.change(amountPaid, activeSaleDTO.getPriceIncTax());
		return endSale;
	}
	
    /**
    * The void method accountingSystemCall creates object of AccountingSystem and makes "fake" call to
    * update external system.
    */
	public void accountingSystemCall() {
		AccountingSystem accountingSystemCall = new AccountingSystem();
		accountingSystemCall.updateAccountingSystem();
	}
	
    /**
    *The void method itemInventoryCall creates object of ItemInventory and makes "fake" call to update
    * external system.
    */
	public void itemInventoryCall() {
		ItemInventory itemInventoryCall = new ItemInventory();
		itemInventoryCall.updateItemInventorySystem();	
	}
	/**
	 * The void method receipt creates an object Receipt and calls the receipt toString method to print
	 * the price information regarding the sale.
	 * @param activeSaleDTO brings the price information to the method.
	 * @param endSale brings the change amount to the method.
	 */
	public void receiptCall(SaleDTO activeSaleDTO, EndSale endSale) {
		Receipt receiptCall = new Receipt();
		receiptCall.receiptToString(activeSaleDTO, endSale);
		receiptCall.receiptOutput();
		
	}
	/**
	 * The void method printer call creates an object Printer and makes a "fake" call to the
	 * printer method printerOutput. This call represents a call to an external system.
	 * 
	 */
	public void printerCall() {
		Printer printerCall = new Printer();
		printerCall.printerOutput();
	}
	
    /**
     * The specified observer will be notified when a sale has ended.
     * @param observer The observer to notify.
     */
	public void addSaleObserver(SaleObserver observer) {
		sale.addSaleObserver(observer);
	}
	
    /**
     * Method showNextRevenue will notify all observer and further show
     * the updated revenue on the display.
     */
    public void showNextRevenue() {
    	sale.showNextSaleRevenue();
    }
    
    /**
     * Method addRevenue adds the current running total inc tax to the object
     * in class {@link RevenueKeeper}.
     */
	public void addRevenue() {
		revenueKeeper.addRevenue(sale.calculateRunningTotalIncTax());
	}
}
