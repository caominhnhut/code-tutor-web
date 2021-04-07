angular.module('myApp.course', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/course', {
    templateUrl: 'ui/course/course.html',
    controller: 'CourseCtrl'
  });
}])

.controller('CourseCtrl', ['$scope', '$http', 'ServiceProvider', function($scope, $http, serviceProvider) {

}]);
