var app = angular.module('login', []);


app.findScope = function (selector) {
    return angular.element(document.querySelector("[ng-controller='" + selector + "']")).scope();
};

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


        var success = http.success;
        http.onResponse = function (call) {
            success(function (response) {
                if (response.error) {
                    alert(response.errorMessage);
                    return;
                }
                call(response.response);
            });
        };

        return http;
    };
    return req;
});

app.controller('loginController', function ($scope, $user, $req, $timeout) {

    $scope.user = {};

    $scope.$watch(function () {
        return $user.email;
    }, function () {
        if ($user.logged)
           return;
        $scope.registeredEmail = false;
        $scope.checked = false;
        if ($user.email == undefined || !$scope.check.email())
            return;
        $timeout.cancel(this.req);
        this.req = $timeout(function () {
            $req("/api/user/registeredEmail", {email: $user.email}).success(function (response) {
                $scope.checked = true;
                if (response.error) {
                    return;
                }
                $scope.registeredEmail = true;
            });
        }, 500);
    });

    $scope.state = false;
    $scope.user = $user;

    $scope.login = function () {
        if ($scope.state != 'login') {
            $scope.state = 'login';
            return;
        }
        if ($user.email == undefined)
            return false;
        if ($user.password == undefined)
            return false;
        $req("/api/user/loginCheck", {user: JSON.stringify($user)}, "POST").onResponse(function (user) {
            angular.copy($user, user);
            $user.logged = true;
        });
    };

    $scope.register = function () {
        if ($scope.state != 'register') {
            $scope.state = 'register';
            return;
        }
        if ($user.email == undefined)
            return false;
        if ($user.password == undefined)
            return false;
        if ($user.name == undefined)
            return false;
        if ($user.gender == undefined)
            return false;
        $req("/api/user", {user: JSON.stringify($user)}, "POST").onResponse(function (user) {
            angular.copy($user, user);
            $user.logged = true;
        });
    };

    $scope.check = {
        email: function () {
            if ($user.email == undefined)
                return true;
            var regex = /^([\w-]+(?:\.[\w-]+)*)@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$/i;
            return regex.test($user.email);
        },
        password: function () {
            if ($user.password == undefined)
                return true;
            return /^[\w\W]{6,}$/i.test($user.password);
        },
        name: function () {
            if ($user.name == undefined)
                return true;
            return /^[\w\W]{2,}$/i.test($user.name);
        },

        login: function () {
            if ($scope.state != 'login')
                return true;
            if ($user.email == undefined)
                return false;
            if ($user.password == undefined)
                return false;
            if (!$scope.check.password())
                return false;
            if (!$scope.check.email())
                return false;
            return true;
        },
        loginError: function () {
            return $scope.checked && !$scope.registeredEmail && $scope.state == 'login';
        },
        register: function () {
            if ($scope.state != 'register')
                return true;
            if ($user.email == undefined)
                return false;
            if ($user.password == undefined)
                return false;
            if ($user.name == undefined)
                return false;
            if (!$scope.check.password())
                return false;
            if (!$scope.check.email())
                return false;
            if (!$scope.check.name())
                return false;
            return true;
        },
        registerError: function () {
            return $scope.registeredEmail && $scope.state == 'register';
        }
    };

    $scope.submit = function () {
        if($scope.user.stringId == undefined){
            alert("아이디를 입력하세요.");
            return;
        }
        $req('/api/user/register', {user: JSON.stringify($scope.user)}, "POST").success(
            function (response) {
            	if(response.error == 'success')
            		location.href = "/";
                alert(response.error);
            }
        )
    };
});
