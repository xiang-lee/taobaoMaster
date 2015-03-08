var componentCtrls = angular.module('componentCtrls', []);

componentCtrls.controller('ApplicationController', function ($scope,$cookieStore,loginService) {

  $scope.currentUser = null;
  $scope.isLogin = $cookieStore.get('isLogined');
  $scope.username = $cookieStore.get('username');
  $scope.isAdmin = $cookieStore.get('isAdmin');
  $scope.isFacebookUser = $cookieStore.get('isFacebookUser');
  $scope.userId = $cookieStore.get('userId');


  
 
  $scope.setCurrentUser = function (user) {
    $scope.currentUser = user;
  };

});



componentCtrls.controller('homeCtrl', ['$scope','$state','$notification','userService',
  function($scope,$state,$notification,userService) {
       
}]);



componentCtrls.controller('HeaderCtrl', ['$scope','$cookieStore','$state','$location','$stateParams',
  '$window','Cookie','userService','loginService',
    function($scope,$cookieStore,$state,$location,$stateParams,$window,Cookie,userService,loginService) {

       
        $scope.setCollapsedTrue = function () {
          $scope.isCollapsed = true;
        };
        $scope.isCollapsed = true;
        $scope.isActive = function (viewLocation) { 
            return viewLocation === $location.path();
        };


        $scope.logout = function () { 
            Cookie.destroyUserCookie();
            $window.localStorage.clear();
            $window.sessionStorage.clear();
            //logout in server side
            loginService.logout();
            $window.location.href = $state.href('home',{},{reload:true});
            $window.location.reload(true);

        };

      
  }]);


componentCtrls.controller('contactUsCtrl', function ($scope,$window,$notification,userService) {
  $scope.sendMessage = function() {
    console.log($scope.email);
    userService.contactUs($scope.email).then(function(res){
      $window.location.reload(true);
      $notification.info("Successfully Email Sent", "", "");
    });

  }
});

componentCtrls.controller('AccordionCtrl', function ($scope) {
  $scope.oneAtATime = true;
  $scope.status = {
    isFirstOpen: true,
    isFirstDisabled: false
  };
});



componentCtrls.controller('emailConfrimCtrl', function ($scope,$state,$stateParams,loginService) {
  loginService.acticateUser($stateParams.confirmationId);
});


componentCtrls.controller('resetPwdCtrl', function ($scope,$state,userService) {
  $scope.showSendSuccess = false;
  $scope.showSendError = false;
  $scope.resetPwd = function() {
    userService.resetPwd($scope.email).then(function(res){
      $scope.showSendSuccess = true;
      $scope.showSendError = false;
    },function(err){
      $scope.showSendError = true;
      $scope.showSendSuccess = false;
    });
  }
});