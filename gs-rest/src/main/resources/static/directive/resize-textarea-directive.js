'use strict';

angular.module('myApp.resizeTextarea', [])

.directive('resizeTextarea', function($timeout) {
    return {
        restrict: 'E',
        transclude: true,
        replace: true,
        template: "<textarea placeholder='Drop your comment...'></textarea>",
        link: function (scope, element, attrs) {
            var el = angular.element(element[0]);
            el.css({ 'height': 'auto', 'overflow-y': 'hidden' });
                        
            $timeout(function () {
                el.css('height', element[0].scrollHeight + 'px');
            }, 100);

            el.on('input', function () {
                el.css({ 'height': 'auto', 'overflow-y': 'hidden' });
                el.css('height', element[0].scrollHeight + 'px');
            });
        }
    };
}).$inject = ['$timeout'];