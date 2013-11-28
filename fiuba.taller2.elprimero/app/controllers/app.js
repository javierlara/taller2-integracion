// Declare app level module which depends on filters, and services
var fiuba = angular.module('fiuba', ['ngRoute']);

var hide_layout = function(location){
  return location.path().indexOf("sign")>0;
}

fiuba.config(function($routeProvider) {
  $routeProvider.when('/', {templateUrl: 'views/comunicacion/index.html', controller: 'NewsController'});
  
  //Recursos
  $routeProvider.when('/recursos/archivos', {templateUrl: 'views/archivos/new.html', controller: 'ArchivosController'});
  $routeProvider.when('/recursos/encuestas', {templateUrl: 'views/encuestas/index.html', controller: 'EncuestasController'});
  $routeProvider.when('/recursos/encuestas/new', {templateUrl: 'views/encuestas/new.html', controller: 'EncuestasController'});
  $routeProvider.when('/recursos/links', {templateUrl: 'views/links/index.html', controller: 'LinksController'});


  //participacion
  $routeProvider.when('/participacion/roles', {templateUrl: 'views/roles/index.html', controller: 'RolesController'});
  $routeProvider.when('/participacion/roles/new', {templateUrl: 'views/roles/new.html', controller: 'RolesController'});

  //colaboracion
  $routeProvider.when('/colaboracion/wiki', {templateUrl: 'views/wiki/new.html', controller: 'WikiController'});
  $routeProvider.when('/colaboracion/tablas', {templateUrl: 'views/table/index.html', controller: 'TableController'});
  $routeProvider.when('/colaboracion/tablas/new', {templateUrl: 'views/table/new.html', controller: 'TableController'});

  //users
  $routeProvider.when('/users/signin', {templateUrl: 'views/users/signin.html', controller: 'UsersController'});
  $routeProvider.when('/users/signup', {templateUrl: 'views/users/signup.html', controller: 'UsersController'});
  
  $routeProvider.otherwise({redirectTo: '/'});

}).run( function($rootScope, $location, AuthenticationService) {
    $rootScope.location = $location;
    $rootScope.hide_layout = hide_layout;

    // register listener to watch route changes
    $rootScope.$on( "$routeChangeStart", function(event, next, current) {
      if (!AuthenticationService.isSignedIn()) {
        if ( next.templateUrl != "views/users/signup.html" )
          $location.path( "/users/signin" );
      }    
    });
});

