var app = angular.module("uss", []);


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


app.controller('controller', function ($scope, $req) {
    $scope.address = "";
    $scope.reqAddress = function () {
        if ($scope.address == "")
            return;
        $.ajax({url: "/api/cross/search?query=" + $scope.address}).done(function (res) {
            var parser = new DOMParser();
            var xmlDoc = parser.parseFromString(res, "text/xml");
            try {
                var obj = XML2jsobj(xmlDoc.children[0]);
                $scope.items = obj.channel.item;
            } catch (e) {

            }
        });
    };

    $scope.showMap = function (mapx, mapy) {
        var tm = new nhn.api.map.TM128(mapx, mapy);
        var value = tm.toLatLng();
        var img = "http://openapi.naver.com/map/getStaticMap?version=1.0&crs=EPSG:4326&center=" +
            value.x +
            "," +
            value.y +
            "&level=10&w=300&h=300&maptype=default&markers=" +
            value.x +
            "," +
            value.y +
            "%20&key=c3eac894954fc7af3605dea2a332d0ca&uri=10.73.45.136"
        $scope.imgSrc = img;

    }

});
/**
 * XML2jsobj v1.0
 * Converts XML to a JavaScript object
 * so it can be handled like a JSON message
 *
 * By Craig Buckler, @craigbuckler, http://optimalworks.net
 *
 * As featured on SitePoint.com:
 * http://www.sitepoint.com/xml-to-javascript-object/
 *
 * Please use as you wish at your own risk.
 */

function XML2jsobj(node) {

    var data = {};

    // append a value
    function Add(name, value) {
        if (data[name]) {
            if (data[name].constructor != Array) {
                data[name] = [data[name]];
            }
            data[name][data[name].length] = value;
        }
        else {
            data[name] = value;
        }
    };

    // element attributes
    var c, cn;
    for (c = 0; cn = node.attributes[c]; c++) {
        Add(cn.name, cn.value);
    }

    // child elements
    for (c = 0; cn = node.childNodes[c]; c++) {
        if (cn.nodeType == 1) {
            if (cn.childNodes.length == 1 && cn.firstChild.nodeType == 3) {
                // text value
                Add(cn.nodeName, cn.firstChild.nodeValue);
            }
            else {
                // sub-object
                Add(cn.nodeName, XML2jsobj(cn));
            }
        }
    }

    return data;

}