var componentServices = angular.module('componentServices', ['ngResource']);



componentServices.service('Cookie', function ($cookieStore) {
  this.createUserCookie = function (token, user) {
    var userId = user.id;
    var userRole = user.role;

    var username = user.name.length>0? user.name : user.username;
    
    $cookieStore.put('isLogined', true);
    $cookieStore.put('token', token);
    $cookieStore.put('userId', userId);
    $cookieStore.put('userRole', userRole);
    $cookieStore.put('username', username);
  };
  this.destroyUserCookie = function () {
    $cookieStore.remove('isLogined');
    $cookieStore.remove('token');
    $cookieStore.remove('userId');
    $cookieStore.remove('userRole');
    $cookieStore.remove('username');
  };
  return this;
});



componentServices.service('popupService',function($window){
    this.showPopup=function(message){
        return $window.confirm(message);
    }
});


