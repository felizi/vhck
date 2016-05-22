'use strict';

angular.module('main')
  .controller('UserController', function($scope, $timeout, $http, Config, $state, Occurrence,
    Events, UserService) {
    var reputations = [{
      'type': 'LOST_AND_FOUND',
      'attributes': {
        'interactions': 230,
        'pokes': 15,
        'pontuation': 340
      }
    }, {
      'type': 'BARBECUE',
      'attributes': {
        'interactions': 180,
        'pokes': 22,
        'pontuation': 330
      }
    }];

    reputations.map(function(item) {
      item.type = Occurrence[item.type] ? Occurrence[item.type] : item.type;
    });

    reputations.map(function(item) {
      item.type = Events[item.type] ? Events[item.type] : item.type;
    });

    $scope.reputations = reputations;
    $scope.name = UserService.getName();
  });
