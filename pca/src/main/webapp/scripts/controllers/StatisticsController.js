'use strict';

pcaApp.controller('StatisticsController', [ '$scope',
		function($scope, CONTEXT) {

	$scope.downloadCSVByName = function() {
		window.open(
				'/app/rest/downloadCSVByName');
	};
	
	$scope.downloadCSVByShirtNumber = function() {
		window.open(
				'/app/rest/downloadCSVByShirtNumber');
	};
	
}]);