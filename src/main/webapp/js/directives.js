var tmDirectives = angular.module('tmDirectives', []);

tmDirectives.directive('sddDirective_1', ['$scope',
    function($scope) {}
]);

tmDirectives.directive('sddDirective_2', ['$scope',
    function($scope) {}
]);



// Repeat Password match
tmDirectives.directive('match', function($parse) {
  return {
    require: 'ngModel',
    link: function(scope, elem, attrs, ctrl) {
      scope.$watch(function() {        
        return $parse(attrs.match)(scope) === ctrl.$modelValue;
      }, function(currentValue) {
        ctrl.$setValidity('mismatch', currentValue);
      });
    }
  };
});

