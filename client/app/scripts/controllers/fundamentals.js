'use strict';

/**
 * @ngdoc function
 * @name clientApp.controller:MainCtrl
 * @description # MainCtrl Controller of the clientApp
 */
var clientApp = angular.module('clientApp');

clientApp.controller('FundamentalsCtrl', function($scope, $http, portfolioService) {

  $scope.fundamentalEntries = [];
  $scope.newEntries = [];
  
  $scope.addEmptyPortfolioEntry = function() {
    $scope.newEntries.push({ instrumentName: 'VOD', direction: 'BUY', quantity: 0, price: 0 });
  };
  $scope.addEmptyPortfolioEntry();
  
  portfolioService.findPortfolios().success(function(data) {
    $scope.portfolios = data;
    $scope.activePortfolio = $scope.portfolios[0]
    $scope.onPortfolioChanged()
  });
  
  portfolioService.findInstruments().success(function(data) {
    $scope.instruments = data;
  });
  
  $scope.onPortfolioChanged = function() {
    portfolioService.findPortfolioFundamentals($scope.activePortfolio.id).success(function(data) {
      $scope.fundamentals = data;
      $scope.fundamentalEntries = [];
    });
  };
  
  $scope.onClickFundamentalRow = function($rowItem) {
    var f = $scope.fundamentals[$rowItem.rowIndex]
    portfolioService.findPortfolioEntries($scope.activePortfolio.id, f.instrumentId).success(function(data) {
      $scope.fundamentalEntries = data;
    });
  };

  $scope.fundamentalsGridOptions = {
          data: 'fundamentals',
          multiSelect: false,
          columnDefs: [
            { field: 'instrumentName', displayName: 'Instrument' },
            { field: 'currentPrice', displayName: 'Current Price' },
            { field: 'totalSharesHeld', displayName: 'Quantity Held' },
            { field: 'totalCost', displayName: 'Purchase Cost' },
            { field: 'marketCost', displayName: 'Market Value' }
          ],
          rowTemplate: '<div ng-click="onClickFundamentalRow(row)" ng-style="{ \’cursor\’: row.cursor }" ng-repeat="col in renderedColumns" ng-class="col.colIndex()" class="ngCell {{col.cellClass}}"><div class="ngVerticalBar" ng-style="{height: rowHeight}" ng-class="{ ngVerticalBarVisible: !$last }">&nbsp;</div><div ng-cell></div></div>'
  };
  
  $scope.entriesGridOptions = {
          data: 'fundamentalEntries',
          columnDefs: [
            { field: 'quantity', displayName: 'Quantity' },
            { field: 'price', displayName: 'Price' },
            { field: 'direction', displayName: 'Direction' }
          ]
  };
});
