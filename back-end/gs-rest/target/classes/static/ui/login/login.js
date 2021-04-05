angular.module('myApp.login', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/login', {
    templateUrl: 'ui/login/login.html',
    controller: 'LoginCtrl'
  });
}])

.controller('LoginCtrl', ['$scope', '$rootScope', '$http', '$location', '$uibModalInstance', '$uibModal',
  function($scope, $rootScope, $http, $location, $uibModalInstance, $uibModal) {

      $scope.ok = function(){
        $uibModalInstance.close("Ok");
      }

      $scope.openRegisterView = function() {

        $uibModalInstance.dismiss();

        var modalInstance =  $uibModal.open({
            templateUrl: "ui/register/register.html",
            controller: "RegisterCtrl",
            size: '',
        });

        modalInstance.result.then(function(response){

        });
    };
}]);
