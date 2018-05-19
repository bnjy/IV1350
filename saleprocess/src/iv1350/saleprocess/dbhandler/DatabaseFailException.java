package iv1350.saleprocess.dbhandler;

import java.lang.Exception;
import java.lang.RuntimeException;

public class DatabaseFailException extends RuntimeException {
	
	public DatabaseFailException(String itemId){	
		super("Runtime error: Log for admin: Item with ID " + itemId + " does not belong to the DB.\n");
		
	}
}
