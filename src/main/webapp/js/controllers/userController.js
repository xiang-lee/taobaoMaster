var userCtrls = angular.module('userCtrls', []);



userCtrls.controller('loginCtrl', ['$scope','$window','$rootScope', '$state','$resource',
  'loginService',
    function($scope,$window,$rootScope,$state,$resource,loginService){
      $scope.loginData = {};
      $scope.showLoginError= false;
      $scope.login = function () {
        return loginService.login($scope.loginData).then(function(res) {
           // $state.go('home');
           // $window.location.reload(true);
           $window.location.href = $state.href('home',{},{reload:true});
        }, function(err) {
          $scope.showLoginError = true;
          return console.log("There was an error " + err);
        });

      };

}]);


userCtrls.controller('statisticCtrl', function ($scope,$state,$notification,userService) {
   
});

userCtrls.controller('stockpilesCtrl', function ($scope,$state,$notification,userService,popupService) {
   userService.getStockpiles().then(function(res) {
      $scope.orders = res;
   });

   $scope.delete = function(orderId) {
    if(popupService.showPopup('少女，你确定删除这条记录?')){
        console.log(orderId);
        // userService.deleteBuying(orderId);
    };
    
   }
});

userCtrls.controller('brushesCtrl', function ($scope,$state,$notification,userService) {
   
});

userCtrls.controller('soldCtrl', function ($scope,$state,$notification,userService) {
   
});

userCtrls.controller('soldtofriendCtrl', function ($scope,$state,$notification,userService) {
   
});

userCtrls.controller('additionsCtrl', function ($scope,$state,$notification,userService) {
   
});
