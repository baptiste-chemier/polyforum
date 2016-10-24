'use strict'

/* 
 * Déclaration du module controllers qui rassemblera tous les contrôleurs
 */

var controllers = angular.module('controllers', []);

controllers.controller('MainCtrl', ['$rootScope', '$location',
    function ($rootScope, $location) {
        var mainCtrl = this;

        // On référence les méthodes exposées
        mainCtrl.disConnect = disConnect;

        // Par defaut on n'est pas authentifié
        $rootScope.isConnected = false;
        $rootScope.title = "Test";

        /* 
         * Déconnexion : isConnected passe à faux => le menu disparaîtra
         * On recharge la page principale
         */
        function disConnect() {
            $rootScope.isConnected = false;
            $location.path('/home');
        }
    }]);

controllers.controller('Apropos', ['$rootScope', '$location',
    function ($rootScope, $location) {
        var apropos = this;

        $rootScope.title = "A propos";
    }]);

controllers.controller('UsersCtrl', ['UsersRest',
    function (UsersRest) {
        var usersCtrl = this;

        //Récupère une promise
        var usersPromise = UsersRest.getUsers();

        /* Si la requête aboutit (code 200) on affecte le jSon retourné
         * à la variable employeesCtrl.employees qui sera affichée
         * par la vue employees.html
         */
        usersPromise.success(function (data) {
            if (data.length > 0) { //si la liste n'est pas vide
                usersCtrl.users = data;
            }
        }).error(function (data) { //Si la requête a provoqué une erreur (code 404)
            usersCtrl.error = data //On affiche l'erreur brute     
            alert(usersCtrl.error);
        })
    }]);