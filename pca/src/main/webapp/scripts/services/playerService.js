'use strict';

pcaApp.factory('PlayerService', function($resource) {
	return $resource('app/rest/player/:id', {}, {
		paged : {
			url: 'app/rest/player/paged',
			method : 'GET',
			isArray: false
		}		
	});
});
