angular.module('fiuba').factory('AuthenticationService', function($http) {
  var current_user;
  var authenticationServiceUrl = 'http://localhost:8080/taller-webapp/api/securityservice/';

  return {
    signIn: function(user) {
      // check password on server, get user data, unique token, etc.
      //return boolean
      console.log(user);

      $http.post(authenticationServiceUrl + 'login', 
        { "username": user.username , "password": user.password })
        .success( function(data) {
            current_user = user;
            return true;
            console.log('login ok');
        });



      return false;
    },
    
    //should be moved to its own service. 
    signUp: function(user){
      //create user and then signin.
      console.log(user);
      /*"username": "str",
      "password": "str",
      "nombre": "str",
      "apellido": "str",
      "padron": int,
      "fechaNac": "dd/mm/aaaa",
      "email": "str",
      "rol": int
      */      
      $http.post(authenticationServiceUrl + 'registeruser', 
      { "username": user.username, 
        "password": user.password, 
        "nombre" : user.name, 
        "apellido" : user.lastname,
        "padron": 87229,
        "fechaNac": "08/09/1986",
        "email" : user.email,
        "rol": 1 })
      .success( function(data) {
          console.log('singup ok');
          return this.signIn(user);
      });
      return false;
    },

    signOut: function() {
      // clear current_user data, unset logged in status, etc.

      //REPLACE 
      current_user = null;
    },

    isSignedIn: function() {
      // logic to check if current user has signed in
      
      //REPLACE
      return current_user;
    },

    currentUser: function() {
      // return the current_user object, or handle if the user is not signed in
      return current_user;
    }
  };
});