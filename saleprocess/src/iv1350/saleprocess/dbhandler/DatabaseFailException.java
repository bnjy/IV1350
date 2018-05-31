package iv1350.saleprocess.dbhandler;

import java.lang.RuntimeException;

public class DatabaseFailException extends RuntimeException {
	
	public DatabaseFailException(String msg){	
		super(msg);
	}
}
