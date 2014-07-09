'use strict';

describe('Service: Portfolio', function () {

  // load the service's module
  beforeEach(module('clientApp'));

  // instantiate service
  var Portfolio;
  beforeEach(inject(function (_Portfolio_) {
    Portfolio = _Portfolio_;
  }));

  it('should do something', function () {
    expect(!!Portfolio).toBe(true);
  });

});
