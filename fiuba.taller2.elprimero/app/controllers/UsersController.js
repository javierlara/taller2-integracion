angular.module('fiuba').controller("UsersController", function($scope, $rootScope, AuthenticationService){

	$scope.signIn = function(){
		if(AuthenticationService.signIn($scope.user)){
			$rootScope.current_user = AuthenticationService.currentUser();
			$rootScope.location.path( "/");
		}
	}

	$scope.signUp = function(){
		if($scope.user.email == $scope.user.email_confirmation ){
			if(AuthenticationService.signUp($scope.user)){
				$rootScope.current_user = AuthenticationService.currentUser();
				$rootScope.location.path( "/");
			}	
		}else{
			$scope.email_error = {message: "Los emails deben coincidir."};
		}
	}
});