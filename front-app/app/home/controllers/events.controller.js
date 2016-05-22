'use strict';
angular.module('main')
  .controller('EventsController', function($scope, $timeout, $http, Config, Cards, Events, $state, $ionicPopup) {
    $scope.events = [];

    $http.get(Config.ENV.SERVER_URL + 'event').then(
      function(res) {
        var data = res.data;
        var events = data;

        events.map(function(item) {
          item.type = Events[item.type];
          item.cardType = Cards.EVENTS;
        });

        $scope.events = events;
      },
      function(err) {
        $ionicPopup.alert({
          title: 'Getting events error',
          okType: 'button-calm',
          template: 'Sorry, something get wrong! :('
        });
      }
    );

    $scope.showDetails = function(eventId, eventType) {
      $state.go('home.leaveComment', {
        cardId: eventId,
        cardType: eventType
      });
    };
  });
