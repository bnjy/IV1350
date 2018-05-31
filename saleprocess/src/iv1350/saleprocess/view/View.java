package iv1350.saleprocess.view;

import iv1350.saleprocess.controller.Controller;
import iv1350.saleprocess.controller.OperationFailedException;
import iv1350.saleprocess.logger.LogHandler;
import iv1350.saleprocess.model.EndSale;
import iv1350.saleprocess.model.ItemIdentifierException;
import iv1350.saleprocess.model.Sale;
import iv1350.saleprocess.model.SaleDTO;
import iv1350.saleprocess.model.SaleObserver;

/**
 * This is a placeholder for the view. It contains only hardcoded calls and values to the controller.
 */
public class View {
	private ErrorMessageHandler errorMessageHandler = new ErrorMessageHandler();
	private LogHandler logHandler = new LogHandler();
	private Controller contr;
	private final double AMOUNT_PAID = 100.0;
	public SaleObserver saleObserver = new TotalRevenueView();
	public Sale sale = new Sale();
	
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
     * @throws OperationFailedException 
     */
	public void sampleExecution() throws ItemIdentifierException, OperationFailedException {
        contr.startSale();
        
        SaleDTO activeSaleDTO = null;
        SaleDTO secondSaleDTO = null;
        
      //Sale that will cause an ItemNotFoundException
        	try {
        		activeSaleDTO = contr.scanItem("001");
        	} catch (ItemIdentifierException itemIdentfierExc) {
        		errorMessageHandler.showErrorMsg(itemIdentfierExc);
        		}
        	
        	try {
        		activeSaleDTO = contr.scanItem("002");
        	} catch (ItemIdentifierException itemIdentfierExc) {
        		errorMessageHandler.showErrorMsg(itemIdentfierExc);
        		}
        	
         	try {
         		activeSaleDTO = contr.scanItem("123");
         	} catch (ItemIdentifierException itemIdentfierExc) {
         		errorMessageHandler.showErrorMsg(itemIdentfierExc);
         	}	

        	
         	try {
         		activeSaleDTO = contr.scanItem("003");
         	} catch (ItemIdentifierException itemIdentfierExc) {
         		errorMessageHandler.showErrorMsg(itemIdentfierExc);
        		}
         	
        activeSaleDTO.itemsToString();
        
        EndSale endSale = contr.payment(AMOUNT_PAID);     
        contr.receiptCall(activeSaleDTO, endSale);
        contr.printerCall();
        
        contr.accountingSystemCall();
        contr.itemInventoryCall();
        
        contr.addRevenue();
        contr.addSaleObserver(saleObserver);
	    contr.showNextRevenue();
	    
	    contr.startSale();
	    
	    //Sale that will cause an DBConnectionException
	    	try {
	    		secondSaleDTO = contr.scanItem("001");
	    	} catch (OperationFailedException operationFailedExc) {
	    		logHandler.showLogMessage(operationFailedExc);
	    		}
	    	
	    	try {
	    		secondSaleDTO = contr.scanItem("004");
	    	} catch (OperationFailedException operationFailedExc) {
         		logHandler.showLogMessage(operationFailedExc);
         	}
	    
	    secondSaleDTO.itemsToString();
	    
	    endSale = contr.payment(AMOUNT_PAID);     
	    contr.receiptCall(secondSaleDTO, endSale);
	    contr.printerCall();
	    
	    contr.accountingSystemCall();
	    contr.itemInventoryCall();
	    
	    contr.addRevenue();
	    contr.addSaleObserver(saleObserver);
	    contr.showNextRevenue();
	}
}
