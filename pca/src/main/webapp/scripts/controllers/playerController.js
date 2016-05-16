'use strict';

pcaApp.controller('PlayerController', [ '$scope','$routeParams','$rootScope','$translate', 'PlayerService','TeamService','localStorageService',
		function($scope, $routeParams,$rootScope,$translate, PlayerService,TeamService,localStorageService) {

	$scope.teamID = localStorageService.get("teamID");
	
	if ($routeParams.id) {
		$scope.id = $routeParams.id;
		$scope.player = PlayerService
				.get(
						{
							id : $routeParams.id
						},
						function() {
							var a = 1;
						});
	} 		
	$scope.success = null;
    $scope.error = null;
    $scope.dateOfBorn = new Date();
    $scope.dateOptions = {
        formatYear: 'yy',
        startingDay: 1
    };
    $scope.open = function($event) {
        $event.preventDefault();
        $event.stopPropagation();
        $scope.opened = true;
    };
    
    $scope.bodyColors = [{ id: 0, name: $translate.instant('player.white') },{ id: 1, name: $translate.instant('player.black') }, { id: 3, name: $translate.instant('player.yellow')}];
    $scope.playerBodyColor = $scope.bodyColors[0];
    $scope.bodyColor = $scope.playerBodyColor;
    
    $scope.positionsInTeam = [{ id: 0, name: $translate.instant('player.goalkeeper') },{ id: 1, name: $translate.instant('player.centralDefender') }, { id: 3, name: $translate.instant('player.leftBack')},
    { id: 3, name: $translate.instant('player.rightBack') },{ id: 4, name: $translate.instant('player.defendingMidfielder') }, { id: 5, name: $translate.instant('player.centralMidfielder')},
    { id: 6, name: $translate.instant('player.attackingMidfielder') },{ id: 7, name: $translate.instant('player.wideMidfielders') }, { id: 8, name: $translate.instant('player.wideForward')},
   	{ id: 8, name: $translate.instant('player.centerForward')}];
    $scope.positionInTeam = $scope.positionsInTeam[0];
    $scope.playerPosition = $scope.positionInTeam;
    
   /* TeamService.query(function(data) {
    	$scope.teams = data;
    	$scope.team = $scope.teams[0];
    });*/
    
   
    
    $scope.savePlayer = function () {
    	$scope.player.bodyColor = $scope.bodyColor.name;
    	$scope.player.positionInTeam = $scope.playerPosition.name;
    	$scope.player.dateOfBorn = $scope.dateOfBorn;
    	PlayerService.save($scope.player,
                function (value, responseHeaders) {
                    $scope.error = null;
                    $scope.success = "OK";
                    $scope.player = PlayerService.get({id : $routeParams.id});
                },
                function (httpResponse) {
                    $scope.success = null;
                    if (httpResponse.status === 304 &&
                            httpResponse.data.error && httpResponse.data.error === "Not Modified") {
                        $scope.error = null;
                    } else {
                        $scope.error = "ERROR";
                    }
                });
        }    
}]);