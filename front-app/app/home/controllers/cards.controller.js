(function() {

	'use strict';
	angular.module('main')
	.controller('CardsController', function ($scope, $timeout, $http, Config) {
		var mock = [{
			"title": "Blue towel at the swimming pool",
			"flames": 30,
			"type": "Lost and found", //pegar de um ENUM?
			"views": 130,
			"flamed": false,
			"comments":	[]
		}, {
			"title": "Summer soccer match against Bryan Killigan",
			"flames": 40, //39 + 1?
			"type": "Event", //pegar de um ENUM?
			"views": 130,
			"flamed": true,
			"comments":	[{
				"user": {
					"name": "Mike Moll"
				},
				"commentAt": 1463883950710,
				"comment": "Lorem ipsum dolor sit amet, consectetur adipiscing elit."
			}, {
				"user": {
					"name": "Daniel Felizi"
				},
				"commentAt": 1464884952680,
				"comment": "Lorem ipsum dolor sit amet, consectetur adipiscing elit."
			}]
		}, {
			"title": "Summer BBQ",
			"flames": 40,
			"type": "Event", //pegar de um ENUM?
			"views": 130,
			"flamed": true,
			"comments":	[{
				"user": {
					"name": "Augusto Marques"
				},
				"commentAt": 1463883950710,
				"comment": "Lorem ipsum dolor sit amet, consectetur adipiscing elit."
			}, {
				"user": {
					"name": "Helder Traci"
				},
				"commentAt": 1464884952680,
				"comment": "Lorem ipsum dolor sit amet, consectetur adipiscing elit."
			}, {
				"user": {
					"name": "Samuel Kitazume"
				},
				"commentAt": 1474794921180,
				"comment": "Lorem ipsum dolor sit amet, consectetur adipiscing elit."
			}]
		}];
	});
})();