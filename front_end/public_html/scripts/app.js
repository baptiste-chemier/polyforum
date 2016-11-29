var app = angular.module('app', [
    'AuthServices',
    'ngRoute', 
    'ngAnimate', 
    'ui.bootstrap', 
    'controllers',
    'directives',
    'services']);

app.config(['$routeProvider', '$httpProvider', '$locationProvider',
    function ($routeProvider, $httpProvider, $locationProvider) {
        
                
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
                .when('/addSalle', {
                    templateUrl: 'partials/salle.html',
                    controller: 'SalleCtrl as salleCtrl'
                })
                .when('/updateSalle/:id', {
                    templateUrl: 'partials/salle.html',
                    controller: 'SalleCtrl as salleCtrl'
                })
                //Login
                .when('/login', {
                    templateUrl: 'partials/login.html',
                    controller: 'LoginCtrl as loginCtrl'
                })
                //Accueil
                .when('/accueil', {
                    templateUrl: 'partials/accueil.html'
                })
                  .when('/planning', {
                    templateUrl: 'partials/planning.html',
                    controller: 'PlanningCtrl as planningCtrl'
                })
                .when('/monCompte/:id', {
                    templateUrl: 'partials/monCompte.html',
                    controller: 'MonCompteCtrl as monCompteCtrl'
                })
                //Mes Choix 
                .when('/meschoix', {
                    templateUrl: 'partials/mesChoix.html',
                    controller: 'ChoiceCtrl as choiceCtrl'
                })
                .when('/config/:id', {
                    templateUrl: 'partials/config.html',
                    controller: 'ConfigCtrl as configCtrl'
                })
                .when('/meschoixEntreprise', {
                    templateUrl: 'partials/mesChoixEntreprise.html',
                    controller: 'CompanyChoiceCtrl as companyChoiceCtrl'
                })
                .otherwise({
                    templateUrl: 'partials/login.html',
                    controller: 'LoginCtrl as loginCtrl'
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

