package lib.mapping.view;

import lib.mapping.http.Http;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


public class Json implements View {

	private Object object;
	private String dateformat;

	public void setDateformat(String dateformat) {
		this.dateformat = dateformat;
	}

	public Json() {
	}

	public void setJsonObj(Object jsonObj) {
		this.object = jsonObj;
	}

	public Json(Object obj) {
		this.object = obj;
	}


	@Override
	public String toString() {
		return "Json [object=" + object + ", dateformat=" + dateformat + "]";
	}

	public Object getObject() {
		return object;
	}

	public void render(Http http) {
		Gson gson;
		if(dateformat!=null)
			gson = new GsonBuilder().setDateFormat(dateformat).create();
		else
			gson = new Gson();
		http.setContentType("application/json");
		http.write(gson.toJson(object));
	}

}
