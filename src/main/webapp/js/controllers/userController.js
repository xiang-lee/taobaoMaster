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
           $window.location.reload(true);
        }, function(err) {
          $scope.showLoginError = true;
          return console.log("There was an error " + err);
        });

      };

}]);


userCtrls.controller('statisticCtrl', function ($scope,$state,notify,userService) {
   
});

userCtrls.controller('buyingCtrl', function ($scope,$state,userService,
  popupService,notify) {

  var currentStateName = $state.current.name;
  //open foo table plugin
  $('.footable').footable();
  $scope.newOrder = {};
   $scope.initializeOrders = function() {
    //if current state is stockpile, invoke getStockpiles
    if(currentStateName === 'stockpiles') {
      userService.getStockpiles().then(function(res) {
        $scope.orders = res;
      });
    }
    //if current state is additions, invoke getAdditions
    else if(currentStateName === 'additions') {
      userService.getAdditions().then(function(res) {
        $scope.orders = res;
      });
    }
   
    $scope.newOrder.currency = 'euro';
   }
   

   $scope.delete = function(orderId) {
    if(popupService.showPopup('少女，你确定删除这条记录?')){
      userService.deleteBuying(orderId).then(function(res){
        notify('删除成功');
        $scope.initializeOrders();
      });
    }
   };

   $scope.updateBuying = function(order) {
      order.quantity = parseInt(order.quantity,10);
      order.unitPrice = parseFloat(order.unitPrice).toFixed(2);
      order.exchangeRate = parseFloat(order.exchangeRate).toFixed(2);
      order.remain = parseInt(order.remain,10);
      userService.updateBuying(order).then(function(res){
        notify('更新成功');
        $scope.initializeOrders();
      });
   };

   $scope.addBuying = function() {
      var order = $scope.newOrder;
      //set is_stockpile based on current state name
      if(currentStateName === 'stockpiles') {
        order.stockpile = true;
      }
      else if(currentStateName === 'additions') {
        order.stockpile = false;
      }
      
      order.quantity = parseInt(order.quantity,10);
      order.unitPrice = parseFloat(order.unitPrice).toFixed(2);
      order.exchangeRate = parseFloat(order.exchangeRate).toFixed(2);
      order.remain = parseInt(order.remain,10);
      userService.addBuying(order).then(function(res){
        notify('添加成功');
        $scope.initializeOrders();
        $scope.newOrder={};
      });
   };

   $scope.initializeOrders();
});



userCtrls.controller('brushesCtrl', function ($scope,$state,notify,userService) {
   
});

userCtrls.controller('soldCtrl', function ($scope,$state,notify,userService) {
   
});

userCtrls.controller('soldtofriendCtrl', function ($scope,$state,notify,userService) {
   
});

userCtrls.controller('additionsCtrl', function ($scope,$state,notify,userService) {
   
});
