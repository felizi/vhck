'use strict';
angular.module('main')
  .controller('HomeController', function($scope, $timeout, $http, Config, $state, UserService) {
    var logOut = function logOut() {
      UserService.logOut();
      $state.go('login.loginContent');
    };

    $scope.logOut = logOut;
  });
