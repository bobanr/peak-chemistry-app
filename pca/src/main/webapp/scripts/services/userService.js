'use strict';

pcaApp.factory('UserService', function($resource) {
	return $resource('app/rest/manager', {}, {
		paged : {
			url: 'app/rest/manager/paged',
			method : 'GET',
			isArray: false
		},
		get : {
			url: 'app/rest/manager/:id',
			method : 'GET',
			isArray: false
		},		
		update : {
			url: 'app/rest/manager/update',
			method : 'POST'
		},
		saveManager : {
			url: 'app/rest/manager/saveManager',
			method : 'POST'
		},
		remove : {
			url: 'app/rest/manager/:id',
			method : 'DELETE'
		}
    });
});

