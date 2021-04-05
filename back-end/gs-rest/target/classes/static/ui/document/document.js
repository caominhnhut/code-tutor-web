angular.module('myApp.document', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/document', {
    templateUrl: 'ui/document/document.html',
    controller: 'DocumentCtrl'
  });
}])

.controller('DocumentCtrl', ['$scope', '$http', 'ServiceProvider', function($scope, $http, serviceProvider) {

}]);
