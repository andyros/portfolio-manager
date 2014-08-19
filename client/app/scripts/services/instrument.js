'use strict';

/**
 * @ngdoc service
 * @name clientApp.instrument
 * @description
 * # instrument
 * Service in the clientApp.
 */
var clientApp = angular.module('clientApp'); 

clientApp.service('Instrument', function Instrument($http) {
  
  this.findInstrument = function(val) {
    return $http.get('portfolios/instruments.json');
  }
  
});
