package uss.response;

public class Response {

	public final static int ERROR = 0;
	public final static int ERROR_USER_ALERT = 1;
	public final static int SUCCESS = 2;
	public final static int SUCCESS_USER_ALERT = 3;

	Object object;
	private String message;
	private Integer code;

	@Override
	public String toString() {
		return "Response [object=" + object + ", message=" + message + ", code=" + code + "]";
	}

	public Response(String message, Integer code) {
		this.message = message;
		this.code = code;
	}

	public Response(Object object, Integer code) {
		this.object = object;
		this.code = code;
	}

	public Response(Object object, String message, Integer code) {
		this.object = object;
		this.message = message;
		this.code = code;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		result = prime * result + ((message == null) ? 0 : message.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Response other = (Response) obj;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		if (message == null) {
			if (other.message != null)
				return false;
		} else if (!message.equals(other.message))
			return false;
		return true;
	}

}
