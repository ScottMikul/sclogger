bloggApp.directive('postupdatedeletedir', function() {
  return {
	template: '<div><h1>{{post.title}}</h1></div><div>{{post.date}}</div><div>{{post.content}}</div><button ng-click="post.edit=true">Update</button><button ng-click=deletepost($index)>Delete</button>'
  };
});
bloggApp.controller('deletepostctr',['$scope','$http', function($scope, $http){
	$scope.deletepost = function(data){
	    $http.post('/deletePost',$scope.posts[data]).then(function(){$scope.posts.splice(data,1);});
	}
}]);