var app = angular.module('app', [
    'AuthServices',
    'ngRoute', 
    'ngAnimate', 
    'ui.bootstrap', 
    'controllers', 
    'services', 
    'ui.router']);

app.config(['$stateProvider', '$routeProvider', '$httpProvider', '$locationProvider',
    function ($stateProvider, $routeProvider, $httpProvider, $locationProvider) {
        
        $stateProvider
                .state("Main", {
                    url: "/"
                })
                .state("login", {
                    url: "/login",
                    onEnter: function (UserService) {
                        UserService.setLoginState(true);
                    },
                    onExit: function (UserService) {
                        UserService.setLoginState(false);
                    },
                    views: {
                        "login": {
                            templateUrl: "partials/login.html",
                            controller: "LoginCtrl as loginCtrl"
                        }
                    }
                });
                
        $routeProvider
                // a Propos
                .when('/apropos', {
                    templateUrl: 'partials/apropos.html',
                    controller: 'Apropos as apropos'
                })
                //Users
                .when('/users', {
                    templateUrl: 'partials/users.html',
                    controller: 'UsersCtrl as usersCtrl'
                }) 
                .when('/updateUser/:id', {
                    templateUrl: 'partials/user.html',
                    controller: 'UserCtrl as userCtrl'
                }) 
                .when('/addUser', {
                    templateUrl: 'partials/user.html',
                    controller: 'UserCtrl as userCtrl'
                }) 
                //Salles
                .when('/salles', {
                    templateUrl: 'partials/salles.html',
                    controller: 'SallesCtrl as sallesCtrl'
                });
        
        $httpProvider.interceptors.push(function ($q, $location, httpBufferService) {

            return {
                "responseError": function (response) {
                    var deferred = $q.defer();

                    if (response.status === 401) {

                        $location.path("/login");

                        httpBufferService.storeRequest({
                            config: response.config,
                            deferred: deferred
                        });
                    }
                    return deferred.promise;
                }
            };
        });

    }]);

