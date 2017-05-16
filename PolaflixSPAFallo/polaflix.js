var app=angular.module('inicio',['ngRoute']);
app.config(function($routeProvider){
      $routeProvider
          .when("/PantallaInicio",{
                templateUrl: "PantallaInicio.html",
            })
            .when('/VerCargos',{
                templateUrl: 'VerCargos.html',
            })
            .when('/VerSerie',{
                templateUrl: 'VerSerie.html',
            })
            .when('/AgregarSerie',{
                templateUrl: 'AgregarSerie.html',
          });
});
app.controller('inicioController',function($scope){
  console.log("Hi, I am breathing");
});
