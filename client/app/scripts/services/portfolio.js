'use strict';

/**
 * @ngdoc service
 * @name clientApp.Portfolio
 * @description
 * # Portfolio
 * Service in the clientApp.
 */
var clientApp = angular.module('clientApp');

clientApp.service('portfolioService', function($http, $resource) {
  this.findPortfolios = function() {
    return $http.get('portfolios/portfolios.json');
  }
  
  this.findPortfolioFundamentals = function($portfolioId) {
    return $http.get('portfolios/fundamentals-' + $portfolioId + '.json');
  }
  
  this.findPortfolioEntries = function($portfolioId, $instrumentId) {
    return $http.get('portfolios/entries-' + $portfolioId + '-' + $instrumentId + '.json');
  }
  
  this.findInstruments = function() {
    return $http.get('portfolios/instruments.json');
  }
});
