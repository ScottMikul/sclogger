var bloggApp = angular.module('BloggApp',[])
bloggApp.controller('Controller',['$scope', function($scope){
	$scope.posts = [{
            title: 'blog post 1',
            date: '10/26/2016',
            content: 'Thank you for looking at the first blog post. here is the first entry.'
          },
          {
            title: 'blog post 2',
            date: '10/27/2016',
            content: 'Thank you for looking at the second blog post. here is the second entry.'
          }
          ];
	$scope.helloworld = "hi there, world";
}]);