define([
  'angular',
  'angular-rest'
], function (ng, Restangular) {
  'use strict';
  ng.module('library')
  	.controller('BooksCtrl', function ($scope) {
  		$scope.books = Restangular.all('books').getList();
  		$scope.refresh = function() {
	  		$scope.books = Restangular.all('books').getList();
  		};
  	});
});