'use strict';
angular.module('main')
.controller('ListController', function ($scope, $cordovaCamera) {
	$scope.imgURI = undefined;

	$scope.takePicture = function() {
		var options = {
			destinationType: Camera.DestinationType.FILE_URI,
			sourceType: Camera.PictureSourceType.CAMERA,
		};

		console.log(Camera.DestinationType.FILE_URI);
		console.log(Camera.PictureSourceType.CAMERA);

		console.log('iniciando camera');

		$cordovaCamera.getPicture(options).then(function(imageURI) {
			console.log('success ', imageURI);
			$scope.imgURI = imageURI;
		}, function(err) {
			console.log('error ', err);
		});
	}

});
