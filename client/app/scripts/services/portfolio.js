'use strict';

/**
 * @ngdoc service
 * @name clientApp.Portfolio
 * @description
 * # Portfolio
 * Service in the clientApp.
 */
var clientApp = angular.module('clientApp');

clientApp.service('portfolioService', function($resource) {
  this.sayHello = function() {
    return $resource('/user/:username');
  }
});
