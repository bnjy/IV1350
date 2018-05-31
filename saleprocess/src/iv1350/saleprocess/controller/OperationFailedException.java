package iv1350.saleprocess.controller;

import iv1350.saleprocess.dbhandler.DatabaseFailException;

public class OperationFailedException extends Exception {

	public OperationFailedException(DatabaseFailException databaseFailExc) {
		super("Failed operation: Could not connect to database");
	}
}
