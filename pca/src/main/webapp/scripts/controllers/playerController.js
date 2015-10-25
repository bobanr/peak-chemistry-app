'use strict';

pcaApp.controller('PlayerController', [ '$scope','$routeParams','$rootScope','$translate', 'PlayerService',
		function($scope, $routeParams,$rootScope,$translate, PlayerService) {

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
    $scope.savePlayer = function () {
    	PlayerService.save($scope.players,
                function (value, responseHeaders) {
                    $scope.error = null;
                    $scope.success = 'OK';
                    $scope.player = PlayerService.get({id:playerId});
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