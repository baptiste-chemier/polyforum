'use strict'

/* 
 * DÃ©claration du module controllers qui rassemblera tous les contrÃ´leurs
 */

var controllers = angular.module('controllers', []);

controllers.controller('MainCtrl', ['$rootScope', '$location', 'UserService',
    function ($rootScope, $location, UserService) {
        var mainCtrl = this;
        
        $rootScope.user = UserService.currentUser;
        
        // On rÃ©fÃ©rence les mÃ©thodes exposÃ©es
        mainCtrl.disConnect = disConnect;

        // Par defaut on n'est pas authentifiÃ©
        $rootScope.isConnected = false;
        $rootScope.title = "Test";

        /* 
         * DÃ©connexion : isConnected passe Ã  faux => le menu disparaÃ®tra
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

        //RÃ©cupÃ¨re une promise
        var usersPromise = UsersRest.getUsers();

        /* Si la requÃªte aboutit (code 200) on affecte le jSon retournÃ©
         * Ã  la variable employeesCtrl.employees qui sera affichÃ©e
         * par la vue employees.html
         */
        usersPromise.success(function (data) {
            if (data.length > 0) { //si la liste n'est pas vide
                usersCtrl.users = data;
            }
        }).error(function (data) { //Si la requÃªte a provoquÃ© une erreur (code 404)
            usersCtrl.error = data //On affiche l'erreur brute     
            //alert(usersCtrl.error);
        })
    }]);

