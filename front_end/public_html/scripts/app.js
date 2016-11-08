var app = angular.module('app', ['ngRoute', 'controllers', 'services']);

app.config(['$routeProvider',
    function ($routeProvider) {
        $routeProvider
                .when('/apropos', {
                    templateUrl: 'partials/apropos.html',
                    controller: 'Apropos as apropos'
                })
                .when('/users', {
                    templateUrl: 'partials/users.html',
                    controller: 'UsersCtrl as usersCtrl'
                }) 
                .when('/salles', {
                    templateUrl: 'partials/salles.html',
                    controller: 'SallesCtrl as sallesCtrl'
                })
    }]);

