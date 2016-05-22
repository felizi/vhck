'use strict';
angular.module('main')
  .controller('OccurrenceController', function($scope, $timeout, $http, Config, Cards, Occurrence, $state, $ionicPopup) {
    $scope.occurrences = [];

    $http.get(Config.ENV.SERVER_URL + 'occurrence').then(
      function(res) {
        var data = res.data;
        var occurrences = data;

        occurrences.map(function(item) {
          item.type = Occurrence[item.type];
          item.cardType = Cards.OCCURRENCE;
        });

        $scope.occurrences = occurrences;
      },
      function(err) {
        $ionicPopup.alert({
          title: 'Getting occurrences error',
          okType: 'button-calm',
          template: 'Sorry, something get wrong! :('
        });
      }
    );

    $scope.showDetails = function(occurrenceId, occurrenceType) {
      $state.go('home.leaveComment', {
        cardId: occurrenceId,
        cardType: occurrenceType
      });
    };
  });
