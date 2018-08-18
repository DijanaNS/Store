var app = angular.module('Store', ['ngRoute']);

app.controller('Ctrl', function($scope, $http, $location){

	var result = $location.search();
	var booksUrl = "/api/books";
	var categoriesUrl = "/api/categories";
	$scope.categories = [];
	$scope.books = [];
	$scope.search = {};
	$scope.search.title = "";
	$scope.search.id = "";
	var getCategories = function () {
		$http.get(categoriesUrl).then(
			function success (res) {
				$scope.categories = res.data;
			}, function error () {
				alert("Error getting categories")
			})
	}
	getCategories();
	var getBooks = function () {
		var config = { params: {}}
		if(result.title != null || result.title != ""){
			config.params.title = result.title;
		}
		if($scope.search.id != ""){
			config.params.id = $scope.search.id;
		}
		$http.get(booksUrl,config).then(
			function success (res) {
				$scope.books = res.data;
				$scope.totalPages = res.headers("totalPages");
			}, function error () {
				alert("Error getting books")
			})
	}
	getBooks();
	$scope.getList = function (id) {
		$scope.search.id = id;
		getBooks();
	}
	$scope.getBooksByCategory = function (id) {
		$http.get(categoriesUrl + "/" + id + "/books").then(
			function success (res) {
				$scope.books = res.data;
			}, function error () {
				alert("Error getting books")
			})
	}
	$scope.detalji = function (id) {
		$location.path("/book/" + id);
	}
});

app.controller('bookCtrl', function($scope, $http, $location, $routeParams){
	$scope.additem = false;
	var bookId = $routeParams.id;
	var baseUrl = "/api/books";
	$scope.book = {};
	var categoriesUrl = "/api/categories";
	$scope.categories = [];
	$scope.books = [];
	var getCategories = function () {
		$http.get(categoriesUrl).then(
			function success (res) {
				$scope.categories = res.data;
			}, function error () {
				alert("Error getting categories")
			})
	}
	getCategories();
	var getBook = function () {
		$http.get(baseUrl + "/" + bookId).then(
			function success (res) {
				$scope.book = res.data;
			}, function error () {
				alert("Error getting data");
			})
	}
	getBook();
	
	$scope.change = function(id) {
		$location.path('/edit/' + id)
	}

	$scope.delete = function (id) {
		$http.delete(baseUrl + "/" + id).then(
			function success () {
				alert("Success")
			}, function error () {
				alert("Error")
			})
	}

	$scope.addToCart = function (bookId) {
		$scope.cart = {};
		$scope.cart.count = 1;
		$scope.cart.bookId = bookId;
		$scope.cart.basketId = sessionStorage.getItem('basket');
		console.log($scope.cart)
		$http.post('/api/baskets/add', $scope.cart).then(
			function success () {
				//alert("Uspesno dodato")
				$scope.additem = true;
			}, function error () {
				console.log("Error adding book into basket");
			})
	}
	
})

app.controller('editCtrl',  function($scope, $http, $location, $routeParams){
	var bookId = $routeParams.id;
	var baseUrl = "/api/books";
	$scope.book = {};
	var getBook = function () {
		$http.get(baseUrl + "/" + bookId).then(
			function success (res) {
				$scope.book = res.data;
			}, function error () {
				alert("Error getting data");
			})
	}
	getBook();

	$scope.edit = function () {
		$http.put(baseUrl + "/" + bookId, $scope.book ).then(
			function success () {
			alert('Success!');
			$location.path('/');

		}, function error () {
			alert("Error getting data");
		})
	}
})

app.controller('regCtrl',  function($scope, $http, $location){
	var userUrl = "/api/users";
	$scope.newUser = {};
	$scope.show = false;
	$scope.greska = false;
	$scope.register = function () {
		$http.post(userUrl, $scope.newUser).then(
			function success (res) {
				$scope.show = true;
			}, function error () {
				$scope.greska = true;
			})
	}
})
app.controller('loginCtrl',  function($scope, $http, $location,$rootScope, $window){
	var userUrl = "/api/users/login";
	$scope.user = {};
	$scope.greska = false;
	$scope.login = function () {
		$http.post(userUrl, $scope.user).then(
			function success (res) {
				sessionStorage.setItem('id', res.data.id);
				sessionStorage.setItem('user', res.data.username);
				sessionStorage.setItem('basket', res.data.basketId)
				//location.reload(true);
				//$location.path('/')
				$window.location.href = "/";
			}, function error () {
				$scope.greska = true;
			})
	}
	
})
app.controller('navCtrl', function($scope, $http, $rootScope){
	$scope.checkSession = sessionStorage.getItem('id');
	$scope.username = sessionStorage.getItem('user')
	
})
app.controller('shoppingCtrl', function($scope, $http){
	var baseUrl = "/api/baskets/"
	$scope.items = {}
	$scope.cart = {};
	$scope.showCard = false;
	$http.get(baseUrl + "cartItems").then(
		function success (res) {
			$scope.items = res.data;
			//getCart();
	}, function error () {
		alert('Something went wrong')
	})

	$scope.buy = function () {
		$http.put(baseUrl + "save").then(
			function success () {
				alert("Uspesno kupljeno")
				$scope.items = {};
				$scope.cart = {};
			}, function error () {
				console.log("Greska")
			})
	}
	$scope.total = function(){
		getCart();
		$scope.showCard = true;
	}
	var getCart = function () {
		$http.get(baseUrl + "shopping").then(
			function success(res) {
				$scope.cart = res.data;
			}, function error() {
				console.log('Error')
			})
	}
	
})
app.config(function($routeProvider) {
	$routeProvider
		.when('/', {
			templateUrl : '/app/html/partial/home.html',
			controller: 'Ctrl'
		})
		.when('/registration', {
			templateUrl : '/app/html/partial/registration.html',
			controller: 'regCtrl'
		})
		.when('/login', {
			templateUrl : '/app/html/partial/login.html',
			controller: 'loginCtrl'
		})
		.when('/shopping', {
			templateUrl : '/app/html/partial/shopping.html',
			controller: 'shoppingCtrl'
		})
		.when('/book/:id', {
			templateUrl : '/app/html/partial/book.html',
			controller: 'bookCtrl'
		})
		.when('/edit/:id', {
			templateUrl : '/app/html/partial/edit.html',
			controller: 'editCtrl'
		})
		.otherwise({
			redirectTo: '/'
		});
});