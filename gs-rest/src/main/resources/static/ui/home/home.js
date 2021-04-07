angular.module('myApp.home', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/', {
    templateUrl: 'ui/home/home.html',
    controller: 'HomeCtrl'
  });
}])

.controller('HomeCtrl', ['$scope', '$http', 'ServiceProvider', function($scope, $http, serviceProvider) {

    // $scope.getLatestProducts = function(){

    //         let URL = "rest/no-auth/product/find";

    //         let requestData = {
    //             "id": "",
    //             "name": "",
    //             "priceFrom": "",
    //             "priceTo": "",
    //             "size": "",
    //             "status": "",
    //             "categoryId": ""
    //         }

    // 		var promise = serviceProvider.postApi(URL, requestData);
    // 		promise.then(function (response) {
    // 			$scope.products = response;
    // 			console.log($scope.products);
    // 		}, function (errorPayload) {
    // 			console.log('Can not get latest products', errorPayload);
    // 		})
    // 	}
    // $scope.getLatestProducts();
}]);
