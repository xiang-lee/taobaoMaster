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
           $window.location.href = $state.href('statistic',{},{reload:true});
           $window.location.reload(true);
        }, function(err) {
          $scope.showLoginError = true;
          return console.log("There was an error " + err);
        });

      };

}]);


userCtrls.controller('statisticCtrl', function ($scope,$state,notify,userService) {
   userService.getStatistic().then(function(res){
      $scope.statistic = res;
   });
});

userCtrls.controller('buyingCtrl', function ($scope,$state,userService,
  popupService,notify) {

  $scope.open = function($event) {
    $event.preventDefault();
    $event.stopPropagation();
    $scope.opened = true;
  };

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

   
   //initialize orders
   $scope.initializeOrders();
});





userCtrls.controller('sellingCtrl', function ($scope,$state,notify,
  userService,popupService) {

  $scope.open = function($event) {
    $event.preventDefault();
    $event.stopPropagation();
    $scope.opened = true;
  };

   var currentStateName = $state.current.name;
  //open foo table plugin
  $('.footable').footable();
  $scope.newOrder = {};
   $scope.initializeOrders = function() {
    //if current state is stockpile, invoke getStockpiles
    if(currentStateName === 'brushes') {
      userService.getBrushes().then(function(res) {
        $scope.orders = res;
      });
    }
    //if current state is additions, invoke getAdditions
    else if(currentStateName === 'sold') {
      userService.getSold().then(function(res) {
        $scope.orders = res;
      });
      //get stockpiles in drop down
      userService.getStockpilesWithRemain().then(function(res) {
        $scope.stockpiles = res;
      });
    }
    else if(currentStateName === 'soldtofriend') {
      userService.getSoldtofriend().then(function(res) {
        $scope.orders = res;
      });
      //get stockpiles in drop down
      userService.getStockpilesWithRemain().then(function(res) {
        $scope.stockpiles = res;
      });
    }
    $scope.newOrder.currency = 'euro';
   };

   $scope.addSelling = function() {
      var order = $scope.newOrder;
      //set is_stockpile based on current state name
      if(currentStateName === 'brushes') {
        order.brush = true;
      }
      else if(currentStateName === 'sold') {
        order.brush = false;
        order.soldToFriend = false;
      }
      else if(currentStateName === 'soldtofriend') {
        order.soldToFriend = true;
      }
      order.quantity = parseInt(order.quantity,10);
      order.unitPrice = parseFloat(order.unitPrice).toFixed(2);
      order.exchangeRate = parseFloat(order.exchangeRate).toFixed(2);
      userService.addSelling(order).then(function(res){
        notify('添加成功');
        $scope.initializeOrders();
        $scope.newOrder={};
      });
   };

   $scope.delete = function(orderId) {
    if(popupService.showPopup('少女，你确定删除这条记录?')){
      userService.deleteSelling(orderId).then(function(res){
        notify('删除成功');
        $scope.initializeOrders();
      });
    }
   };

   $scope.updateSelling = function(order) {
      order.quantity = parseInt(order.quantity,10);
      order.unitPrice = parseFloat(order.unitPrice).toFixed(2);
      order.exchangeRate = parseFloat(order.exchangeRate).toFixed(2);
      userService.updateSelling(order).then(function(res){
        notify('更新成功');
        $scope.initializeOrders();
      },function(error){
        notify('少女，更新失败，检查日期的格式是否正确？');
      });
   };
   //initialize orders
   $scope.initializeOrders();


});


