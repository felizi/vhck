'use strict';
angular.module('main')
  .controller('ChooseBuildingController', function($scope, $timeout, $http, Config, $state, UserService, $ionicPopup) {
    $scope.buildings = [];

    $http.get(Config.ENV.SERVER_URL + 'building').then(
      function(res) {
        var data = res.data;

        if (data.length > 1) {
          $scope.buildings = data;
        } else {
          UserService.setBuilding(data[0]);
        }
      },
      function(err) {
        $ionicPopup.alert({
          title: 'Getting buildings error',
          okType: 'button-calm',
          template: 'Sorry, something get wrong! :('
        });
      }
    );

    $scope.selectBuilding = function selectBuilding() {
      if ($scope.building) {
        UserService.setBuilding(+$scope.building);
        $state.go('home.cards');
        $scope.building = '';
      }
    };
  });
