'use strict';

/**
 * @ngdoc function
 * @name clientApp.controller:MainCtrl
 * @description # MainCtrl Controller of the clientApp
 */
var clientApp = angular.module('clientApp');

clientApp.controller('MainCtrl', function($scope, $http, portfolioService) {
  
  // get portfolio data
  $http.get('portfolios/portfolios.json').success(function(data) {
    $scope.portfolios = data;
  });
  
  $scope.name = portfolioService.sayHello()
});



