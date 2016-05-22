'use strict';
angular.module('main')
.service('UserService', function () {
  
  this.userData = {};

  this.setUserData = function setUserData(userData) {
  	this.userData = userData;
  };

  this.getId = function getId() {
  	return this.userData.id;
  };

  this.getName = function getName() {
  	return this.userData.name;
  };

  this.getEmail = function getEmail() {
  	return this.userData.email;
  };

  this.logOut = function logOut() {
  	this.userData = {};
  };
});
