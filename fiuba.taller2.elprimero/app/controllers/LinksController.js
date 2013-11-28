angular.module('fiuba').controller("LinksController", function($scope){
	$scope.links = [
  		{id: 1, description: "Libro de probabilidad y estadistica", url:"http://www.scribd.com/doc/120861324/probabilidad"},
  		{id: 2, description: "Las matemáticas y suenseñanza en la escuelasecundaria III",
  					 url:"http://www.scribd.com/doc/131724789/probabilidad-y-estadistica-pdf"}];

  	$scope.mode = "Crear";

  	$scope.create_link = function(){
  		if($scope.link.description && $scope.link.url){  			
  			if($scope.mode == "Crear"){
  				$scope.link.id = $scope.links.length + 1;
  				$scope.links.push($scope.link);
  			}else{
  				$scope.mode = "Crear";
  			}

  			$scope.link = {};
  		}
  	};

  	$scope.delete_link  = function(index){
  		$scope.link = {};
  		$scope.mode = "Crear";
  		$scope.links.splice(index, 1);
  	}

  	$scope.edit_link = function(index){
  		$scope.mode = "Editar";
  		$scope.link = $scope.links[index];
  	}
});