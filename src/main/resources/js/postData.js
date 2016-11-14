var bloggApp = angular.module('BloggApp',[])
bloggApp.controller('Controller',['$scope','$http', function($scope,$http){
    $scope.post = "";
    $http.get('/readAll').then(function(data){
        console.log("we got data");
        console.log("the data is"+ data.data[0].content);
        $scope.posts= data.data;
    })

	$scope.helloworld = "hi there, world";
}]);