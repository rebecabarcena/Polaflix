var valor=0.0;
var divs = document.getElementById('precio').innerHTML;

for(var i = 0; i < divs.length; i++){
   //divs[i].innerHTML 
   valor+=divs[i].innerHTML;
}
// realizamos la suma de los valores y los ponemos en la casilla total
document.getElementById('resultado').innerHTML = valor.toString();

