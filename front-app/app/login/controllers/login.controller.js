(function() {

	'use strict';
	angular.module('main')
	.controller('LoginController', function ($scope, $timeout, $http, Config) {
		$scope.user = {
			username: '',
			password: ''
		};

		var authUser = function authUser() {
			if ($scope.user.username && $scope.user.password) {
				$http.post(Config.ENV.SERVER_URL + 'auth/login', $scope.user).then(
					function(data) {
						console.log('Login success!', data);
					},
					function(err) {
						console.log('Error: ', err);
					}
				);
			}
		};

		$scope.authUser = authUser;
	});
})();