(function() {

	'use strict';
	angular.module('main')
	.controller('LeaveCommentController', function ($scope, $timeout, $http, Config, $state) {
		$scope.user = {
			username: '',
			password: ''
		};
	});
})();