'use strict';

pcaApp.controller('UserController', ['$scope', '$routeParams','$translate', 'UserService',
                                     function ($scope, $routeParams,$translate, UserService) {
	
	var userId = $routeParams.id;
	/*$scope.hidePassword = true;
	if(userId != null) {
		$scope.hidePassword = false;
		$scope.user = UserService.get({id:userId});
	}*/
    
    
    $scope.success = null;
    $scope.error = null;
    $scope.doNotMatch = null;
    $scope.errorUserExists = null;
    $scope.saveUser = function () {
        if ($scope.user.password != $scope.confirmPassword) {
            $scope.doNotMatch = "ERROR";
        } else {
        	if(userId != null) {                         
            	UserService.update($scope.user,
                        function (value, responseHeaders) {
                            $scope.error = null;
                            $scope.errorUserExists = null;
                            $scope.updateSuccess = 'OK';
                            $scope.user = UserService.get({id:userId});
                        },
                        function (httpResponse) {
                            $scope.success = null;
                            if (httpResponse.status === 409) {
                                $scope.error = null;
                                $scope.errorUserExists = "ERROR";
                            } else {
                                $scope.error = "ERROR";
                                $scope.errorUserExists = null;
                            }
                        });
            } else {
            	 $scope.user.langKey = $translate.use();
                 $scope.doNotMatch = null;
            	 UserService.save($scope.user,
                        function (value, responseHeaders) {
                            $scope.error = null;
                            $scope.errorUserExists = null;
                            $scope.success = 'OK';
                        },
                        function (httpResponse) {
                            $scope.success = null;
                            if (httpResponse.status === 409) {
                                $scope.error = null;
                                $scope.errorUserExists = "ERROR";
                            } else {
                                $scope.error = "ERROR";
                                $scope.errorUserExists = null;
                            }
                        });
            }
            
        }
    }
}]);          

