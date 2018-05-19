package iv1350.saleprocess.model;

import java.lang.Exception;

import iv1350.saleprocess.dbhandler.DatabaseFailException;
import iv1350.saleprocess.dbhandler.ItemDTO;

public class ItemIdentifierException extends Exception {

	public ItemIdentifierException(String itemId){
		super("Unable to add item with ID " + itemId + ", since this item does not belong to the inventory.");
		
	}
}
