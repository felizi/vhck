'use strict';
angular.module('main')
  .controller('LoginController', function($scope, $timeout, $http, Config, $state, UserService, $ionicPopup) {
    $scope.user = {
      username: '',
      password: ''
    };

    var authUser = function authUser() {
      if ($scope.user.username && $scope.user.password) {

        UserService.setUserData({
          id: 4432,
          name: 'Samuel Kitazume',
          email: 'samuel.kitazume@gmail.com'
        });

        //$state.go('home.cards');

        $http.post(Config.ENV.SERVER_URL + 'auth/login', $scope.user).then(
          function(data) {
            console.log('Login success!', data);
          },
          function(err) {
            $ionicPopup.alert({
              title: 'Don\'t eat that!',
              template: 'It might taste good'
            });
            console.log('Error: ', err);
          }
        );
      }
    };

    $scope.authUser = authUser;
  });
