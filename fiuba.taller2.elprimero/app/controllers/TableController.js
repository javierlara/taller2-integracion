angular.module('fiuba').controller("TableController", function($scope) {
    $scope.tables = [
        {id: "1",
            name: "Test table",
            description: "Test table description",
            date: "03/03/2987",
            type: "list"
        },
        {id: "2",
            name: "Test table 2",
            description: "Test table description 2",
            date: "03/03/2987",
            type: "list"
        },
        {id: "3",
            name: "Test table 3",
            description: "Test table description 3",
            date: "03/03/2987",
            type: "list"
        }

    ];

    $scope.save = function() {
        if ($scope.table && $scope.id === undefined) {
            $scope.tables.push($scope.table);
        } else {
            alert("edit");
        }

    };

});
