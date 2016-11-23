'use script';

var services = angular.module('services', []);

/*
 * DÃ©finition des urls 
 */
services.factory('Config', [function () {
        return {
            urlServer: 'http://localhost:8080/Polyforum',
            urlUtilisateur: '/utilisateur',
            urlGetteurUser: '/lister',
            urlUpdateUser: '/modifier',
            urlAddUser: '/ajouter',
            urlLogUser: '/connecter',
            urlSalle: '/salles',
            urlProfil: '/profil', 
            urlGetteurProfil: '/recupererLibelle'
            
        };
    }]);

/*
 * Gestion de l'accÃ¨s aux donnÃ©es, utilise le
 * service Config qui contient les urls du serveur RestFul 
 * Cahque mÃ©thode exposÃ©e retourne une promise qui 
 * sera exploitÃ©e dans les contrÃ´leurs
 */
services.factory('UsersRest', ['$http', 'Config',
    function ($http, Config) {
        //Liste des mÃ©thodes exposÃ©es
        var userRest = {
            getUsers: getUsers,
            getUser: getUser, 
            updateUser: updateUser, 
            addUser: addUser
        };

        return userRest;

        function getUsers() {
            var url = Config.urlServer + Config.urlUtilisateur + Config.urlGetteurUser;

            return $http.get(url);
        }
        
        function getUser(id) {
            var url = Config.urlServer + Config.urlUtilisateur + "/" + id;

            return $http.get(url);
        }
        
        function updateUser(user) {
            var url = Config.urlServer + Config.urlUtilisateur + Config.urlUpdateUser;

            return $http.post(url, user); //Attention
        }
        
        function addUser(user) {
            var url = Config.urlServer + Config.urlUtilisateur + Config.urlAddUser;

            return $http.post(url, user);
        }
        
    }]);

services.factory('SallesRest', ['$http', 'Config',
    function ($http, Config) {
        //Liste des mÃ©thodes exposÃ©es
        var sallesRest = {
            getSalles: getSalles
        };

        return sallesRest;

        function getSalles() {
            var url = Config.urlServer + Config.urlSalle + Config.urlGetteur;

            return $http.get(url);
        }
    }]);

services.factory('LoginRest', ['$http', 'Config',
    function ($http, Config) {
        //Liste des mÃ©thodes exposÃ©es
        var loginRest = {
            login: login, 
            getProfil:getProfil
        };

        return loginRest;

        function login(login, pass) {
            var url = Config.urlServer + Config.urlUtilisateur + Config.urlLogUser;
            return $http.post(url, {"email": login,"password": pass});
        }
        
        function getProfil(idProfil) {
            var url = Config.urlServer + Config.urlProfil + Config.urlGetteurProfil + "/" + idProfil;
            return $http.get(url);
        }
    }]);