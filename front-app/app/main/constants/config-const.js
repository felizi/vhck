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
  })
  .constant('Occurrence', {
    LOST_AND_FOUND: 'Lost and found',
    MAINTENANCE: 'Maintenance'
  })
  .constant('Events', {
    BARBECUE: 'Barbecue',
    PARTY: 'Party',
    FOOTBALL: 'Football',
    BIKE: 'Bike'
  })
  .constant('Privacy', {
    PUBLIC: 'PUBLIC',
    CLOSED: 'CLOSED',
    PRIVATE: 'PRIVATE'
  });
