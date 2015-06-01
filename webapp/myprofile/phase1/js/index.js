

function sendTemplateReq() {
	$.ajax({
		url : "/api/card?template=" + $('.active-img').attr('id').substring(1),
		method : "put",
		success : function(response) {

			var reponseType = {
				ERROR : 0,
				ERROR_USER_ALERT : 1,
				SUCCESS : 2,
				SUCCESS_USER_ALERT : 3
			};

			switch (response.code) {
			case reponseType.ERROR:
				return;
			case reponseType.ERROR_USER_ALERT:
				alert(response.message);
				return;
			case reponseType.SUCCESS:
				break;
			case reponseType.SUCCESS_USER_ALERT:
				alert(response.message);
				break;
			}
			location.href = "/myprofile/phase2/";
			return;
		}
	});
}