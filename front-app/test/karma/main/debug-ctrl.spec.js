'use strict';

describe('module: main, controller: DebugCtrl', function () {

  // load the controller's module
  beforeEach(module('main'));
  // load all the templates to prevent unexpected $http requests from ui-router
  beforeEach(module('ngHtml2Js'));

  // instantiate controller
  var DebugCtrl;
  beforeEach(inject(function ($controller) {
    DebugCtrl = $controller('DebugCtrl');
  }));

  describe('.grade()', function () {

    it('should classify asd as weak', function () {
      DebugCtrl.password.input = 'asd';
      DebugCtrl.grade();
      expect(DebugCtrl.password.strength).toEqual('weak');
    });

    it('should classify asdf as medium', function () {
      DebugCtrl.password.input = 'asdf';
      DebugCtrl.grade();
      expect(DebugCtrl.password.strength).toEqual('medium');
    });

    it('should classify asdfasdfasdf as strong', function () {
      DebugCtrl.password.input = 'asdfasdfasdf';
      DebugCtrl.grade();
      expect(DebugCtrl.password.strength).toEqual('strong');
    });
  });

});
