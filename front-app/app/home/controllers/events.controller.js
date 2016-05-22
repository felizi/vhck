'use strict';
angular.module('main')
  .controller('EventsController', function($scope, $timeout, $http, Config, Cards, Events, $state) {
    var events = [{
      'id': 1,
      'title': 'Summer soccer match against Bryan Killigan',
      'flames': 40, //39 + 1?
      'type': 'FOOTBALL', //pegar de um ENUM?
      'date': 1463883950710,
      'dateUpdate': 3,
      'views': 132,
      'flamed': true,
      'comments': [{
        'user': {
          'name': 'Mike Moll'
        },
        'commentAt': 1,
        'comment': 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. 1'
      }, {
        'user': {
          'name': 'Daniel Felizi'
        },
        'commentAt': 2,
        'comment': 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. 2'
      }]
    }, {
      'id': 2,
      'title': 'Summer BBQ',
      'flames': 40,
      'type': 'BARBECUE', //pegar de um ENUM?
      'date': 1463883950710,
      'dateUpdate': 2,
      'views': 133,
      'flamed': true,
      'comments': [{
        'user': {
          'name': 'Augusto Marques'
        },
        'commentAt': 3,
        'comment': 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. 3'
      }, {
        'user': {
          'name': 'Helder Traci'
        },
        'commentAt': 4,
        'comment': 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. 4'
      }, {
        'user': {
          'name': 'Samuel Kitazume'
        },
        'commentAt': 5,
        'comment': 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. 5'
      }]
    }];

    events.map(function(item) {
      item.type = Events[item.type];
      item.cardType = Cards.EVENTS;
    });

    $scope.events = events;

    $scope.showDetails = function(eventId, eventType) {
      $state.go('home.leaveComment', {
        cardId: eventId,
        cardType: eventType
      });
    };
  });
