'use strict';

pcaApp.factory('PlayerService', function($resource) {
	return $resource('app/rest/player', {}, {
		get : {
			method : 'GET',
			isArray : false
		},		
	});
});
