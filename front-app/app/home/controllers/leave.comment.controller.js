(function() {

	'use strict';
	angular.module('main')
	.controller('LeaveCommentController', function ($scope, $timeout, $http, Config, $state, $stateParams) {
		//$scope.cardId = $stateParams.cardId;
		//$scope.cardType = $stateParams.cardType;
		$scope.cardTitle = $stateParams.cardTitle;

		var details = {
			"id": 2,
			"title": "Summer BBQ",
			"flames": 40,
			"type": "Event", //pegar de um ENUM?
			"date": 1463883950710,
			"dateUpdate": 2,
			"views": 133,
			"flamed": true,
			"comments":	[{
				"user": {
					"name": "Augusto Marques"
				},
				"commentAt": 3,
				"comment": "Lorem ipsum dolor sit amet, consectetur adipiscing elit. 3"
			}, {
				"user": {
					"name": "Helder Traci"
				},
				"commentAt": 4,
				"comment": "Lorem ipsum dolor sit amet, consectetur adipiscing elit. 4"
			}, {
				"user": {
					"name": "Samuel Kitazume"
				},
				"commentAt": 5,
				"comment": "Lorem ipsum dolor sit amet, consectetur adipiscing elit. 5"
			}]
		};
	});
})();