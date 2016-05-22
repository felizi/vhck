(function() {

	'use strict';
	angular.module('main')
	.controller('CardsController', function ($scope, $timeout, $http, Config) {
		$scope.cards = [{
			"title": "Blue towel at the swimming pool",
			"flames": 30,
			"type": "Lost and found", //pegar de um ENUM?
			"views": 131,
			"flamed": false,
			"comments":	[]
		}, {
			"title": "Summer soccer match against Bryan Killigan",
			"flames": 40, //39 + 1?
			"type": "Event", //pegar de um ENUM?
			"views": 132,
			"flamed": true,
			"comments":	[{
				"user": {
					"name": "Mike Moll"
				},
				"commentAt": 1463883950710,
				"comment": "Lorem ipsum dolor sit amet, consectetur adipiscing elit. 1"
			}, {
				"user": {
					"name": "Daniel Felizi"
				},
				"commentAt": 1464884952680,
				"comment": "Lorem ipsum dolor sit amet, consectetur adipiscing elit. 2"
			}]
		}, {
			"title": "Summer BBQ",
			"flames": 40,
			"type": "Event", //pegar de um ENUM?
			"views": 133,
			"flamed": true,
			"comments":	[{
				"user": {
					"name": "Augusto Marques"
				},
				"commentAt": 1463883950710,
				"comment": "Lorem ipsum dolor sit amet, consectetur adipiscing elit. 3"
			}, {
				"user": {
					"name": "Helder Traci"
				},
				"commentAt": 1464884952680,
				"comment": "Lorem ipsum dolor sit amet, consectetur adipiscing elit. 4"
			}, {
				"user": {
					"name": "Samuel Kitazume"
				},
				"commentAt": 1474794921180,
				"comment": "Lorem ipsum dolor sit amet, consectetur adipiscing elit. 5"
			}]
		}];
	});
})();