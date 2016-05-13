'use strict';

pcaApp.factory('PlayerService', function($resource) {
	return $resource('app/rest/player/:id', {}, {
		paged : {
			url: 'app/rest/player/getPlayersByTeamId',
			method : 'GET',
			isArray: false
		}
	});
});
