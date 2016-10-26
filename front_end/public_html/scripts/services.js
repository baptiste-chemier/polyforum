'use script';

var services = angular.module('services', []);

/*
 * Définition des urls 
 */
services.factory('Config', [function () {
        return {
            urlServer: 'http://localhost:8080/Polyforum',
            urlGetUsers: '/utilisateur/lister'
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
            var url = Config.urlServer + Config.urlGetUsers;

            return $http.get(url);
        }
    }]);