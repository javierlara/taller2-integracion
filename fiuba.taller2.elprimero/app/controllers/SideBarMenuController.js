angular.module('fiuba').controller("SideBarMenuController", function($scope,$location){
   	$scope.open_recursos = function(){
   		$scope.recursos_selected = !$scope.recursos_selected;
   	}

   	$scope.open_participacion = function(){
   		$scope.participacion_selected = !$scope.participacion_selected;
   	}

   	$scope.open_colaboracion = function(){
   		$scope.colaboracion_selected = !$scope.colaboracion_selected;
   	}

   	$scope.visiting = function(page){
   		return $location.path().indexOf(page)>0;
   	}
});