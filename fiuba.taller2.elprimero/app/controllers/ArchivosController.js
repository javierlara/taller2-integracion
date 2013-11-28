angular.module('fiuba').controller("ArchivosController", function($scope){
    
    $scope.setFiles = function(element) {	
		$scope.$apply(function(scope) {
		  console.log('files:', element.files);
		  // Turn the FileList object into an Array
			scope.files = []
			for (var i = 0; i < element.files.length; i++) {
			  $scope.files.push(element.files[i])
			}      
		  });
    };
	
	$scope.delete_file  = function(index){
  		$scope.files.splice(index, 1);
  	}
    
});
