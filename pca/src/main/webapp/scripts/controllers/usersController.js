'use strict';

pcaApp.controller('UsersController',
		['$scope','$route','UserService',			
			function($scope, $route, UserService) {

				$scope.currentPage = 1;
				$scope.itemsPerPage = 1;
				$scope.maxSize = 15;
				// pagination
				$scope.loadPage = function() {
					UserService.paged({
						page : $scope.currentPage,
						count : $scope.itemsPerPage
					}, function(response) {
						$scope.users = response.content;
						$scope.totalItems = response.totalElements;
					});
				};

				$scope.loadPage();

				$scope.pageChanged = function() {
					$scope.loadPage();
				};
				// pagination ends

				$scope.deleteUser = function(userId) {
					UserService.remove({
						id : userId
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
				$scope.reset = function() {
					$route.reload();
				};
			} ]);
