'use strict';

pcaApp.factory('UserService', function($resource) {
	return $resource('app/rest/manager/:id', {}, {
		paged : {
			url: 'app/rest/manager/paged',
			method : 'GET',
			isArray: false
		},		
		remove : {
			url: 'app/rest/manager/:id',
			method : 'DELETE'
		}
    });
});
