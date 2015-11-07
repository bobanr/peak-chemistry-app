'use strict';

pcaApp.controller('StatisticsController', [ '$scope','CONTEXT',
		function($scope, CONTEXT) {

	$scope.downloadCSV = function() {
		window.open(CONTEXT.name
				+ '/app/rest/downloadCSV');
	};
	
}]);