controllers.controller('UserCtrl', ['$rootScope','UsersRest', '$routeParams',
    '$location', '$route',
    function ($rootScope, UsersRest, $routeParams, $location, $route) {
        $rootScope.title = "Utilisateurs";
        // DÃ©finition du scope
        var userCtrl = this;

        // On rÃ©fÃ©rence les mÃ©thodes exposÃ©es
        userCtrl.validateUser = validateUser;
        userCtrl.cancel = cancel;


        // On rÃ©cupÃ¨re l'id de l'employÃ©
        userCtrl.id = $routeParams.id;

        // Si l'id est dÃ©fini, c'est modification
        // sinon ce sera un ajout
        if (userCtrl.id) {
            userCtrl.titleH1 = "Modification d'un utilisateur";
        } else {
            userCtrl.titleH1 = "Ajout d'un utilisateur";
        }

        //Gestion des DatePicker
        //Pour la date de dÃ©but
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
        
        // RÃ©cupÃ¨re la liste des departments
        /*EmployeesRest.getDepartments().success(function (data) {
            employeeCtrl.departments = data;
        });*/

        // S'il s'agit d'une demande de modification, il faut lire l'employÃ©,
        // positionner les listes dÃ©roulantes (jobs et services) en fonction
        // des valeurs de l'employÃ©
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

        // On a cliquÃ© sur le bouton Annuler
        function cancel() {
            $location.path('/users');
        }

        /**
         * On a cliquÃ© sur le bouton valider
         * @param {type} id : id de l'employÃ© modifiÃ©
         * @param {type} form : le formulaire complet
         */
        function validateUser(id, form) {
            // Si tout a Ã©tÃ© saisi, pas de zone oubliÃ©e
            if (form.$valid) {
                // On rÃ©cupÃ¨re l'objet employee dans le scope de la vue
                var user = userCtrl.user;

                //On rÃ©cupÃ¨re la date au format MySQL
                var moisDebut = user.date_debut_dispo.getMonth() + 1;
                var anneeDebut = user.date_debut_dispo.getYear();
                var jourDebut = user.date_debut_dispo.getDate();
                user.date_debut_dispo = anneeDebut + '-' + moisDebut + '-' + jourDebut;

                // RÃ©cupÃ©ration du service sÃ©lectionnÃ©
                //employee.department = employeeCtrl.selectedOptionDep;

                // si on a un id => c'est une modification
                if (id) {
                    // Demande de mise Ã  jour de l'employÃ©
                    UsersRest.updateUser(user).success(function (data, status) {
                        // Si c'est OK on consulte la nouvelle liste des employÃ©s
                        // Sinon on affiche l'erreur
                        if (status === 200) {
                            $location.path('/users');
                        }
                    }).error(function (data) {
                        userCtrl.error = data;
                        alert(userCtrl.error);
                    });
                }

                // Sinon c'est la crÃ©ation d'un nouvel employÃ©
                else {
                    // Demande d'ajout de l'employÃ©
                    UsersRest.addUser(user).success(function (data, status) {
                        // Si c'est OK on consulte la nouvelle liste des employÃ©s
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

        //RÃ©cupÃ¨re une promise
        var sallesPromise = SallesRest.getSalles();

        /* Si la requÃªte aboutit (code 200) on affecte le jSon retournÃ©
         * Ã  la variable employeesCtrl.employees qui sera affichÃ©e
         * par la vue employees.html
         */
        sallesPromise.success(function (data) {
            if (data.length > 0) { //si la liste n'est pas vide
                sallesCtrl.salles = data;
            }
        }).error(function (data) { //Si la requÃªte a provoquÃ© une erreur (code 404)
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
            UserService.login(user.login, user.pass);
        }
    }]);

controllers.controller('MonCompteCtrl', ['$rootScope', 'UsersRest', '$routeParams',
    '$location', '$route',
    function ($rootScope, UsersRest, $routeParams, $location, $route) {
        $rootScope.title = "Mon compte";
        // DÃ©finition du scope
        var monCompteCtrl = this;

        // On rÃ©fÃ©rence les mÃ©thodes exposÃ©es
        monCompteCtrl.validateUser = validateUser;
        monCompteCtrl.cancel = cancel;


        // On rÃ©cupÃ¨re l'id de l'employÃ©
        monCompteCtrl.id = $routeParams.id;

        //Gestion des DatePicker
        //Pour la date de dÃ©but
        // le datepicker n'est pas visible
        monCompteCtrl.dateDebPickerOpened = false;

        // Affiche le datepicker
        monCompteCtrl.openDateDebPicker = function () {
            monCompteCtrl.dateDebPickerOpened = true;
        }

        //Pour la date de fin
        monCompteCtrl.dateFinPickerOpened = false;

        // Affiche le datepicker
        monCompteCtrl.openDateFinPicker = function () {
            monCompteCtrl.dateFinPickerOpened = true;
        }

        // RÃ©cupÃ¨re la liste des departments
        /*EmployeesRest.getDepartments().success(function (data) {
         employeeCtrl.departments = data;
         });*/

        // S'il s'agit d'une demande de modification, il faut lire l'employÃ©,
        // positionner les listes dÃ©roulantes (jobs et services) en fonction
        // des valeurs de l'employÃ©
        if (monCompteCtrl.id > 0) {
            var userR = UsersRest.getUser($routeParams.id);
            userR.success(function (data, status) {
                if (status == 200) {
                    monCompteCtrl.user = data;

                    if (data.date_debut_dispo !== null) {
                        monCompteCtrl.user.date_debut_dispo = new Date(data.date_debut_dispo.toString());
                    }
                    if (data.date_fin_dispo !== null) {
                        monCompteCtrl.user.date_fin_dispo = new Date(data.date_fin_dispo.toString());
                    }
                }
            }).error(function (data) {
                monCompteCtrl.error = data;
                alert(monCompteCtrl.error);
            });
        }

        // On a cliquÃ© sur le bouton Annuler
        function cancel() {
            $location.path('accueil');
        }

        /**
         * On a cliquÃ© sur le bouton valider
         * @param {type} id : id de l'employÃ© modifiÃ©
         * @param {type} form : le formulaire complet
         */
        function validateUser(id, form) {
            // Si tout a Ã©tÃ© saisi, pas de zone oubliÃ©e
            if (form.$valid) {
                // On rÃ©cupÃ¨re l'objet employee dans le scope de la vue
                var user = monCompteCtrl.user;

                //On rÃ©cupÃ¨re la date au format MySQL
                var moisDebut = user.date_debut_dispo.getMonth() + 1;
                var anneeDebut = user.date_debut_dispo.getYear();
                var jourDebut = user.date_debut_dispo.getDate();
                user.date_debut_dispo = anneeDebut + '-' + moisDebut + '-' + jourDebut;

                // RÃ©cupÃ©ration du service sÃ©lectionnÃ©
                //employee.department = employeeCtrl.selectedOptionDep;

                // si on a un id => c'est une modification
                if (id) {
                    // Demande de mise Ã  jour de l'employÃ©
                    UsersRest.updateUser(user).success(function (data, status) {
                        // Si c'est OK on consulte la nouvelle liste des employÃ©s
                        // Sinon on affiche l'erreur
                        if (status === 200) {
                            $location.path('/users');
                        }
                    }).error(function (data) {
                        monCompteCtrl.error = data;
                        alert(monCompteCtrl.error);
                    });
                }

                else {
                    //Il y a forcÃ©ment un ID sinon, erreur
                    monCompteCtrl.error = "Erreur de chargement !";
                }
            } else { // On affiche un message d'erreur type
                monCompteCtrl.error = "Erreur de saisie !";
            }
        }

    }]);