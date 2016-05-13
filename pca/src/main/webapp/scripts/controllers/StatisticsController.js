'use strict';

pcaApp.controller('StatisticsController', [ '$scope','TeamService',
		function($scope, TeamService,CONTEXT) {
	
	TeamService.query(function(data) {
    	$scope.teams = data;
    	$scope.team = $scope.teams[0];
    });

	$scope.downloadCSVByName = function(teamId) {
		window.open(
				'/app/rest/downloadCSVByName/'+ teamId);
	};
	
	$scope.downloadCSVByShirtNumber = function(teamId) {
		window.open(
				'/app/rest/downloadCSVByShirtNumber/' + teamId);
	};
	
}]);