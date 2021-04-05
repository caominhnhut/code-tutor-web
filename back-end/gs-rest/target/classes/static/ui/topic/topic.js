angular.module('myApp.topic', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/topic/:id', {
    templateUrl: 'ui/topic/topic.html',
    controller: 'TopicCtrl'
  });
}])

.controller('TopicCtrl', ['$scope', '$rootScope', '$http', '$routeParams',
  function($scope, $rootScope, $http, $routeParams){
    $scope.articleId = $routeParams.id;
  }
]);