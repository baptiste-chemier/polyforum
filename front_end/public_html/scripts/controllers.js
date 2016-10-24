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