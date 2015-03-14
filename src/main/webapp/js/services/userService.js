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

     getStockpiles: function() {
      return $http.get('/order/stockpile').then(function(obj, status) {
            return obj.data;
        });
     },

     getAdditions: function() {
      return $http.get('/order/additions').then(function(obj, status) {
            return obj.data;
        });
     },

     getBrushes: function() {
      return $http.get('/order/brushes').then(function(obj, status) {
            return obj.data;
        });
     },

     getSold: function() {
      return $http.get('/order/solds').then(function(obj, status) {
            return obj.data;
        });
     },

     getSoldtofriend: function() {
      return $http.get('/order/soldsToFriend').then(function(obj, status) {
            return obj.data;
        });
     },

     getStockpilesWithRemain: function() {
      return $http.get('/order/stockpileWithRemain').then(function(obj, status) {
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
     deleteSelling : function(orderId) {
        return $http.delete('/order/selling/'+orderId+'').then(function(obj, status) {
          return obj;
        }, function(error, status) {
          throw error;
        });
     },


     

     updateBuying: function(order) {
      return $http.put('/order/buying',order).then(function(obj, status) {
            return obj.data;
        });
     },

     updateSelling: function(order) {
      return $http.put('/order/selling',order).then(function(obj, status) {
            return obj.data;
        });
     },



     addBuying: function(order) {
      return $http.post('/order/buying',order).then(function(obj, status) {
            return obj.data;
        });
     },

     addSelling: function(order) {
      return $http.post('/order/selling',order).then(function(obj, status) {
            return obj.data;
        });
     }
     
  
  }; 
});
