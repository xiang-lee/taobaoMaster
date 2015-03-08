var userServices = angular.module('userServices', ['ngResource',]);


userServices.factory('loginService',function($window, $http,$rootScope,Cookie) {
  var loginService = {};


  loginService.login = function(loginData) {
    return $http.post('/login', {
      username: loginData.username,
      password: loginData.password,
      base64Auth: "c2RkOnNkZF9zZWNyZXQ="
    }).then(function(obj, status) {
      var token = obj.data.token;
      var user = obj.data.user;
      Cookie.createUserCookie(token, user);
      return obj;
    }, function(error, status) {
      console.log("Incorrect login");
      throw error;
    });
  };

    
  loginService.logout = function() {
      return $http.post('/logout').then(function(obj, status) {
        return obj;
      }, function(error, status) {
        console.log("Incorrect logout");
        throw error;
      });
    };  

  return loginService;
  
});



userServices.factory('userService',function($window, $http,$rootScope) {
  return {

     //Contact us
     getStockpiles: function() {
      return $http.get('/order/stockpile').then(function(obj, status) {
            return obj.data;
        });
     },

     deleteBuying : function(orderId) {
        return $http.delete('/order/buying/'+orderId+'').then(function(obj, status) {
          return obj;
        }, function(error, status) {
          throw error;
        });
     },

      agreeOffer: function(offerId) {
            return $http.post('/user/offer/'+offerId+'/agreeOffer')
            .then(function(obj, status) {
                return obj;
              }, function(error, status) {
                console.log(error);
              throw error;
            });
      }
  
  }; 
});
