bloggApp.directive('postdir', function() {
  return {
	template: '<div><h1>{{post.title}}</h1></div><div>{{post.date}}</div><div>{{post.content}}</div>'
  };
});