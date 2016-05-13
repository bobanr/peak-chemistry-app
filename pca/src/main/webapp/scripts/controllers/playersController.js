'use strict';

pcaApp.controller('PlayersController', [ '$scope','$rootScope','$routeParams','$translate', 'PlayerService',
		function($scope, $rootScope,$routeParams,$translate, PlayerService) {
	
   
	$scope.id = $routeParams.id;
	$scope.currentPage = 1;
	$scope.itemsPerPage = 10;
	$scope.maxSize = 15;
	// pagination
	$scope.loadPage = function() {
		PlayerService.paged({
			page : $scope.currentPage,
			count : $scope.itemsPerPage,
			teamId:$scope.id
		}, function(response) {
			$scope.players = response.content;
			$scope.totalItems = response.totalElements;
		});
	};

	$scope.loadPage();

	$scope.pageChanged = function() {
		$scope.loadPage();
	};
	// pagination ends

	$scope.deletePlayer = function(playerId) {
		PlayerService.remove({
			id : playerId
		},
         function(value, responseHeaders) {
             $scope.error = null;
             $scope.error1 = null;
             $scope.success = 'OK';
             $scope.loadPage(); 					                 
         },
         function(httpResponse) {
             $scope.success = null;
             $scope.error = null;
             $scope.error1 = null;
             if (httpResponse.status == 409) {
                 $scope.error1 = "ERROR";
             } else {
                 $scope.error = "ERROR";
             }
         });
	};
}]);