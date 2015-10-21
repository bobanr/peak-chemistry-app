'use strict';

pcaApp.controller('PlayerController', [ '$scope','$rootScope','$translate', 'PlayerService',
		function($scope, $rootScope,$translate, PlayerService) {

	$scope.success = null;
    $scope.error = null;
    $scope.savePlayer = function () {
    	PlayerService.save($scope.players,
                function (value, responseHeaders) {
                    $scope.error = null;
                    $scope.success = 'OK';
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