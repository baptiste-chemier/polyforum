'use strict'

/* 
 * DÃ©claration du module controllers qui rassemblera tous les contrÃ´leurs
 */

var controllers = angular.module('controllers', []);

controllers.controller('MainCtrl', ['$rootScope', '$location', 'UserService',
    function ($rootScope, $location, UserService) {
        var mainCtrl = this;

        $rootScope.user = UserService.currentUser;

        $rootScope.title = "Accueil";

        $rootScope.disconnect = function () {
            UserService.logout($rootScope);
        };

    }]);

controllers.controller('Apropos', ['$rootScope', '$location',
    function ($rootScope, $location) {
        var apropos = this;

        $rootScope.title = "A propos";
    }]);

controllers.controller('UsersCtrl', ['$rootScope', 'UsersRest', '$location', '$route',
    function ($rootScope, UsersRest, $location, $route) {
        $rootScope.title = "Utilisateurs";
        var usersCtrl = this;

        //Récupère une promise
        var usersPromise = UsersRest.getUsers();

        // On référence les méthodes exposées
        usersCtrl.deleteUser = deleteUser;

        /* Si la requete aboutit (code 200) on affecte le jSon retourne
         * A  la variable employeesCtrl.employees qui sera affiche
         * par la vue employees.html
         */
        usersPromise.success(function (data) {
            if (data.length > 0) { //si la liste n'est pas vide
                usersCtrl.users = data;
            }
        }).error(function (data) { //Si la requÃªte a provoquÃ© une erreur (code 404)
            usersCtrl.error = data; //On affiche l'erreur brute     
            //alert(usersCtrl.error);
        });

        /**
         * Suppression d'une salle
         * @param {type} id de la salle a supprimer
         */
        function deleteUser(id) {
            if (id) {
                UsersRest.deleteUser(id).success(function (data, status) {
                    if (status === 200) {
                        $location.path('/users');
                        $route.reload();
                    }
                }).error(function (data) {
                    usersCtrl.error = data;
                    alert(usersCtrl.error);
                });
            }
        }
    }]);

