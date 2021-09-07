package kodlamaio.Hrms.Core.utilities;

public class Result {
	
	private boolean success;
	private String message;
	
	public Result(boolean success) {
		super();
		this.success = success;
	}

	public Result(boolean success, String message) {
		super();
		this.success = success;
		this.message = message;
	}
	
	public boolean isSuccess() {
		return success;
	}
	
	
   public String message() {
	   return message;
   }
	

}
