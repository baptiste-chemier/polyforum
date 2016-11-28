angular.module("AuthServices", [])
    .service("SessionService", function() {
        this.setValue = function(key, value) {
            localStorage.setItem(key, value);
        };
        this.getValue = function(key) {
            return localStorage.getItem(key);
        };
        this.destroyItem = function(key) {
            localStorage.removeItem(key);
        };
    })
    .service("UserService", function($http, $location, LoginRest, SessionService, httpBufferService) {

        this.currentUser = {
            name: SessionService.getValue("session.name") || "",
            firstname: SessionService.getValue("session.firstname") || "",
            isLoggedIn: (SessionService.getValue("session.name") ? true : false), 
            badConnexion: (SessionService.getValue("session.badConnexion") ? false : true), 
            profil: SessionService.getValue("session.profil") || "",
            isStudent: SessionService.getValue("session.isLoggedInAsStudent"),
            isTeacher: SessionService.getValue("session.isLoggedInAsTeacher"),
            isCompany: SessionService.getValue("session.isLoggedInAsCompany"),
            id: SessionService.getValue("session.userId")
        };

        this.login = function($rootScope) {
            var _this = this;
            var user = $rootScope.user;

           return LoginRest.login(user.login, user.pass).success(function(response) {
                if (false == response) {
                    //Bad pass or bad login
                    $rootScope.errMsg = "Le nom d'utilisateur ou le mot de passe saisi est incorrect.";
                    $rootScope.user.badConnexion = true;
                    SessionService.setValue("session.badConnexion", "bad.");
                } else {
                    $rootScope.user.badConnexion = false;
                    var isStudent = false;
                    var isTeacher = false;
                    var isCompany = false;
                    switch (response.idProfil) {
                        case 1:
                            //Etudiant
                            SessionService.setValue("session.profil", "Etudiant");
                            SessionService.setValue("session.isLoggedInAsStudent", true);
                            SessionService.setValue("session.isLoggedInAsTeacher", false);
                            SessionService.setValue("session.isLoggedInAsCompany", false);
                            isStudent= true;
                            
                        break;
                        case 2:
                            //Enseignant (admin)
                            SessionService.setValue("session.profil", "Enseignant");
                            SessionService.setValue("session.isLoggedInAsStudent", false);
                            SessionService.setValue("session.isLoggedInAsTeacher", true);
                            SessionService.setValue("session.isLoggedInAsCompany", false);
                            isTeacher = true;
                        break;
                        case 3:
                            //Entreprise
                            SessionService.setValue("session.profil", "Entreprise");
                            SessionService.setValue("session.isLoggedInAsStudent", false);
                            SessionService.setValue("session.isLoggedInAsTeacher", false);
                            SessionService.setValue("session.isLoggedInAsCompany", true);
                            isCompany =true;
                        break;
                    }
                    _this.currentUser.name = response.nom;
                    _this.currentUser.firstname = response.prenom;
                    _this.currentUser.isLoggedIn = true;
                    _this.currentUser.isStudent = isStudent;
                    _this.currentUser.isCompany = isCompany;
                    _this.currentUser.isTeacher = isTeacher;
                    
                    SessionService.setValue("session.name", response.nom);
                    SessionService.setValue("session.firstname", response.prenom);
                    SessionService.setValue("session.userId", response.id);
                    $location.path("accueil");
                }


            }).error(function (response) { //Si la requête a provoqué une erreur (code 404)
                alert("pas bon");
            });
        };
            
        this.logout = function($rootScope) {
            var _this = this;
            _this.currentUser.isLoggedIn = false;
            _this.currentUser.isStudent = false;
            _this.currentUser.isCompany = false;
            _this.currentUser.isTeacher = false;
            _this.currentUser.name = "";
            _this.currentUser.firstname = "";
            
            SessionService.destroyItem("session.name");
            SessionService.destroyItem("session.firstname");
            SessionService.destroyItem("session.userId");
            SessionService.destroyItem("session.isLoggedInAsStudent");
            SessionService.destroyItem("session.isLoggedInAsTeacher");
            SessionService.destroyItem("session.isLoggedInAsCompany");

            $rootScope.$apply(function () {
                $location.path("/login");
                console.log($location.path());
            });
        };


        this.loginShowing = false;

        this.setLoginState = function(state) {
            this.loginShowing = state;
        };
    })
    .factory("httpBufferService", function($injector) {

        var $http;
        var buffer = {};


        return {
            storeRequest: function(request) {
                buffer = request;
            },
            retryLastRequest: function() {

                function successCallback(response) {
                    buffer.deferred.resolve(response);
                }

                function errorCallback(response) {
                    buffer.deferred.reject(response);
                }
                $http = $http || $injector.get("$http");
                $http(buffer.config).then(successCallback, errorCallback);
            }
        };
    });


