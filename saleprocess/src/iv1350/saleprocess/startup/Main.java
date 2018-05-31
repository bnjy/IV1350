package iv1350.saleprocess.startup;

import iv1350.saleprocess.controller.Controller;
import iv1350.saleprocess.dbhandler.AccountingSystem;
import iv1350.saleprocess.dbhandler.DatabaseFailException;
import iv1350.saleprocess.dbhandler.ItemInventory;
import iv1350.saleprocess.dbhandler.Printer;
import iv1350.saleprocess.model.ItemIdentifierException;
import iv1350.saleprocess.view.View;

public class Main {
	
	public static void main(String[] args) throws Exception {
		
		ItemInventory inventory = new ItemInventory();
		Controller contr = new Controller(inventory);
		View view = new View (contr);
		
		view.sampleExecution();
	}
}
