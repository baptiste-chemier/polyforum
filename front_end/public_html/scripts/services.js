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
            urlDeleteUser: '/supprimer',
            urlLogUser: '/connecter',
            urlProfil: '/profil',
            urlGetteurProfil: '/recupererLibelle',
            urlSalle: '/salle',
            urlGetteurSalle: '/lister',
            urlUpdateSalle: '/modifier',
            urlAddSalle: '/ajouter',
            urlDeleteSalle: '/supprimer', 
            urlChoixEtudiant:'/choixEtudiant',
            urlGetteurChoixEtudiant: '/lister', 
            urlsaveChoixEtudiant: '/ajouter', 
            urlGetChoixEtudiantNonAJouter:'/listerEntrepriseNonAjoutee', 
            urlDeleteChoixEtudiant: '/supprimer',
            
            //Planning
            urlPlanning: '/entretien',
            urlGenererPlanning: '/genererPlanning',
            urlListerPlanning: 'lister',
            
            //Config
            urlConfig:'/forum',
            urlUpdateConfig:'/modifier', 
            
            //Choix Entreprise
            urlChoixEntreprise: '/choixEntreprise',
            urlGetChoixEntrepriseNonAJouter: '/listerEtudiantNonAjoutee',
            urlGetteurChoixEntreprise: '/lister', 
            urlDeleteChoixEntreprise:'/supprimer', 
            urlsaveChoixEntreprise: '/ajouter'

        };
    }]);

/*
 * Gestion de l'acces aux donnees, utilise le
 * service Config qui contient les urls du serveur RestFul 
 * Chaque mehotde exposee retourne une promise qui 
 * sera exploitee dans les controleurs
 */
