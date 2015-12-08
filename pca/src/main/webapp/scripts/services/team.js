/**
 * 
 */
'use strict';

pcaApp.factory('TeamService', function($resource) {
	return $resource('app/rest/team/:id', {}, {
		paged : {
			url: 'app/rest/team/paged',
			method : 'GET',
			isArray: false
		},	
		myteams : {
			url: 'app/rest/team/myteams',
			method : 'GET',
			isArray: false
		},	
	});
});