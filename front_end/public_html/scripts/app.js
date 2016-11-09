var app = angular.module('app', ['ngRoute', 'ngAnimate', 'ui.bootstrap', 'controllers', 'services']);

app.config(['$routeProvider',
    function ($routeProvider) {
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
                })
    }]);

