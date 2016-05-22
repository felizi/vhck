'use strict';
angular.module('main')
  .controller('LoginContentController', function($scope, $timeout, $http, Config, $state, UserService, $ionicPopup) {
    $scope.user = {
      email: '',
      password: ''
    };

    var authUser = function authUser() {
      if ($scope.user.email && $scope.user.password) {
        $http.post(Config.ENV.SERVER_URL + 'auth/login', $scope.user).then(
          function(res) {
            var data = res.data;

            UserService.setUserData(data);
            $state.go('login.chooseBuilding');

            $scope.user = {
              email: '',
              password: ''
            };
          },
          function(err) {
            $ionicPopup.alert({
              title: 'Login error',
              okType: 'button-calm',
              template: 'Email or password incorrect.'
            });
          }
        );
      }
    };

    $scope.authUser = authUser;
  });
