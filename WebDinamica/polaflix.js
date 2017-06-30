var app=angular.module('inicio',['ngRoute', 'ui.bootstrap']);
// suponemos que tenemos el nombre de usuario en esta variable tras hacer el login
var usuario="pepito";

app.controller('Usuario', function Usuario($scope){
  $scope.user = usuario;
})

app.run(['$anchorScroll', function($anchorScroll) {
    $anchorScroll.yOffset = 50;   // always scroll by 50 extra pixels
  }])
  .controller('headerCtrl', ['$anchorScroll', '$location', '$scope',
    function($anchorScroll, $location, $scope) {
      $scope.gotoAnchor = function(x) {
        var newHash = 'anchor' + x;
        if ($location.hash() !== newHash) {
          // set the $location.hash to `newHash` and
          // $anchorScroll will automatically scroll to it
          $location.hash('anchor' + x);
        } else {
          // call $anchorScroll() explicitly,
          // since $location.hash hasn't changed
          $anchorScroll();
        }
      };
    }
  ]);

app.controller('AppCtrl', function AppCtrl($rootScope, $scope, serviceB, serviceC) {
  $rootScope.currentNavItem = 'Inici';
  $rootScope.searchWord = '';

  $scope.setWord = function(word){
      serviceB.palabra = word;
  };

  $scope.getView = function(){
    if(serviceC.view.localeCompare("AS")){
      return false;
    }
    return true;
  }
});

app.config(function($routeProvider){
      $routeProvider
          .when("/",{
                templateUrl: "PantallaInicio.html",
                controller: "rellenarSerie",
            })
          .when("/PantallaInicio",{
                templateUrl: "PantallaInicio.html",
                controller: "rellenarSerie"
            })
            .when('/VerCargos',{
                templateUrl: 'VerCargos.html',
                controller: "factura",
            })
            .when('/VerSerie',{
                templateUrl: 'VerSerie.html',
                controller: "rellenarVerSerie"
            })
            .when('/Capitulo',{
              templateUrl: 'capitulo.html'
            })
            .when('/AgregarSerie',{
                templateUrl: 'AgregarSerie.html',
                controller: "seguirSeries"
          });
});

app.controller("rellenarSerie", function($scope, $http, serviceC) {
    serviceC.view = "PI";

    $scope.seriesFinalizadas;
			$http( {
        method: 'GET',
        url:'http://localhost:8080/Usuario/'+usuario+'/EspacioPersonal/1/SeriesFinalizadas',
        contentType: 'application/json'
		}).then(function successCallback(response){
      $scope.seriesFinalizadas=response.data;
    },function errorCallback(response){
      series="ERROR";
      console.log("ERROR FINALIZADAS");
    }
  );

  $scope.seriesEmpezadas;
    $http( {
      method: 'GET',
      url:'http://localhost:8080/Usuario/'+usuario+'/EspacioPersonal/1/SeriesEmpezadas',
      contentType: 'application/json'
  }).then(function successCallback(response){
    $scope.seriesEmpezadas=response.data;
  },function errorCallback(response){
    series="ERROR";
    console.log("ERROR EMPEZADAS");
  }
  );

  $scope.seriesPendientes;
    $http( {
      method: 'GET',
      url:'http://localhost:8080/Usuario/'+usuario+'/EspacioPersonal/1/SeriesPendientes',
      contentType: 'application/json'
  }).then(function successCallback(response){
    $scope.seriesPendientes=response.data;
  },function errorCallback(response){
    series="ERROR";
    console.log("ERROR PENDIENTES");
  }
  );
});

app.controller("factura", function($scope, $http, serviceC) {
  serviceC.view = "VC";

  $scope.facturas;
  $scope.facturaActual;
  $scope.idActual;

    $http( {
      method: 'GET',
      url:'http://localhost:8080/Usuario/'+usuario+'/Factura',
      contentType: 'application/json'
  }).then(function successCallback(response){
    $scope.facturas=response.data;
    $scope.idActual=$scope.facturas.length-1;
    $scope.facturaActual=$scope.facturas[$scope.idActual];
  },function errorCallback(response){
    series="ERROR";
    console.log("ERROR FACTURAS");
  }
  );

    $scope.getTotal = function(){
      var total = 0;
      for(var i = 0; i < $scope.facturaActual.capitulosVistos.length; i++){
          var detalle = $scope.facturaActual.capitulosVistos[i].precio;
          total += parseFloat(detalle);
      }
      return total;
   }

   $scope.flechas = function(valor){
     if($scope.idActual+valor>=0 && $scope.idActual+valor<$scope.facturas.length){
       $scope.idActual=parseInt($scope.idActual)+parseInt(valor);
       $scope.facturaActual=$scope.facturas[$scope.idActual];
     }
   }
});

