angular.module('fiuba').controller("RolesController", function($scope){
	$scope.fecha = {
		date: Date.now()
	}
	
	$scope.roles = [
			{id: 1, nombre: "Rol 1", fecha: "01/01/2012"},
			{id: 2, nombre: "Rol 2", fecha: "01/01/2012"}];

		$scope.mode = "Crear";

		$scope.create_rol = function(){
			if($scope.rol.nombre){  			
				if($scope.mode == "Crear"){
				
					var d = new Date();
					var curr_date = d.getDate();
					var curr_month = d.getMonth() + 1;
					var curr_year = d.getFullYear();
					  
					$scope.rol.id = $scope.roles.length + 1;
					$scope.rol.fecha = curr_date + '/' + curr_month + '/' + curr_year;
					$scope.roles.push($scope.rol);
				}else{
					$scope.mode = "Crear";
				}

				$scope.rol = {};
			}
		};

		$scope.delete_rol  = function(index){
			$scope.rol = {};
			$scope.mode = "Crear";
			$scope.roles.splice(index, 1);
		}

		$scope.edit_rol = function(index){
			$scope.mode = "Editar";
			$scope.rol = $scope.roles[index];
		}
	
});