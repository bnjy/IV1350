package iv1350.saleprocess.logger;

import java.time.LocalDateTime;

public class LogHandler {
	
	private static final String FILE_NAME = "log.txt";
	
	/**
	 * Prints the error message log to the console.
	 * @param exception The exception thrown.
	 * @return 
	 */
	public void showLogMessage(Exception exception) {
		StringBuilder errorLogBuilder = new StringBuilder();
		System.out.print("[" + FILE_NAME + "]\n");
		exception.printStackTrace();
		errorLogBuilder.append(createTime() + "\n");
		errorLogBuilder.append("ERROR: ");
		errorLogBuilder.append(exception.getMessage() + "\n");
		errorLogBuilder.append("########################");
		System.out.println(errorLogBuilder + "\n");
	}
	
	private String createTime() {
		LocalDateTime now = LocalDateTime.now();
		return now.toString();
	}
}

