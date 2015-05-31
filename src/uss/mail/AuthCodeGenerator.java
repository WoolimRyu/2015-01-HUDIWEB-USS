package uss.mail;

import java.util.Random;

public class AuthCodeGenerator {
	
	private static final String m = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

	Random r;

	public AuthCodeGenerator(Random r) {
		this.r = r;
	}

	public String make(int length) {
		String result = "";
		for (int i = 0; i < length; i++) {
			result += m.charAt(r.nextInt(m.length()));
		}
		return result;
	}
}


