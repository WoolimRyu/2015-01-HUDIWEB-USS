package uss.model.result;

public class ResultWithObject {

	private Result result;
	private Object object;

	public Result getResult() {
		return result;
	}

	public void setResult(Result result) {
		this.result = result;
	}

	public Object getObject() {
		return object;
	}

	public void setObject(Object object) {
		this.object = object;
	}

	public ResultWithObject(Result result, Object object) {
		this.result = result;
		this.object = object;
	}

}
