var app = angular.module("uss", []);

var scope;

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
            SUCCESS_USER_ALERT: 3
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
                }
                call(response.object);
            });
        };

        return http;
    };
    return req;
});


function card(name, company, phoneNumber, groupId) {
    this.name = name;
    this.company = company;
    this.phoneNumber = phoneNumber;
    this.groupId = groupId;
}
//
//function friend(name, job, n, group){
//	this.name = name;
//	this.job = job;
//	this.phoneNumber = n;
//	this.group = group;
//}


app.controller('listController', function ($scope, $req, $timeout) {
    var cards = $scope.cards = [];
    scope = $scope;

    $scope.group = [1];

    $scope.modalSelect = function (g) {
        $scope.modalSelected = g;
    }

    $scope.cards = [];

    $req('/api/addcard/list').onResponse(function (response) {
        if (response == undefined)
            return;
        response.forEach(function (each) {
            $scope.cards.push(each.right);
        });
    });


    $scope.rightView = function (viewNum) {
        if (viewNum == 0) {
            $scope.viewNum1 = true;
            $scope.viewNum2 = false;
            $scope.viewNum3 = false;
        }
        if (viewNum == 1) {
            $scope.viewNum1 = false;
            $scope.viewNum2 = true;
            $scope.viewNum3 = false;
        }
        if (viewNum == 2) {
            $scope.viewNum1 = false;
            $scope.viewNum2 = false;
            $scope.viewNum3 = true;
        }
    }
});
//    
//app.controller('listController', function ($scope, $req, $timeout) {
//    var friends = $scope.friends =  [];
//    scope = $scope;
//    
//    friends.push(new friend("abc","asdf", "asdf",1))
//    friends.push(new friend("abc","g2", "asdf",2))
//    friends.push(new friend("2","g3", "asdf",3))
//    friends.push(new friend("abc","g4", "asdf",4))
//    friends.push(new friend("2","asdf", "asdf",5))
//
//    $scope.group = [1,2,3,4];
//    
//    $scope.modalSelect =function(g){
//    	$scope.modalSelected = g;
//    }
//    
//    $scope.rightView = function(viewNum){
//    	if(viewNum == 0){
//    		$scope.viewNum1 = true;
//    		$scope.viewNum2 = false;
//    		$scope.viewNum3 = false;
//    	}
//    	if(viewNum == 1){
//    		$scope.viewNum1 = false;
//    		$scope.viewNum2 = true;
//    		$scope.viewNum3 = false;
//    	}
//    	if(viewNum == 2){
//    		$scope.viewNum1 = false;
//    		$scope.viewNum2 = false;
//    		$scope.viewNum3 = true;
//    	}
//    }
//});
