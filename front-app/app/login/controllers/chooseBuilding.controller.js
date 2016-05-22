'use strict';
angular.module('main')
  .controller('ChooseBuildingController', function($scope, $timeout, $http, Config, $state, UserService, $ionicPopup) {
    var buildings = [{
      id: 1,
      name: 'Building 1'
    }, {
      id: 2,
      name: 'Building 2'
    }, {
      id: 3,
      name: 'Building 3'
    }];

    if (buildings.length > 1) {
      $scope.buildings = buildings;
    } else {
      UserService.setBuilding(buildings[0]);
    }

    $scope.selectBuilding = function selectBuilding() {
      if ($scope.building) {
        UserService.setBuilding(+$scope.building);
        $state.go('home.cards');
        $scope.building = '';
      }
    };
  });
