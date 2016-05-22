(function() {

	'use strict';
	angular.module('main')
	.controller('HomeController', function ($scope, $timeout, $http, Config, $state) {
		var logOut = function logOut() {
			$state.transitionTo('login');
		};

		$scope.logOut = logOut;
	});
})();