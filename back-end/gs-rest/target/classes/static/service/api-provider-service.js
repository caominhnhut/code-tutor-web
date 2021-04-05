angular.module('myApp.services', [])
.service('ServiceProvider',[ '$http', '$q', 'AuthorizationFactory', function($http, $q, authorizationFactory) {

    this.getApi = function (urlEndpoint) {
        var deffered = $q.defer();
        $http({
			url: urlEndpoint,
			method: 'GET',
			headers: authorizationFactory.createAuthorizationTokenHeader()
		})
		.success(function (response) {
            deffered.resolve(response);
        }).error(function (response) {
            deffered.reject(response);
        });
        return deffered.promise;
    }

    this.postApi = function(urlEndpoint, data){
        var deffered = $q.defer();
        $http({
			url: urlEndpoint,
			method: 'POST',
			data: data,
			headers: authorizationFactory.createAuthorizationTokenHeader()
        })
        .success(function (response) {
            deffered.resolve(response);
        }).error(function (response) {
            deffered.reject(response);
        });
        return deffered.promise;
    }

    this.postMutipartFileApi = function(urlEndpoint, data){
        var token = authorizationFactory.getValueByKey(TOKEN_KEY);
        var deffered = $q.defer();
        $http({
			url: urlEndpoint,
			method: 'POST',
			data: data,
			transformRequest: angular.identity,
			headers: {
				'Content-Type': undefined,
				'Authorization': "Bearer " + token
			}
        })
        .success(function (response) {
            deffered.resolve(response);
        }).error(function (response) {
            deffered.reject(response);
        });
        return deffered.promise;
    }
}])