'use strict';

pcaApp.controller('PlayersController', [ '$scope','$rootScope','$translate', 'PlayerService',
		function($scope, $rootScope,$translate, PlayerService) {

	$scope.currentPage = 1;
	$scope.itemsPerPage = 10;
	$scope.maxSize = 15;
	// pagination
	$scope.loadPage = function() {
		PlayerService.paged({
			page : $scope.currentPage,
			count : $scope.itemsPerPage
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