'use strict';

describe('Controller: InstrumentlookupCtrl', function () {

  // load the controller's module
  beforeEach(module('clientApp'));

  var InstrumentlookupCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    InstrumentlookupCtrl = $controller('InstrumentlookupCtrl', {
      $scope: scope
    });
  }));

  it('should attach a list of awesomeThings to the scope', function () {
    expect(scope.awesomeThings.length).toBe(3);
  });
});
