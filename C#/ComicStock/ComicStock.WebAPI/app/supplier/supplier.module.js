"use strict"
angular
	.module('supplier', [])
	.controller("supController", function() {
		var $ctrl = this;
		$ctrl.message = "No World!"
	})
	.component("supworld", {
		bindings: {
			message: '<'
		},
		template: "<ol><li>{{$ctrl.message}}</li></ol>"
	});
