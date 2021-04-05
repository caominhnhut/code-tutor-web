'use strict';

angular.module('myApp.searchCriteria', [])

.directive('searchCriteria', function() {
    return {
        templateUrl: 'ui/search/search.html',
        controller: 'SearchCtrl'
    };
})

.controller('SearchCtrl', ['$scope', '$rootScope', '$http', '$location',
  function($scope, $rootScope, $http, $location){
    $scope.message = "this is SearchCtrl page";
  }]);