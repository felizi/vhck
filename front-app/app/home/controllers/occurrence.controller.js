'use strict';
angular.module('main')
  .controller('OccurrenceController', function($scope, $timeout, $http, Config, Cards, Occurrence, $state) {
    var occurrences = [{
      'id': 1,
      'title': 'Blue towel at the swimming pool',
      'flames': 30,
      'type': 'LOST_AND_FOUND', //pegar de um ENUM?
      'date': 1463883950710,
      'dateUpdate': 4,
      'views': 131,
      'flamed': false,
      'comments': []
    }];

    occurrences.map(function(item) {
      item.type = Occurrence[item.type];
      item.cardType = Cards.OCCURRENCE;
    });

    $scope.occurrences = occurrences;

    $scope.showDetails = function(occurrenceId, occurrenceType) {
      $state.go('home.leaveComment', {
        cardId: occurrenceId,
        cardType: occurrenceType
      });
    };
  });
