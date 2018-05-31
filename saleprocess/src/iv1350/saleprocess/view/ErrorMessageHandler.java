package iv1350.saleprocess.view;

import java.time.LocalDateTime;

import iv1350.saleprocess.model.ItemIdentifierException;

public class ErrorMessageHandler {
	
/**
  * Displays the specified error message.
  *
  * @param itemIdentfierExc The error message.
*/
	void showErrorMsg(ItemIdentifierException itemIdentfierExc) {
		StringBuilder errorMsgBuilder = new StringBuilder(); 
		errorMsgBuilder.append("[USER MESSAGE]\n");
		errorMsgBuilder.append(createTime() + "\n");
		errorMsgBuilder.append("ERROR: ");
		errorMsgBuilder.append(itemIdentfierExc.getMessage() + "\n");
		errorMsgBuilder.append("########################");
		System.out.println(errorMsgBuilder + "\n");
		
	}
	
	private String createTime() {
		LocalDateTime now = LocalDateTime.now();
		return now.toString();
	}
}
