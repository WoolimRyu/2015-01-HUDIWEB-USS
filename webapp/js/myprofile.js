var app = angular.module("uss", ['ngRoute']);

app.directive('updatable', function () {
        return {
            restrict: "A",
            template: "<div ng-show='!update'><div>{{updatable}} <i ng-click='updateMode()' class='fa fa-pencil-square-o'></i></div></div>" +
            "<div ng-show='update'><input ng-model='updatable'/><i ng-click='done()' class='fa fa-check'></i></div>",
            scope: {
                updatable: '='
            },
            controller: function ($scope) {
                $scope.update = false;
                $scope.updateMode = function () {
                    $scope.update = true;
                };
                $scope.done = function () {
                    $scope.update = false;
                };
            }

        }
    }
);
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
                        alert("Login Session Not Exist or Expired, Please Login");
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

var scope;
app.controller('cardController', function ($scope, $req, $routeParams, $timeout) {
    $scope.card = {};

    scope = $scope;
    $scope.logout = function () {
        $req('/api/user/logout', {});
        location.href = "/";
    };

    $scope.$watch('card', function () {
        $req('/api/card', $scope.card, "PUT").onResponse(
            function (response) {
                //  $scope.user = response;
            }
        );
    }, true);

    $req('/api/card', {stringId: location.pathname.substring(1)}).onResponse(
        function (response) {
            $scope.card = response;
        }
    );
});