app.controller("rellenarVerSerie", function($scope, $http, service, serviceC) {
  serviceC.view = "VS";
  $scope.capsVistos;
  $http( {
    method: 'GET',
    url:'http://localhost:8080/Usuario/pepito/EspacioPersonal/1/Capitulo',
    contentType: 'application/json'
    }).then(function successCallback(response){
      $scope.capsVistos=response.data;
    },function errorCallback(response){
      console.log("ERROR CAPITULOS");
    }
    );

  $scope.capVisto = function(capitulo){
    var i;
    for(i=0;i<$scope.capsVistos.length;i++){
      if($scope.capsVistos[i].numero==capitulo.numero &&
      $scope.capsVistos[i].nombre.indexOf(capitulo.nombre)!=-1 &&
      $scope.capsVistos[i].enlace.indexOf(capitulo.enlace)!=-1){
        return true;
      }
    }
    return false;
  }

  $scope.serieVerSerie;
  $scope.temporadaElegida;

  $scope.$watch('service.serieElegida', function(){
    $scope.serieVerSerie=service.serieElegida;
  }
  );

  $scope.getTipo = function(){
    return $scope.serieVerSerie.tipo;
  }

  $scope.$watch('service.temporada', function(){
    $scope.temporadaElegida=service.temporada;
  }
  );

  $scope.getTemporada = function(){
    return $scope.serieVerSerie.temporadas[$scope.temporadaElegida-1];
  }

  $scope.flechas = function(valor){
    if($scope.temporadaElegida+valor>0 && $scope.temporadaElegida+valor<=$scope.serieVerSerie.temporadas.length){
      $scope.temporadaElegida=parseInt($scope.temporadaElegida)+parseInt(valor);
    }
  }

  $scope.verCapitulo = function(capitulo){
    $http({
      method : "POST",
      url : 'http://localhost:8080/Usuario/'+usuario+'/verCapitulo/'+capitulo
     }).then(function successCallback(response){
       console.log("Acierto"+response);
     },function errorCallback(response){
       console.log("ERROR"+response);
     })
  }

  $scope.capituloVisto = function(capitulo){
    $http({
      method : 'POST',
      url : 'http://localhost:8080/Usuario/'+usuario+'/EspacioPersonal/1/nuevoCapituloVisto/'+capitulo,
     }).then(function successCallback(response){
       console.log("Acierto"+response);
     },function errorCallback(response){
       console.log("ERROR"+response);
     })
  }
});


app.controller("seguirSeries", function($scope, $http, serviceB, serviceC) {
serviceC.view = "AS";

  $scope.alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".split("");
  $scope.searchFilter = '';
  $scope.word = "";

  $scope.expand = function(x) {
       x.show = !x.show;
    }

  $scope.series;
    $http( {
      method: 'GET',
      url:'http://localhost:8080/Serie/',
      contentType: 'application/json'
  }).then(function successCallback(response){
    $scope.series=response.data;
  },function errorCallback(response){
    series="ERROR";
    console.log("ERROR SERIES");
  }
  );

  $scope.setLetters = function(letter){
      $scope.searchFilter = letter;
  };

  $scope.filterData = function (x) {
     return nameStartsWith(x.nombre, $scope.searchFilter);
   };

   $scope.filterDataText = function (x) {
      return nameStartsWith(x.nombre, serviceB.palabra);
    };

   function nameStartsWith  (fullname, search) {
     if (search === '' || search == null)
       return true;

     if(search.indexOf("0-9")!=-1){
       return !isNaN(fullname.toLowerCase().charAt(0));
     }

     return fullname.toLowerCase().indexOf(search.toLowerCase()) === 0;
   }

   $scope.submitSeriePendiente = function(serie){
     $http({
       method : 'POST',
       url : 'http://localhost:8080/Usuario/'+usuario+'/EspacioPersonal/1/anhadeSeriePend/'+serie,
      }).then(function successCallback(response){
        console.log("Acierto"+response);
      },function errorCallback(response){
        console.log("ERROR"+response);
      })
   }

   $scope.submitSerieSeguir = function(serie){
     $http({
       method : 'POST',
       url : 'http://localhost:8080/Usuario/'+usuario+'/EspacioPersonal/1/anhadeSerieEmp/'+serie,
      }).then(function successCallback(response){
        console.log("Acierto"+response);
      },function errorCallback(response){
        console.log("ERROR"+response);
      })
   }
});


app.controller("verSerieEnlace", function($scope, service) {
  // habría que cambiar la BD y añadir la temporada a capituloVisto para evitar
  // este método
 this.serieEnlaceaux = function(serie, capitulo){
   var i;
   var j;
   for(i=0;i<serie.temporadas.length;i++){
     for(j=0;j<serie.temporadas[i].capitulos.length;j++){
       if(serie.temporadas[i].capitulos[j].numero==capitulo.numero &&
       serie.temporadas[i].capitulos[j].nombre.localeCompare(capitulo.nombre)==0){
         this.serieEnlace(serie,i+1);
         return;
       }
     }
   }
   this.serieEnlace(serie,1);
 }

  this.serieEnlace = function(serie, temporada){
      service.serieElegida = serie;
      service.temporada = temporada;
    };
  });

app.factory('service', function () {
    var service= {
      serieElegida: null,
      temporada: 0
    };
    return service;
});

app.factory('serviceB', function () {
    var serviceB= {
      palabra: null
    };
    return serviceB;
});

app.factory('serviceC', function () {
    var serviceC= {
      view: null
    };
    return serviceC;
});
