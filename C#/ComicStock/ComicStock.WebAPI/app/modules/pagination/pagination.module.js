angular.module('paginationModule', [])
    .controller('paginationController', function () {

        $ctrl = this;
        $ctrl.pagination = {};
        $ctrl.callback = {};

        $ctrl.pageTo = function (n) {
            $ctrl.callback({page: n});
        }


    })
    .component('pagination', {
        controller: 'paginationController',
        templateUrl: 'app/modules/pagination/pagination.tpl.html',
            bindings: {
                pagination: '=',
                callback: '&'
            }
        });