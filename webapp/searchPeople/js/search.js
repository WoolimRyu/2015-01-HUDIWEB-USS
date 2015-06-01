var app = angular.module("uss", []);


app.factory('$req', function ($http) {
    var req = function (url, data, method) {
        if (method == undefined)
            method = "GET";
        if (data != undefined) {
            url += parse(data);
        }
        function parse(obj) {
            var str = [];
            for (var p in obj)
                str.push(encodeURIComponent(p) + "="
                + encodeURIComponent(obj[p]));
            return str.join("&");
        }

        var http = $http({
            method: method,
            url: url,
            headers: {
                'Content-Type': 'application/x-www-form-urlencoded'
            }
        });

        var reponseType = {
             ERROR: 0,
             ERROR_USER_ALERT: 1,
             SUCCESS: 2,
             SUCCESS_USER_ALERT: 3
        };

        var success = http.success;
        http.onResponse = function (call) {
            success(function (response) {
                 switch (response.code) {
                     case reponseType.ERROR:
                         return;
                     case reponseType.ERROR_USER_ALERT:
                         return;
                     case reponseType.SUCCESS:
                         break;
                     case reponseType.SUCCESS_USER_ALERT:
                         break;
                 }
                call(response.object);
            });
        };

        return http;
    };
    return req;
});

var scope;
app.controller('searchController', function($scope, $req) {
    $scope.results = [];
    $scope.suggestions = {};

    scope = $scope;

    var suggestionBox = document.querySelector('.suggestion-box');

    $scope.autocomplete = function () {
    	if ($scope.query === '') {
    		suggestionBox.style.display = 'none';
    		return;
    	}
        $req('/api/search?query=' + $scope.query, {}).onResponse(
       	function(response) {
       		suggestionBox.style.display = 'block';
       		$scope.suggestions = response;
        });

    };

    $scope.submit = function () {
        $req('/api/search?query=' + $scope.query, {}).onResponse(
       	function(response) {
       		suggestionBox.style.display = 'none';
       		$scope.query.value = '';

            // if (response.object == null)
            //     alert("검색 결과가 없습니다.");
       		$scope.results = response;
        });
    };
});