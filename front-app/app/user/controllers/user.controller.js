'use strict';

angular.module('main')
  .controller('UserController', function($scope, $timeout, $http, Config, $state, Occurrence,
    Events, UserService, $ionicPopup) {
    $scope.reputations = [];

    $http.get(Config.ENV.SERVER_URL + 'reputation').then(
      function(res) {
        var data = res.data;

        var reputations = data;

        reputations.map(function(item) {
          item.type = Occurrence[item.type] ? Occurrence[item.type] : item.type;
        });

        reputations.map(function(item) {
          item.type = Events[item.type] ? Events[item.type] : item.type;
        });

        $scope.reputations = reputations;
      },
      function(err) {
        $ionicPopup.alert({
          title: 'Getting buildings error',
          okType: 'button-calm',
          template: 'Sorry, something get wrong! :('
        });
      }
    );

    $scope.name = UserService.getName();
  });
