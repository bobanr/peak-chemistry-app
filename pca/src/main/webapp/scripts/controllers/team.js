/**
 * 
 */
'use strict';

pcaApp.controller('TeamsController', ['$scope','$routeParams','$rootScope','$translate', 'TeamService',
        function($scope, $routeParams,$rootScope,$translate, TeamService){
			$scope.currentPage = 1;
			$scope.itemsPerPage = 10;
			$scope.maxSize = 15;
			// pagination
			$scope.loadPage = function() {
				TeamService.paged({
					page : $scope.currentPage,
					count : $scope.itemsPerPage
				}, function(response) {
					$scope.teams = response.content;
					$scope.totalItems = response.totalElements;
				});
			};
		
			$scope.loadPage();
		
			$scope.pageChanged = function() {
				$scope.loadPage();
			};
			// pagination ends
		}	
]);