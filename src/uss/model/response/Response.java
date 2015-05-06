package uss.model.response;

public class Response {

	private boolean error;
	private String errorMessage;
	private Object result;

	@Override
	public String toString() {
		return "Response [error=" + error + ", errorMessage=" + errorMessage + ", result=" + result + "]";
	}

	public Response(Object result) {
		this.result = result;
	}

	public Response(boolean error, String errorMessage) {
		this.error = true;
		this.errorMessage = errorMessage;
	}

	public boolean isError() {
		return error;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public Object getResult() {
		return result;
	}
	

}
