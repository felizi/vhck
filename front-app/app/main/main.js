'use strict';
angular.module('main', [
  'ionic',
  'ngCordova',
  'ui.router',
  // TODO: load other modules selected during generation
  ])
  .config(function($stateProvider, $urlRouterProvider) {

    // ROUTING with ui.router
    $urlRouterProvider.otherwise('/login/loginContent');
    $stateProvider
    // this state is placed in the <ion-nav-view> in the index.html
      .state('login', {
        url: '/login',
        abstract: true,
        templateUrl: 'login/templates/login.html',
        controller: 'LoginController as loginCtrl'
      })
      .state('login.loginContent', {
        url: '/loginContent',
        views: {
          'pageContent': {
            templateUrl: 'login/templates/loginContent.html',
            controller: 'LoginContentController as loginContentCtrl'
          }
        }
      })
      .state('login.chooseBuilding', {
        url: '/chooseBuilding',
        views: {
          'pageContent': {
            templateUrl: 'login/templates/chooseBuilding.html',
            controller: 'ChooseBuildingController as chooseBuildingCtrl'
          }
        }
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
      .state('home.occurrence', {
        url: '/occurrence',
        views: {
          'pageContent': {
            templateUrl: 'home/templates/occurrence.html',
            controller: 'OccurrenceController as occurrenceCtrl'
          }
        }
      })
      .state('home.events', {
        url: '/events',
        views: {
          'pageContent': {
            templateUrl: 'home/templates/events.html',
            controller: 'EventsController as eventsCtrl'
          }
        }
      })
      .state('home.leaveComment', {
        url: '/cards/leaveComment/:cardId/:cardType',
        views: {
          'pageContent': {
            templateUrl: 'home/templates/leaveComment.html',
            controller: 'LeaveCommentController as leaveCommentCtrl'
          }
        }
      })
      .state('home.user', {
        url: '/user',
        views: {
          'pageContent': {
            templateUrl: 'user/templates/user.html',
            controller: 'UserController as userCtrl'
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
