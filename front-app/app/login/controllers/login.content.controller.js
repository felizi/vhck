'use strict';
angular.module('main')
  .controller('LoginContentController', function($scope, $timeout, $http, Config, $state, UserService, $ionicPopup) {
    $scope.user = {
      username: '',
      password: ''
    };

    var authUser = function authUser() {
      if ($scope.user.username && $scope.user.password) {
        $http.post(Config.ENV.SERVER_URL + 'auth/login', $scope.user).then(
          function(data) {
            UserService.setUserData(data);
            $state.go('login.chooseBuilding');

            $scope.user = {
              username: '',
              password: ''
            };
          },
          function(err) {
            $ionicPopup.alert({
              title: 'Login error',
              okType: 'button-calm',
              template: 'Username or password incorrect.'
            });
          }
        );
      }
    };

    $scope.authUser = authUser;
  });
