package uss.response;

public class Result {
	public static final Response ERROR_SQL_EXCUTE = new Response("SQL실행중 오류가 발생했습니다", Response.ERROR);

	public static final Response ERROR_BAD_REQUEST = new Response("비정상적인 접근 입니다", Response.ERROR_USER_ALERT);

	public static final Response ERROR_SEARCH_NOT_FOUND = new Response("검색결과가 없습니다.", Response.ERROR_USER_ALERT);

	public static final Response SUCCESS = SUCCESS(null);

	public static Response SUCCESS(Object object) {
		return new Response(object, Response.SUCCESS);
	}
}
