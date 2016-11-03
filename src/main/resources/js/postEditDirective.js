bloggApp.directive('posteditdir', function() {
  return {
	template: '<input value="{{post.title}}"></input><div>{{post.date}}</div><textarea ng-model="post.content"></textarea><button ng-click=update(post)>submit</button>'
  };
});
bloggApp.controller('updateentry',['$scope', function($scope){
	$scope.update = function(data){
		data.postdata= data.content;
		data.edit=false;
	}
}]);