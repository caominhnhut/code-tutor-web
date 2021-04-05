angular.module('myApp.article', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/article/:id', {
    templateUrl: 'ui/article/article.html',
    controller: 'ArticleCtrl'
  });
}])

.controller('ArticleCtrl', ['$scope', '$rootScope', '$http', '$routeParams',
  function($scope, $rootScope, $http, $routeParams){
    $scope.message = "Article id is: "+$routeParams.id;
  }]);