bloggApp.directive('postadddir', function() {
  return {
	template: '<input ng-model="addTitle"></input><div>10/30/2016</div><textarea ng-model="addContent"></textarea><button ng-click=addpost({title:addTitle,content:addContent,date:"10/30/2016"})>Add</button>'
  };
});
bloggApp.controller('addpost',['$scope', function($scope, $http){
	$scope.addpost = function(data){
		$scope.posts.push(data);
	}
}]);