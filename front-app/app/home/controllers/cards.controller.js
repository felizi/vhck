'use strict';
angular.module('main')
  .controller('CardsController', function($scope, $timeout, $http, Config, Cards, Occurrence,
    Events, $state, $ionicPopup) {
    //Sorry about that... Less time :'(
    var aOccurrence = [],
        aEvents = [],
        bOccurrence = false,
        bEvents = false;

    $scope.cards = [];

    $http.get(Config.ENV.SERVER_URL + 'occurrence').then(
      function(res) {
        var data = res.data;
        var occurrence = data;

        occurrence.map(function(item) {
          item.type = Occurrence[item.type];
          item.cardType = Cards.OCCURRENCE;
        });

        aOccurrence = occurrence;
        bOccurrence = true;
        occurrenceAndEvents();
      },
      function(err) {
        $ionicPopup.alert({
          title: 'Getting occurrences error',
          okType: 'button-calm',
          template: 'Sorry, something get wrong! :('
        });
      }
    );

    $http.get(Config.ENV.SERVER_URL + 'event').then(
      function(res) {
        var data = res.data;
        var events = data;

        events.map(function(item) {
          item.type = Events[item.type];
          item.cardType = Cards.EVENTS;
        });

        aEvents = events;
        bEvents = true;
        occurrenceAndEvents();
      },
      function(err) {
        $ionicPopup.alert({
          title: 'Getting occurrences error',
          okType: 'button-calm',
          template: 'Sorry, something get wrong! :('
        });
      }
    );

    function occurrenceAndEvents(itens) {
      if (bOccurrence && bEvents) {
        $scope.cards = aOccurrence.concat(aEvents);
      }
    }

    $scope.showDetails = function(cardId, cardType) {
      $state.go('home.leaveComment', {
        cardId: cardId,
        cardType: cardType
      });
    };
  });
