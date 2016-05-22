'use strict';
angular.module('main')
.constant('Config', {

  // gulp environment: injects environment vars
  ENV: {
    /*inject-env*/
    'SERVER_URL': 'http://192.168.25.118:8080/neighbors/rest/'
    /*endinject*/
  },

  // gulp build-vars: injects build vars
  BUILD: {
    /*inject-build*/
    /*endinject*/
  }

})
.constant('Cards', {
  OCCURRENCE: 'OCCURRENCE',
  EVENTS: 'EVENTS'
});