services.factory('UsersRest', ['$http', 'Config',
    function ($http, Config) {
        //Liste des methodes exposees
        var userRest = {
            getUsers: getUsers,
            getUser: getUser,
            updateUser: updateUser,
            addUser: addUser,
            deleteUser: deleteUser,
            getProfil: getProfil
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

        function updateUser(user, id) {
            var url = Config.urlServer + Config.urlUtilisateur + Config.urlUpdateUser + '/' + id;
            return $http.put(url, user); //Attention
        }

        function addUser(user) {
            var url = Config.urlServer + Config.urlUtilisateur + Config.urlAddUser;

            return $http.post(url, user);
        }

        function deleteUser(id) {
            var url = Config.urlServer + Config.urlUtilisateur + Config.urlDeleteUser + "/" + id;
            return $http.get(url);
        }
        
        function getProfil(){
            var url = Config.urlServer + "/profil/" + "/lister";
            return $http.get(url);
        }

    }]);

services.factory('SallesRest', ['$http', 'Config',
    function ($http, Config) {
        //Liste des méthodes exposées

        var sallesRest = {
            getSalles: getSalles,
            getSalle: getSalle,
            updateSalle: updateSalle,
            addSalle: addSalle,
            deleteSalle: deleteSalle
        };

        var REST_SERVICE_URI = Config.urlServer + Config.urlSalle;
        return sallesRest;

        function getSalles() {
            var url = REST_SERVICE_URI + Config.urlGetteurSalle;
            return $http.get(url);
        }

        function getSalle(id) {
            var url = Config.urlServer + Config.urlSalle + "/" + id;
            return $http.get(url);

        }

        function updateSalle(salle, id) {
            var url = REST_SERVICE_URI + Config.urlUpdateSalle + "/" + id;
            return $http.put(url, salle);
  
        }



        function addSalle(salle) {
            var url = REST_SERVICE_URI + Config.urlAddSalle;
            return $http.post(url, salle);
        }

        function deleteSalle(id) {
            var url = REST_SERVICE_URI + Config.urlDeleteSalle + "/" + id;
            return $http.get(url);
        }
    }]);

services.factory('LoginRest', ['$http', 'Config',
    function ($http, Config) {
        //Liste des mÃ©thodes exposÃ©es
        var loginRest = {
            login: login,
            getProfil: getProfil
        };

        return loginRest;

        function login(login, pass) {
            var url = Config.urlServer + Config.urlUtilisateur + Config.urlLogUser;
            return $http.post(url, {"email": login, "password": pass});
        }

        function getProfil(idProfil) {
            var url = Config.urlServer + Config.urlProfil + Config.urlGetteurProfil + "/" + idProfil;
            return $http.get(url);
        }
    }]);

services.factory('ChoixEtudiant', ['$http', 'Config',
    function ($http, Config) {
        //Liste des mÃ©thodes exposÃ©es
        var choixRest = {
            getAllChoix: getAllChoix, 
            saveChoix:saveChoix,
            getChoix:getChoix, 
            getChoixNonAjouter:getChoixNonAjouter, 
            deleteChoix:deleteChoix
        };

        return choixRest;

        function getAllChoix() {
            var url = Config.urlServer + Config.urlChoixEtudiant + Config.urlGetteurChoixEtudiant;
            return $http.get(url);
        }
        
        function saveChoix(id_etudiant, id_entreprise, ordre) {
            var url = Config.urlServer + Config.urlChoixEtudiant + Config.urlsaveChoixEtudiant;
            
            return $http.post(url, {"id_etudiant": id_etudiant, "id_entreprise": id_entreprise, "ordre":ordre, "duree":10});
        }
        
        function getChoix(idEtu) {
            var url = Config.urlServer + Config.urlChoixEtudiant + Config.urlGetteurChoixEtudiant + "/" + idEtu;;
            return $http.get(url);
        }
        
        function getChoixNonAjouter(idEtu) {
            var url = Config.urlServer + Config.urlChoixEtudiant + Config.urlGetChoixEtudiantNonAJouter + "/" + idEtu;
            ;
            return $http.get(url);
        }
        
        function deleteChoix(id_entreprise, id_etudiant) {
            var url = Config.urlServer + Config.urlChoixEtudiant + Config.urlDeleteChoixEtudiant + "/" + id_etudiant + "/" +id_entreprise;

            return $http.get(url);
        }
    }]);

services.factory('PlanningRest', ['$http', 'Config',
    function ($http, Config) {
        //Liste des mÃ©thodes exposÃ©es
        var planningRest = {
             getEntreprises: getEntreprises,
             genererPlanning :genererPlanning,
             listerPlanning : listerPlanning
        };

        return planningRest;
        
        
        function getEntreprises() {
            var url = Config.urlServer + Config.urlUtilisateur + Config.urlGetteurUser;
            return $http.get(url);
        }

        function genererPlanning(){
            var url = Config.urlServer + Config.urlPlanning + Config.urlGenererPlanning;
            return $http.get(url);
        }
        
        function listerPlanning(){
            var url = Config.urlServer + Config.urlPlanning + Config.urlListerPlanning + "/" + 1;
            return $http.get(url);
        }
    }]);

services.factory('ConfigService', ['$http', 'Config',
    function ($http, Config) {
        //Liste des methodes exposees
        var userRest = {
            getConfig: getConfig,
            updateConfig: updateConfig,
        };

        return userRest;

        function getConfig(id) {
            var url = Config.urlServer + Config.urlConfig + "/" + id;

            return $http.get(url);
        }

        function updateConfig(config, id) {
            var url = Config.urlServer + Config.urlConfig + Config.urlUpdateConfig + '/' + id;
            return $http.put(url, config); 
        }


    }]);

services.factory('ChoixCompany', ['$http', 'Config',
    function ($http, Config) {
        //Liste des mÃ©thodes exposÃ©es
        var choixRest = {
            saveChoix: saveChoix,
            getChoix: getChoix,
            getChoixNonAjouter: getChoixNonAjouter,
            deleteChoix: deleteChoix
        };

        return choixRest;

        function saveChoix(id_etudiant, id_entreprise, ordre, duree) {
            var url = Config.urlServer + Config.urlChoixEntreprise + Config.urlsaveChoixEntreprise;

            return $http.post(url, {"id_etudiant": id_etudiant, "id_entreprise": id_entreprise, "ordre": ordre, "duree": duree});
        }

        function getChoix(id_entreprise) {
            var url = Config.urlServer + Config.urlChoixEntreprise + Config.urlGetteurChoixEntreprise + "/" + id_entreprise;

            return $http.get(url);
        }

        function getChoixNonAjouter(id_entreprise) {
            var url = Config.urlServer + Config.urlChoixEntreprise + Config.urlGetChoixEntrepriseNonAJouter + "/" + id_entreprise;
            ;
            return $http.get(url);
        }

        function deleteChoix(id_entreprise, id_etudiant) {
            var url = Config.urlServer + Config.urlChoixEntreprise + Config.urlDeleteChoixEntreprise + "/" + id_entreprise + "/" + id_etudiant;

            return $http.get(url);
        }
    }]);