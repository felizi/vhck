'use strict';
angular.module('main', [
  'ionic',
  'ngCordova',
  'ui.router',
  // TODO: load other modules selected during generation
])
.config(function ($stateProvider, $urlRouterProvider) {

  // ROUTING with ui.router
  $urlRouterProvider.otherwise('/login');
  $stateProvider
    // this state is placed in the <ion-nav-view> in the index.html
    .state('login', {
      url: '/login',
      templateUrl: 'login/templates/login.html',
      controller: 'LoginController as loginCtrl'
    })
    .state('home', {
      url: '/home',
      abstract: true,
      templateUrl: 'home/templates/home.html',
      controller: 'HomeController as homeCtrl'
    })
      .state('home.cards', {
        url: '/cards',
        views: {
          'pageContent': {
            templateUrl: 'home/templates/cards.html',
            controller: 'CardsController as cardsCtrl'
          }
        }
      })
      .state('home.leaveComment', {
        url: '/cards/leaveComment',
        views: {
          'pageContent': {
            templateUrl: 'home/templates/leaveComment.html',
            controller: 'LeaveCommentController as leaveCommentCtrl'
          }
        }
      })
    .state('main', {
      url: '/main',
      abstract: true,
      templateUrl: 'main/templates/menu.html',
      controller: 'MenuCtrl as menu'
    })
      .state('main.list', {
        url: '/list',
        views: {
          'pageContent': {
            templateUrl: 'main/templates/list.html',
            controller: 'ListController'
          }
        }
      })
      .state('main.listDetail', {
        url: '/list/detail',
        views: {
          'pageContent': {
            templateUrl: 'main/templates/list-detail.html',
            // controller: '<someCtrl> as ctrl'
          }
        }
      })
      .state('main.debug', {
        url: '/debug',
        views: {
          'pageContent': {
            templateUrl: 'main/templates/debug.html',
            controller: 'DebugCtrl as ctrl'
          }
        }
      });
}).config(function($stateProvider, $urlRouterProvider, $ionicConfigProvider) {
  $ionicConfigProvider.navBar.alignTitle('center');
});