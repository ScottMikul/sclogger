bloggApp.directive('postupdatedeletedir', function() {
  return {
	template: '<div><h1>{{post.title}}</h1></div><div>{{post.date}}</div><div>{{post.content}}</div><button ng-click="post.edit=true">Update</button><button ng-click=deletepost($index)>Delete</button>'
  };
});
bloggApp.controller('deletepostctr',['$scope', function($scope){
	$scope.deletepost = function(data){
		$scope.posts.splice(data,1);
	}
}]);