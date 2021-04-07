angular.module('myApp.factories', [])
.factory('AuthorizationFactory', function($http) {

    let TOKEN_KEY = 'jwtToken';

	//------USER NAME------
	var getValueByKey = function(key){
		return localStorage.getItem(key);
	}
	
	var setKeyValue = function(key, value) {
		localStorage.setItem(key, value);
	};
	
	var removeByKey = function(key) {
		localStorage.removeItem(key);
	};

	var createAuthorizationTokenHeader = function() {
		var token = getValueByKey(TOKEN_KEY);
		if (token) {
			return {
				"Authorization" : "Bearer " + token,
				'Content-Type' : 'application/json'
			};
		} else {
			return {
				'Content-Type' : 'application/json'
			};
		}
	};

	return {
		getValueByKey : getValueByKey,
		setKeyValue : setKeyValue,
		removeByKey : removeByKey,
		createAuthorizationTokenHeader : createAuthorizationTokenHeader
	};
});