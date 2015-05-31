var app = angular.module("uss", ['ngRoute']);

app.factory('$req', function ($http) {
    var req = function (url, data, method) {
        if (method == undefined)
            method = "GET";
        if (data != undefined) {
            url += "?";
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
            SUCCESS_USER_ALERT: 3,
            SUCCESS_SESSION_NULL: 4
        };

        var success = http.success;
        http.onResponse = function (call) {
            success(function (response) {
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
                    case reponseType.SUCCESS_SESSION_NULL:
                        alert(response.message);
                        location.href = "/";
                        break;
                }
                call(response.object);
            });
        };

        return http;
    };
    return req;
});


app.controller('cardController', function ($scope, $req, $routeParams, $timeout) {
    $scope.user = {};

    $scope.logout = function () {
        $req('/api/user/logout', {});
        location.href = "/";
    };

    $scope.addCard = function () {
        $req('/api/addcard/add', {cardId: $scope.card.cardId}).onResponse(function (response) {
            alert($scope.card.name + "is added in my cards");
        });
    }

    $req('/api/user/getRepresentiveCard', {stringId: location.pathname.substring(1)}).onResponse(
        function (response) {
            $scope.card = response;
        }
    )
});


