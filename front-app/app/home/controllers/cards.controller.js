(function() {

	'use strict';
	angular.module('main')
	.controller('CardsController', function ($scope, $timeout, $http, Config, Cards, Occurrence, 
Events, $state) {
		var occurrence = [{
			"id": 1,
			"title": "Blue towel at the swimming pool",
			"flames": 30,
			"type": "LOST_AND_FOUND", //pegar de um ENUM?
			"date": 1463883950710,
			"dateUpdate": 4,
			"views": 131,
			"flamed": false,
			"comments":	[]
		}];

		var events = [{
			"id": 1,
			"title": "Summer soccer match against Bryan Killigan",
			"flames": 40, //39 + 1?
			"type": "FOOTBALL", //pegar de um ENUM?
			"date": 1463883950710,
			"dateUpdate": 3,
			"views": 132,
			"flamed": true,
			"comments":	[{
				"user": {
					"name": "Mike Moll"
				},
				"commentAt": 1,
				"comment": "Lorem ipsum dolor sit amet, consectetur adipiscing elit. 1"
			}, {
				"user": {
					"name": "Daniel Felizi"
				},
				"commentAt": 2,
				"comment": "Lorem ipsum dolor sit amet, consectetur adipiscing elit. 2"
			}]
		}, {
			"id": 2,
			"title": "Summer BBQ",
			"flames": 40,
			"type": "BARBECUE", //pegar de um ENUM?
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
		}];

		occurrence.map(function(item) {
			item.type = Occurrence[item.type];
			item.cardType = Cards.OCCURRENCE;
		});

		events.map(function(item) {
			item.type = Events[item.type];
			item.cardType = Cards.EVENTS;
		});

		$scope.cards = occurrence.concat(events);

		$scope.showDetails = function(cardId, cardType) {
			$state.go('home.leaveComment', {
				cardId: cardId,
				cardType: cardType
			});
		};
	});

})();