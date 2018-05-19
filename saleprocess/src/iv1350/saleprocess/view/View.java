package iv1350.saleprocess.view;

import iv1350.saleprocess.controller.Controller;
import iv1350.saleprocess.dbhandler.DatabaseFailException;
import iv1350.saleprocess.model.EndSale;
import iv1350.saleprocess.model.ItemIdentifierException;
import iv1350.saleprocess.model.SaleDTO;
import iv1350.saleprocess.model.SaleObserver;

/**
 * This is a placeholder for the view. It contains only hardcoded calls and values to the controller.
 */
public class View {
	private Controller contr;
	private final double AMOUNT_PAID = 100.0;
	public SaleObserver saleObserver = new TotalRevenueView();
	
    /**
     * Constructs a new view, using the specified controller.
     * 
     * @param contr This controller will be used for all system operations.
     */
	public View(Controller contr) {
		this.contr = contr;
	}
	
    /**
     * Simulates a sample execution containing calls to all system operations.
     * @throws ItemIdentifierException if the specified itemID does not belong to the inventory, and notifies
     * the user that the itemID are missing in the inventory.
     */
	public void sampleExecution() throws ItemIdentifierException {
        contr.startSale();
        
        SaleDTO activeSaleDTO = null;
        SaleDTO secondSaleDTO = null;
        
        	try {
        activeSaleDTO = contr.scanItem("001");
        	} catch (ItemIdentifierException e) {
        		e.printStackTrace();
        		}
        	
        	try {
        activeSaleDTO = contr.scanItem("002");
        	} catch (ItemIdentifierException e) {
        		e.printStackTrace();
        		}
        	
         	try {
        activeSaleDTO = contr.scanItem("003");
         	} catch (ItemIdentifierException e) {
        		e.printStackTrace();
        		}
        	
         	try {
        activeSaleDTO = contr.scanItem("004");
         	} catch (ItemIdentifierException e) {
        		e.printStackTrace();
         	}        	
         	
        activeSaleDTO.itemsToString();
        
        EndSale endSale = contr.payment(AMOUNT_PAID);     
        contr.receiptCall(activeSaleDTO, endSale);
        contr.printerCall();
        
        contr.accountingSystemCall();
        contr.itemInventoryCall();
        
        contr.addRevenue();
        contr.addSaleObserver(saleObserver);
	    activeSaleDTO.nextSaleRevenue();
	    
	    contr.startSale();
        
	    	try {
	    	secondSaleDTO = contr.scanItem("001");
	    	} catch (ItemIdentifierException e) {
	    		e.printStackTrace();
	    		}
	    	
	    secondSaleDTO.itemsToString();
	    
	    endSale = contr.payment(AMOUNT_PAID);     
	    contr.receiptCall(secondSaleDTO, endSale);
	    contr.printerCall();
	    
	    contr.accountingSystemCall();
	    contr.itemInventoryCall();
	    
	    contr.addRevenue();
	    contr.addSaleObserver(saleObserver);
	    secondSaleDTO.nextSaleRevenue();
	}
}
