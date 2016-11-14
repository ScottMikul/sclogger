var bloggApp = angular.module('BloggApp',[])
bloggApp.controller('Controller',['$scope','$http', function($scope, $http){
    $scope.posts =[];
    $http.get('/postData').then(function (response){
        $scope.posts = response.data;
    });
}]);