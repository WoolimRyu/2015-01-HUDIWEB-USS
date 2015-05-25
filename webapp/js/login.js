var app = angular.module('login', []);

app.findScope = function(selector) {
	return angular.element(
			document.querySelector("[ng-controller='" + selector + "']"))
			.scope();
};

app.factory('$req', function($http) {
	var req = function(url, data, method) {
		if (method == undefined)
			method = "GET";
		if (data != undefined) {
			url += "?";
			url += parse(data);
		}
		function parse(obj) {
			var str = [];
			for ( var p in obj)
				str.push(encodeURIComponent(p) + "="
						+ encodeURIComponent(obj[p]));
			return str.join("&");
		}

		var http = $http({
			method : method,
			url : url,
			headers : {
				'Content-Type' : 'application/x-www-form-urlencoded'
			}
		});

		var reponseType = {
			ERROR : 0,
			ERROR_USER_ALERT : 1,
			SUCCESS : 2,
			SUCCESS_USER_ALERT : 3
		};

		var success = http.success;
		http.onResponse = function(call) {
			success(function(response) {
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
				call(response.object);
			});
		};

		return http;
	};
	return req;
});

app.controller('loginController', function($scope, $req, $timeout) {

	$scope.user = {};

	$scope.submit = function() {
		if ($scope.user.stringId == undefined) {
			alert("아이디를 입력하세요.");
			return;
		}

		$req('/api/login', $scope.user, "POST").onResponse(function(response) {
			location.href = "/main/";
		})
	};
});
