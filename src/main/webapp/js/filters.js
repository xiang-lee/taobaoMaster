var daFilters = angular.module('daFilters', []);

daFilters.filter('filter_1', ['$scope',
    function($scope) {}
]);

daFilters.filter('filter_2', ['$scope',
    function($scope) {}
]);

daFilters.filter('range', function() {
  return function(input, total) {
    total = parseInt(total);
    for (var i=0; i<total; i++)
      input.push(i);
    return input;
  };
});