'use strict';

/**
 * @ngdoc function
 * @name clientApp.controller:InstrumentlookupCtrl
 * @description # InstrumentlookupCtrl Controller of the clientApp
 */
var clientApp = angular.module('clientApp');

clientApp.controller('InstrumentlookupCtrl', function($scope, $http) {

  $scope.selected = undefined;
  
  $scope.searchInstruments = function(val) {
    return $http.get('http://localhost:8080/service/instrument/search/', {
      params: {
        text: val
      }
    }).then(function(res){
      // success
      return $scope.handleSearchInstrumentResult(res);
      
    }, function(res) {
      // error
      return $scope.handleSearchInstrumentResult(res);
      
    });
  };
  
  $scope.handleSearchInstrumentResult = function(res) {
    $scope.data = res.data;
    $scope.status = res.status;
    $scope.headers = res.headers;
    $scope.config = res.config;
    return res.data;
  };
});
