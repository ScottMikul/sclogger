bloggApp.directive('postadddir', function() {
  return {
	template: '<input ng-model="addTitle"></input><div>10/30/2016</div><textarea ng-model="addContent"></textarea><button ng-click=add({title:addTitle,content:addContent,date:"10/30/2016"})>Add</button>'
  };
});
bloggApp.controller('addpost',['$scope','$http', function($scope, $http){
	$scope.add = function(data){
        $http.post('/createPost',data);
        $scope.posts.push(data);
	}
}]);