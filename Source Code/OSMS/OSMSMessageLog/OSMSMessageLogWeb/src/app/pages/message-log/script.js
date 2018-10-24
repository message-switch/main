var testApp = angular.module('testApp', []);

testApp.controller('testController' , function ($scope, $http) {
    $scope.home = "This is the homepage";
    
    $scope.getRequest = function () {
        console.log("I've been pressed!");  
        //$http.get("http://urlforapi.com/get?name=Elliot")
		$http.get("http://localhost:8080/CAMSAuditREST/rest/CAMSAuditMgmt/searchTransactionName/EDIT_WORKFLOW")
		
            .then(function successCallback(response){
                $scope.response = response;
            }, function errorCallback(response){
                console.log("Unable to perform get request");
            });
    };
    
});