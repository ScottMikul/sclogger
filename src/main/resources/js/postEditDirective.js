bloggApp.directive('posteditdir', function() {
  return {
	template: '<input ng-model="post.title"></input><div>{{post.date}}</div><textarea ng-model="post.content"></textarea><button ng-click=update(post)>submit</button>'
  };
});
bloggApp.controller('updateentry',['$scope','$http', function($scope, $http){
	$scope.update = function(data){
	    console.log(data);
	    var update = [data.postdata, {content:data.content,date:data.date,title:data.title}];
	    $http.post('/updatePost',update).then(function(){data.edit=false;});


	}
}]);