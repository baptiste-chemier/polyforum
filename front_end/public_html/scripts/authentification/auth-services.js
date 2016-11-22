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
            isLoggedIn: (SessionService.getValue("session.name") ? true : false)
        };

        this.login = function(user) {
            var _this = this;
           return LoginRest.login(user.login, user.pass).success(function(response) {

                _this.currentUser.name = response.username;
                _this.currentUser.isLoggedIn = true;
                SessionService.setValue("session.name", response.nom);
                SessionService.setValue("session.firstname", response.prenom);
                $location.path("accueil");
                // or
                //httpBufferService.retryLastRequest();

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