controllers.controller('UserCtrl', ['$rootScope', 'UsersRest', '$routeParams',
    '$location', '$route',
    function ($rootScope, UsersRest, $routeParams, $location, $route) {
        $rootScope.title = "Utilisateurs";
        // DÃ©finition du scope
        var userCtrl = this;


        // On reference les methodes exposees
        userCtrl.validateUser = validateUser;
        userCtrl.cancel = cancel;


        // On recupere l'id de l'employe
        userCtrl.id = $routeParams.id;

        // Si l'id est dÃ©fini, c'est modification
        // sinon ce sera un ajout
        if (userCtrl.id) {
            userCtrl.titleH1 = "Modification d'un utilisateur";
        } else {
            userCtrl.titleH1 = "Ajout d'un utilisateur";
        }

        var d = new Date();
        d.setHours(14);
        d.setMinutes(0);
        userCtrl.time = d;

        userCtrl.timeOpened = false;

        // Affiche le datepicker
        userCtrl.opentimeOpened = function () {
            userCtrl.timeOpened = true;
        };

        var fin = new Date();
        fin.setHours(18);
        fin.setMinutes(0);
        userCtrl.timefin = fin;

        userCtrl.timeClosed = false;

        // Affiche le datepicker
        userCtrl.opentimeClosed = function () {
            userCtrl.timeClosed = true;
        };


        // S'il s'agit d'une demande de modification, il faut lire l'employe,
        if (userCtrl.id > 0) {
            var userR = UsersRest.getUser($routeParams.id);
            userR.success(function (data, status) {
                if (status === 200) {
                    userCtrl.user = data;

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
         * On a clique sur le bouton valider
         * @param {type} id : id de l'employe modifie
         * @param {type} form : le formulaire complet
         */
        function validateUser(id, form) {
            // Si tout a ete saisi, pas de zone oubliee
            if (form.$valid) {
                // On recupere l'objet employee dans le scope de la vue
                var user = userCtrl.user;

                //On recupere la date au format MySQL
//                var moisDebut = user.date_debut_dispo.getMonth() + 1;
//                var anneeDebut = user.date_debut_dispo.getYear();
//                var jourDebut = user.date_debut_dispo.getDate();
//                user.date_debut_dispo = anneeDebut + '-' + moisDebut + '-' + jourDebut;

                var moisDebut = userCtrl.time.getMonth() + 1;
                var anneeDebut = userCtrl.time.getYear();
                var jourDebut = userCtrl.time.getDate();
                var heureDebut = userCtrl.time.getHours();
                var minDebut = userCtrl.time.getMinutes();


                var simpledate = jourDebut + '-' + moisDebut + '-' + anneeDebut + ' ' + heureDebut + ':' + minDebut + ':00';
                user.date_debut_dispo = simpledate;

                var moisFin = userCtrl.timefin.getMonth() + 1;
                var anneeFin = userCtrl.timefin.getYear();
                var jourFin = userCtrl.timefin.getDate();
                var heureFin = userCtrl.timefin.getHours();
                var minFin = userCtrl.timefin.getMinutes();


                var simpledatefin = jourFin + '-' + moisFin + '-' + anneeFin + ' ' + heureFin + ':' + minFin + ':00';
                user.date_fin_dispo = simpledatefin;

                // si on a un id => c'est une modification
                if (id) {
                    // Demande de mise a  jour de l'employe
                    userCtrl.log = "add";
                    UsersRest.updateUser(user).success(function (data, status) {
                        // Si c'est OK on consulte la nouvelle liste des employes
                        // Sinon on affiche l'erreur
                        if (status === 200) {
                            $location.path('/users');
                        }
                    }).error(function (data) {
                        userCtrl.error = data;
                        alert(userCtrl.error);
                    });
                }

                // Sinon c'est la creation d'un nouvel employe
                else {
                    // Demande d'ajout de l'employe
                    UsersRest.addUser(user).success(function (data, status) {
                        // Si c'est OK on consulte la nouvelle liste des employes
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

controllers.controller('SallesCtrl', ['$rootScope', 'SallesRest', '$location', '$route',
    function ($rootScope, SallesRest, $location, $route) {
        $rootScope.title = "Salles";
        var sallesCtrl = this;
        //Récupère une promise
        var sallesPromise = SallesRest.getSalles();

        // On référence les méthodes exposées
        sallesCtrl.deleteSalle = deleteSalle;

        /* Si la requête aboutit (code 200) on affecte le jSon retourné
         * à la variable sallesCtrl.salles qui sera affichée
         * par la vue salles.html
         */
        sallesPromise.success(function (data) {
            if (data.length > 0) { //si la liste n'est pas vide
                sallesCtrl.salles = data;
            }
        }).error(function (data) { //Si la requête a provoqué une erreur (code 404)
            sallesCtrl.error = data; //On affiche l'erreur brute     
            //alert(usersCtrl.error);
        });

        /**
         * Suppression d'une salle
         * @param {type} id de la salle a supprimer
         */
        function deleteSalle(id) {
            if (id) {
                SallesRest.deleteSalle(id).success(function (data, status) {
                    if (status === 200) {
                        $location.path('/salles');
                        $route.reload();
                    }
                }).error(function (data) {
                    sallesCtrl.error = data;
                    alert(sallesCtrl.error);
                });
            }
        }
    }]);

controllers.controller('SalleCtrl', ['$rootScope', 'SallesRest', '$routeParams',
    '$location', '$route',
    function ($rootScope, SallesRest, $routeParams, $location, $route) {
        $rootScope.title = "Salles";
        // Définition du scope
        var salleCtrl = this;

        // On référence les méthodes exposées
        salleCtrl.validateSalle = validateSalle;
        salleCtrl.cancel = cancel;
        salleCtrl.reset = reset;


        salleCtrl.log = "yesy";
        // On récupère l'id de la salle
        salleCtrl.id = $routeParams.id;


        // Si l'id est défini, c'est modification
        // sinon ce sera un ajout
        if (salleCtrl.id) {
            salleCtrl.titleH1 = "Modification d'une salle";
        } else {
            salleCtrl.titleH1 = "Ajout d'une salle";
        }

        SallesRest.getSalles();

        // S'il s'agit d'une demande de modification, il faut lire l'employé,
        // positionner les listes déroulantes (jobs et services) en fonction
        // des valeurs de l'employé
        if (salleCtrl.id > 0) {
            var salleS = SallesRest.getSalle($routeParams.id);
            salleS.success(function (data, status) {
                if (status === 200) {
                    salleCtrl.salle = data;
                }
            }).error(function (data) {
                salleCtrl.error = data;
                salle(salleCtrl.error);
            });
        }

        /**
         * On a cliqué sur le bouton valider
         * @param {type} id : id de l'employé modifié
         * @param {type} form : le formulaire complet
         */
        function validateSalle(id, form) {
            // Si tout a été saisi, pas de zone oubliée
            if (form.$valid) {
                // On récupère l'objet employee dans le scope de la vue
                var salle = salleCtrl.salle;


                // Récupération du service sélectionné
                //employee.department = employeeCtrl.selectedOptionDep;

                // si on a un id => c'est une modification
                if (id) {
                    salleCtrl.log = "modif";
                    // Demande de mise à jour de l'employé
                    SallesRest.updateSalle(salle,salleCtrl.id).success(function (data, status) {
                        // Si c'est OK on consulte la nouvelle l
                        // iste des employés
                        // Sinon on affiche l'erreur
                        if (status === 200) {
                            $location.path('/salles');
                        }
                    }).error(function (data) {
                        salleCtrl.error = data;
                        alert(salleCtrl.error);
                    });
                }

                // Sinon c'est la création d'un nouvel employé
                else {
                    // Demande d'ajout de l'employé

                    SallesRest.addSalle(salle).success(function (data, status) {
                        // Si c'est OK on consulte la nouvelle liste des employés
                        // Sinon on affiche l'erreur
                        if (status === 200) {
                            $location.path('/salles');
                        }
                    }).error(function (data) {
                        salleCtrl.error = data;
                        alert(salleCtrl.error);
                    });
                }
            } else { // On affiche un message d'erreur type
                salleCtrl.error = "Erreur de saisie !";
            }
        }

        // On a cliqué sur le bouton Annuler
        function cancel() {
            $location.path('/salles');
        }

        function reset() {
            salleCtrl.salle = {id: null, username: '', address: '', email: ''};
            $rootScope.myForm.$setPristine(); //reset Form

        }
    }]);

controllers.controller("LoginCtrl", ['$rootScope', 'UserService',
    function ($rootScope, UserService) {
        var loginCtr = this;

        $rootScope.title = "Connexion";
        
        $rootScope.userService = UserService;

        $rootScope.user = UserService.currentUser;

        $rootScope.login = function () {
            UserService.login($rootScope).success(function () {
            });
        };

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
                if (status === 200) {
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