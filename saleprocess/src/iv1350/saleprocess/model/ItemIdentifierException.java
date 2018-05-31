package iv1350.saleprocess.model;

import java.lang.Exception;
import java.util.Date;

public class ItemIdentifierException extends Exception {

	public ItemIdentifierException(String itemId){
		super("Unable to add item with ID " + itemId + ", since this item does not belong to the inventory.");
	}
	
}
