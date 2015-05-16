package uss.result;

public enum Result {

	LOGIN_NOT_EXIST_ID(true, "존재하지 않는 아이디입니다."), REGISTER_ALREADY_EXIST_ID(true, "이미 존재하는 아이디입니다."), REGISTER_SUCCESS(false, "회원가입 성공하였습니다."), LOGIN_PASSWORD_NOT_MATCHED(
			true, "패스워드가 다릅니다."), LOGIN_SUCCESS(false, "로그인 성공하였습니다."), USER_UPDATE_SESSION_EXPIRED(true, "세션이 만료되었습니다."), USER_UPDATE_USER_NULL(
			true, "유효하지 않은 접근입니다."), USER_UPDATE_SUCCESS(true, "유저 업데이트 성공하였습니다.");

	private String message;
	private boolean error;

	private Result(boolean error, String message) {
		this.message = message;
		this.error = error;
	}

	public String getMessage() {
		return message;
	}

	public boolean isError() {
		return error;
	}

}
