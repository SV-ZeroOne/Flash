"use strict"
angular
	.module('supplier', [])
	.controller("supController", function() {
		var $ctrl = this;
        $ctrl.message = "No World!";
    })
	.component("supworld", {
		bindings: {
			message: '<'
		},
		template: "<ol><li>{{$ctrl.message}}</li></ol>"
	});




//angular.module('admin.ResourceManager')
//   .service('SupplierResource', function ($http) {
//       var $supplierResource = this;

//       $supplierResource.getAll = function ($ctrl, filter) {
//           if (!filter) {
//               filter = {};
//           }

//           $http
//               .get('http://admin.square-eyes.co.za:1918/api/Supplier', {
//                   params: filter
//               })
//               .then(function (response) {
//                   $ctrl.suppliers = response.data;
//               })
//               .catch(function (data, status) {
//                   alert("Error");
//               });
//       };

//       $supplierResource.get = function (id) {
//           console.log("supplierResource - Get called " + id);
//       };