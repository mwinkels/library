

angular
  .module('library',['restangular'])
  .config(function(RestangularProvider) {
     RestangularProvider.setBaseUrl('api/');
  })
  .controller('BooksCtrl', function ($scope, Restangular) {
    $scope.books=Restangular.all('books').getList();
  });