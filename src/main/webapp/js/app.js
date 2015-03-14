var tmApp = angular.module('tmApp', [
    'ui.bootstrap',
    'ui.router',
    'ngResource',
    'componentCtrls',
    'userCtrls',
    'daFilters',
    'componentServices',
    'userServices',
    'tmDirectives', 
    'ngCookies',
    'cgNotify'
]);




tmApp.config(function($stateProvider,$urlRouterProvider,$httpProvider,$provide){

    $urlRouterProvider.otherwise("/login");
    //Public
    $stateProvider
    .state('login',{
        url:'/login',
        templateUrl:'tpls/login.html',
        controller:'loginCtrl'
    })
    .state('home',{
        url:'/home',
        templateUrl:'tpls/user/home.html',
        controller:'homeCtrl'
    })
    .state('statistic',{
            url:'/statistic',
            templateUrl:'tpls/user/statistic.html',
            controller:'statisticCtrl'
        })
    .state('stockpiles',{
            url:'/stockpiles',
            templateUrl:'tpls/user/stockpiles.html',
            controller:'buyingCtrl'
        })
    .state('additions',{
            url:'/additions',
            templateUrl:'tpls/user/additions.html',
            controller:'buyingCtrl'
        })
    .state('brushes',{
            url:'/brushes',
            templateUrl:'tpls/user/brushes.html',
            controller:'brushesCtrl'
        })
    .state('sold',{
            url:'/sold',
            templateUrl:'tpls/user/sold.html',
            controller:'soldCtrl'
        })
    .state('soldtofriend',{
            url:'/soldtofriend',
            templateUrl:'tpls/user/soldtofriend.html',
            controller:'soldtofriendCtrl'
        })
    
    ;




    $provide.factory('testIntercepter', ['$q', '$injector', '$templateCache','$location','$cookieStore','Cookie',
            function($q, $injector, $templateCache,$location,$cookieStore,Cookie) {
              return {
                'request': function(config) {
                  if (config.url.indexOf('tpls/user/') != 0 && config.url.indexOf('tpls/admin/') != 0) {
                    // console.log('ignoring ' + config.url);
                    return config;
                  }

                  if (!$cookieStore.get('isLogined')) {
                    $location.path('/login');
                  }
                  return config;
                },
                'responseError': function(response) {
                    if(response.status === 401) {
                        // alert("Please Login first");
                        // $location.path('/signin');
                        console.log("401 - Unauthorized");
                        Cookie.destroyUserCookie();
                        $location.path('/login');
                    }
                    return $q.reject(response);
                }
              }
            }
    ]);
    $httpProvider.interceptors.push('testIntercepter');

}).run(function($state){
   $state.go('login');
});


tmApp.run(function($http,$state,$rootScope,$cookieStore,loginService) {
  var access_token = $cookieStore.get('token');
  $http.defaults.headers.common['Authorization'] = 'Bearer ' + access_token;
  
  $rootScope.$on('$stateChangeStart', function (event, toState, toParams, fromState, fromParams) {
      var stateName = toState.name;
      //user
      // if(stateName=="post-ad") {
      //   if(!$cookieStore.get('isLogined')) {
      //     event.preventDefault();
      //     alert("Please Login first!")
      //     $state.go("signin");
      //   }
      // }

      //admin
      // if(stateName.indexOf("adminpanel") > -1) {
      //   if(!$cookieStore.get('isAdmin')) {
      //     event.preventDefault();
      //     $state.go("adminlogin");
      //   }
      // }


  });
});
