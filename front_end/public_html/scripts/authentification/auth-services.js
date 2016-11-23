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
                    switch (response.idProfil) {
                        case 1:
                            //Etudiant
                        break;
                        case 2:
                            //Enseignant (admin)
                        break;
                        case 3:
                            //Entreprise
                        break;
                    }
                    _this.currentUser.name = response.nom;
                    _this.currentUser.isLoggedIn = true;
                    SessionService.setValue("session.name", response.nom);
                    SessionService.setValue("session.firstname", response.prenom);
                    //$location.path("accueil");
                }


            }).error(function (response) { //Si la requête a provoqué une erreur (code 404)
                alert("pas bon");
            });
        };
        
           /* this.login = function (user) {
                var _this = this;
                    _this.currentUser.name = "Baptiste";
                    _this.currentUser.firstname = "Chemier";
                    _this.currentUser.isLoggedIn = true;
                    SessionService.setValue("session.name", "Chemier");
                    SessionService.setValue("session.firstname", "Baptiste");
                    $location.path("accueil");
                    // or
                    //httpBufferService.retryLastRequest();


            };*/
            
        this.logout = function() {
            var _this = this;
            return $http.post("/logout").success(function() {
                _this.currentUser.isLoggedIn = false;
                SessionService.destroyItem("session.name");
                SessionService.destroyItem("session.firstname");
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
