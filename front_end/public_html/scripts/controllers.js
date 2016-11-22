'use strict'

/* 
 * Déclaration du module controllers qui rassemblera tous les contrôleurs
 */

var controllers = angular.module('controllers', []);

controllers.controller('MainCtrl', ['$rootScope', '$location', 'UserService',
    function ($rootScope, $location, UserService) {
        var mainCtrl = this;
        
        $rootScope.user = UserService.currentUser;
        
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

controllers.controller('UsersCtrl', ['$rootScope', 'UsersRest',
    function ($rootScope, UsersRest) {
        $rootScope.title = "Utilisateurs";
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
            //alert(usersCtrl.error);
        })
    }]);

controllers.controller('UserCtrl', ['$rootScope','UsersRest', '$routeParams',
    '$location', '$route',
    function ($rootScope, UsersRest, $routeParams, $location, $route) {
        $rootScope.title = "Utilisateurs";
        // Définition du scope
        var userCtrl = this;

        // On référence les méthodes exposées
        userCtrl.validateUser = validateUser;
        userCtrl.cancel = cancel;


        // On récupère l'id de l'employé
        userCtrl.id = $routeParams.id;

        // Si l'id est défini, c'est modification
        // sinon ce sera un ajout
        if (userCtrl.id) {
            userCtrl.titleH1 = "Modification d'un utilisateur";
        } else {
            userCtrl.titleH1 = "Ajout d'un utilisateur";
        }

        //Gestion des DatePicker
        //Pour la date de début
        // le datepicker n'est pas visible
        userCtrl.dateDebPickerOpened = false;

        // Affiche le datepicker
        userCtrl.openDateDebPicker = function () {
            userCtrl.dateDebPickerOpened = true;
        }

        //Pour la date de fin
        userCtrl.dateFinPickerOpened = false;

        // Affiche le datepicker
        userCtrl.openDateFinPicker = function () {
            userCtrl.dateFinPickerOpened = true;
        }
        
        // Récupère la liste des departments
        /*EmployeesRest.getDepartments().success(function (data) {
            employeeCtrl.departments = data;
        });*/

        // S'il s'agit d'une demande de modification, il faut lire l'employé,
        // positionner les listes déroulantes (jobs et services) en fonction
        // des valeurs de l'employé
        if (userCtrl.id > 0) {
            var userR = UsersRest.getUser($routeParams.id);
            userR.success(function (data, status) {
                if (status == 200) {
                    userCtrl.user = data;
                    
                    if (data.date_debut_dispo !== null ) {
                     userCtrl.user.date_debut_dispo = new Date(data.date_debut_dispo.toString());   
                    } 
                    if (data.date_fin_dispo !== null) {
                     userCtrl.user.date_fin_dispo = new Date(data.date_fin_dispo.toString());   
                    }
                }
            }).error(function (data) {
                userCtrl.error = data;
                alert(userCtrl.error);
            });
        }

        // On a cliqué sur le bouton Annuler
        function cancel() {
            $location.path('/users');
        }

        /**
         * On a cliqué sur le bouton valider
         * @param {type} id : id de l'employé modifié
         * @param {type} form : le formulaire complet
         */
        function validateUser(id, form) {
            // Si tout a été saisi, pas de zone oubliée
            if (form.$valid) {
                // On récupère l'objet employee dans le scope de la vue
                var user = userCtrl.user;

                //On récupère la date au format MySQL
                var moisDebut = user.date_debut_dispo.getMonth() + 1;
                var anneeDebut = user.date_debut_dispo.getYear();
                var jourDebut = user.date_debut_dispo.getDate();
                user.date_debut_dispo = anneeDebut + '-' + moisDebut + '-' + jourDebut;

                // Récupération du service sélectionné
                //employee.department = employeeCtrl.selectedOptionDep;

                // si on a un id => c'est une modification
                if (id) {
                    // Demande de mise à jour de l'employé
                    UsersRest.updateUser(user).success(function (data, status) {
                        // Si c'est OK on consulte la nouvelle liste des employés
                        // Sinon on affiche l'erreur
                        if (status === 200) {
                            $location.path('/users');
                        }
                    }).error(function (data) {
                        userCtrl.error = data;
                        alert(userCtrl.error);
                    });
                }

                // Sinon c'est la création d'un nouvel employé
                else {
                    // Demande d'ajout de l'employé
                    UsersRest.addUser(user).success(function (data, status) {
                        // Si c'est OK on consulte la nouvelle liste des employés
                        // Sinon on affiche l'erreur
                        if (status === 200) {
                            $location.path('/users');
                        }
                    }).error(function (data) {
                        userCtrl.error = data;
                        alert(userCtrl.error);
                    });
                }
            } else { // On affiche un message d'erreur type
                userCtrl.error = "Erreur de saisie !";
            }
        }


    }]);

controllers.controller('SallesCtrl', ['$rootScope', 'SallesRest',
    function ($rootScope, SallesRest) {
        $rootScope.title = "Salles";
        var sallesCtrl = this;

        //Récupère une promise
        var sallesPromise = SallesRest.getSalles();

        /* Si la requête aboutit (code 200) on affecte le jSon retourné
         * à la variable employeesCtrl.employees qui sera affichée
         * par la vue employees.html
         */
        sallesPromise.success(function (data) {
            if (data.length > 0) { //si la liste n'est pas vide
                sallesCtrl.salles = data;
            }
        }).error(function (data) { //Si la requête a provoqué une erreur (code 404)
            sallesCtrl.error = data //On affiche l'erreur brute     
            //alert(usersCtrl.error);
        })
    }]);

controllers.controller("LoginCtrl", ['$rootScope', 'UserService',
    function ($rootScope, UserService) {
        var loginCtr = this;
        
        $rootScope.title = "Connection";
        
        $rootScope.userService = UserService;

        $rootScope.user = UserService.currentUser;
        loginCtr.login = login;
        
        function login(user) {
            UserService.login(user);
        }
    }]);