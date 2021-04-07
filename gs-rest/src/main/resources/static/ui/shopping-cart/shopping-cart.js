angular.module('myApp.shoppingCart', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/cart', {
    templateUrl: 'ui/shopping-cart/shopping-cart.html',
    controller: 'ShoppingCartCtrl'
  });
}])

.controller('ShoppingCartCtrl', ['$scope', '$rootScope', '$http', '$location',
  function($scope, $rootScope, $http, $location){
    $scope.message = "this is ShoppingCartCtrl page";
  }]);