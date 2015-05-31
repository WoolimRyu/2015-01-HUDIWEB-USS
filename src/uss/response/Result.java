package uss.response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Result {

	private static final String LOG = "실행결과 : {}";

	private static final Logger logger = LoggerFactory.getLogger(Result.class);

	private static final Response ERROR_SQL_EXCUTE = new Response(
			"SQL실행중 오류가 발생했습니다", Response.ERROR);

	private static final Response ERROR_BAD_REQUEST = new Response(
			"비정상적인 접근 입니다", Response.ERROR_SESSION_REQUIRE);

	private static final Response ERROR_SEARCH_NOT_FOUND = new Response(
			"검색결과가 없습니다.", Response.ERROR_USER_ALERT);

	private static final Response ERROR_SESSION_EXPIRED = new Response(
			"세션이 만료되었습니다.", Response.ERROR_SESSION_REQUIRE);

	private static final Response SUCCESS = getSuccess(null);

	public static Response getSuccess(Object object) {
		Response response = new Response(object, Response.SUCCESS);
		logger.debug(LOG, response.toString());
		return response;
	}

	public static Response getErrorRegexNotMatched(String message) {
		Response response = new Response(message, Response.ERROR_USER_ALERT);
		logger.debug(LOG, response.toString());
		return response;
	}

	public static Response getErrorSqlExcute() {
		logger.debug(LOG, ERROR_SQL_EXCUTE.toString());
		return ERROR_SQL_EXCUTE;
	}

	public static Response getErrorBadRequest() {
		logger.debug(LOG, ERROR_BAD_REQUEST.toString());
		return ERROR_BAD_REQUEST;
	}

	public static Response getErrorSearchNotFound() {
		logger.debug(LOG, ERROR_SEARCH_NOT_FOUND.toString());
		return ERROR_SEARCH_NOT_FOUND;
	}

	public static Response getSuccess() {
		logger.debug(LOG, SUCCESS.toString());
		return SUCCESS;
	}

	public static Response getErrorSessionExpired() {
		return ERROR_SESSION_EXPIRED;
	}

	public static class Login {
		private static final Response ERROR_PASSWORD_NOT_MATCHED = new Response(
				"패스워드가 일치하지 않습니다.", Response.ERROR_USER_ALERT);
		private static final Response ERROR_USER_NULL = new Response(
				"없는 아이디 입니다.", Response.ERROR_USER_ALERT);

		public static Response getErrorPasswordNotMatched() {
			logger.debug(LOG, ERROR_PASSWORD_NOT_MATCHED.toString());
			return ERROR_PASSWORD_NOT_MATCHED;
		}

		public static Response getErrorUserNull() {
			logger.debug(LOG, ERROR_USER_NULL.toString());
			return ERROR_USER_NULL;
		}

	}

}
