'use script';

var services = angular.module('services', []);

/*
 * Définition des urls 
 */
services.factory('Config', [function () {
        return {
            urlServer: 'http://localhost:8080/Polyforum',
            urlUtilisateur: '/utilisateur',
            urlSalle: '/salles',
            urlGetteur: '/lister'
        };
    }]);

/*
 * Gestion de l'accès aux données, utilise le
 * service Config qui contient les urls du serveur RestFul 
 * Cahque méthode exposée retourne une promise qui 
 * sera exploitée dans les contrôleurs
 */
services.factory('UsersRest', ['$http', 'Config',
    function ($http, Config) {
        //Liste des méthodes exposées
        var userRest = {
            getUsers: getUsers
        };

        return userRest;

        function getUsers() {
            var url = Config.urlServer + Config.urlUtilisateur + Config.urlGetteur;

            return $http.get(url);
        }
    }]);

services.factory('SallesRest', ['$http', 'Config',
    function ($http, Config) {
        //Liste des méthodes exposées
        var sallesRest = {
            getSalles: getSalles
        };

        return sallesRest;

        function getSalles() {
            var url = Config.urlServer + Config.urlSalle + Config.urlGetteur;

            return $http.get(url);
        }
    }]);