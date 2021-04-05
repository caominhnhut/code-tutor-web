angular.module('myApp.location', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/location', {
    templateUrl: 'ui/location/location.html',
    controller: 'LocationCtrl'
  });
}])

.controller('LocationCtrl', ['$scope', '$rootScope', '$http', '$location', '$compile',
  function($scope, $rootScope, $http, $location, $compile){

    $scope.cityDetail = function(index) {
        alert(JSON.stringify($scope.cities[index]));
    }

    $scope.initMap = function() {

        $scope.map = new google.maps.Map(document.getElementById('map'), {
            zoom: 17,
            center: { lat: 10.821128, lng: 106.636977 }
        });

        $scope.cities = [
            { title: 'Nguyen Sy Sach', lat: 10.821128, lng: 106.636977 },
            { title: 'Cho Tan Tru', lat: 10.8200586, lng: 106.6351846 },
        ];

        $scope.infowindow = new google.maps.InfoWindow({
            content: ''
        });

        for (var i = 0; i < $scope.cities.length; i++) {

            var marker = new google.maps.Marker({
                position: new google.maps.LatLng($scope.cities[i].lat, $scope.cities[i].lng),
                map: $scope.map,
                title: $scope.cities[i].title
            });

            var content = '<a ng-click="cityDetail(' + i + ')" class="btn btn-default">View details</a>';
            var compiledContent = $compile(content)($scope)

            google.maps.event.addListener(marker, 'click', (function(marker, content, scope) {
                return function() {
                    scope.infowindow.setContent(content);
                    scope.infowindow.open(scope.map, marker);
                };
            })(marker, compiledContent[0], $scope));
        }
    }
    $scope.initMap();

  }]);