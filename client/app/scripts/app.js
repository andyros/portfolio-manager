'use strict';

/**
 * @ngdoc overview
 * @name clientApp
 * @description
 * # clientApp
 *
 * Main module of the application.
 */
var clientApp = angular.module('clientApp', [
    'ngAnimate',
    'ngCookies',
    'ngResource',
    'ngRoute',
    'ngSanitize',
    'ngTouch',
    'ngGrid',
    'ui.bootstrap'
  ]);

clientApp.config(function ($routeProvider) {
    $routeProvider
      .when('/', {
        templateUrl: 'views/fundamentals.html',
        controller: 'FundamentalsCtrl'
      })
      .when('/about', {
        templateUrl: 'views/about.html',
        controller: 'AboutCtrl'
      })
      .when('/instruments', {
        templateUrl: 'views/instruments.html',
        controller: 'InstrumentlookupCtrl'
      })
      .otherwise({
        redirectTo: '/'
      });
  });
