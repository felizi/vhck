'use strict';
angular.module('main')
  .controller('HomeController', function($scope, $timeout, $http, Config, $state, UserService) {
    var logOut = function logOut() {
      UserService.logOut();
      $state.transitionTo('login');
    };

    $scope.logOut = logOut;
  });
