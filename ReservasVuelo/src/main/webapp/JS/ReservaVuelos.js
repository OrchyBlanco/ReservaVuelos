/*
Author: Adrián Morales Martín
25/01/2017

ReservaVuelos V.2
*/

var ReservaVuelos = function() {
   that = this;
   this.idioma = "es";
}
/*
Funcion que carga el objeto según el idioma que el usuario haya escogido
y se lo pasa a la función fecha (1=Español , 2=Ingles , 3=Valenciano)
*/
ReservaVuelos.prototype.crearFechas = function(ev) {
  if(ev.target.tagName == "a"){
    $.getJSON("JS/Datos.json", function(datos) {
        if (ev.target.id == "1") {
            that.fechas(datos.DatosReservaVuelos.fechaEspanol);
            this.idioma = "es";
        }
        if (ev.target.id  == "2") {
            that.fechas(datos.DatosReservaVuelos.fechaIngles);
            this.idioma = "en";
        }
        if (ev.target.id  == "3") {
            that.fechas(datos.DatosReservaVuelos.fechaValenciano);
            this.idioma = "va";
        }
    });
  }
}
/*
Funcion que devuelve true tanto si esta vacío como si lo que esté dentro del campo sea numérico
*/
ReservaVuelos.prototype.validarCosteMaximo = function(campo) {
  if(campo.val()!=undefined){
    if(campo.val().test(/\d/)){
      return true;
    }
    else{
      return false;
    }
  }else{
    return true;
  }
}
/*
Funcion que devuelve true tanto si esta vacío como si lo que esté dentro del campo sea numérico
*/
ReservaVuelos.prototype.validarHoraLlegada = function(campo) {
  if(campo.val()!=undefined||campo.val()==""){
    if(campo.val().test(/\d/)){
      return true;
    }
    else{
      return false;
    }
  }else{
    return true;
  }
}
/*
Funcion que devuelve true tanto si esta vacío como si lo que esté dentro del campo sea numérico
*/
ReservaVuelos.prototype.validarHoraSalida = function(campo, campo2) {
  if(campo.val()!=undefined){
    if(campo.val().test(/\d/) && campo2.val().test(/\d/)){
      if(campo2.val()<campo.val()){
        return true;
      }
      else{
        return false;
      }
    }else{
      return false;
    }
  }else{
    return true;
  }
}
/*
Funcion que devuelve true tanto si esta vacío como si lo que esté dentro del campo tenga
un formato adecuado según el idioma que seleccione
*/
ReservaVuelos.prototype.validarFecha = function(campo){
  var valor = campo.value;
  if(campo.val()!=undefined){
      valor = campo.val()
  }
  if(this.idioma=="en"){
    //Si el idioma es inglés, el formato será yyyy/mm/dd;
    var exp = /^[0-9]{4}\-(0[1-9]|1[012])\-(0[1-9]|[12][0-9]|3[01])/
    if(valor.test(exp)){
      return true;
    }
    return false;
  }
  else{
    //Si el idioma no es inglés, el formato será dd/mm/yyyy;
    var exp = /^(\d+)(-|\/)(\d+)(?:-|\/)(?:(\d+)\s+(\d+):(\d+)(?::(\d+))?(?:\.(\d+))?)?/
    if(valor.test(exp)){
      return true;
    }
    return false;
  }
}
ReservaVuelos.prototype.fechas = function(options) {
    //Elimina los datepickers de los campos fecha para volver a crearlos con el nuevo objeto options
    $("#fechaIni").datepicker("destroy");
    $("#fechaFin").datepicker("destroy");
    $("#fechaIni").datepicker(options);
    $("#fechaFin").datepicker(options);
}
ReservaVuelos.prototype.enviarDatos = function(){
  var error="";
  var costeMax = $("#costeMax");
  var horaLlegada = $("#horaLlegada");
  var horaSalida = $("#horaSalida");
  var campoFechaIni = $("#campoFechaIni");
  var campoFechaFin = $("#campoFechaFin");
  if(this.validarCosteMaximo(costeMax)==false){
    error += "Hay un error en el campo costes máximos<br>";
  }else if(this.validarHoraLlegada(horaLlegada)==false){
    error += "Hay un error en el campo hora llegada<br>";
  }else if(this.validarHoraSalida(horaSalida, horaLlegada)==false){
    error += "Hay un error en el campo hora salida<br>";//<---------FALLA
  }else if(this.validarFecha(campoFechaIni)==false){
    error += "Hay un error en el campo fecha inicio<br>";
  }else if(this.validarFecha(campoFechaFin)==false){
    error += "Hay un error en el campo fecha fin<br>";
  }
  if(error==""){
    $("#errors").hide();
    $("#errors").text = error;
    //TO-DO
    //<---Mejorar la manera de informar al usuario de TODOS los errores de una sola pasada
  }
  else{
    $("#errors").show();
    $("#errors").text = error;
  }

}

/*

**************TO***DO*****************

-Mejorar la experiencia del usuario en las validaciones

-Implementar las validaciones para el formulario de
entrada de datos del cliente (nombre, telefono, tarjeta de crédito, etc...)

-Revisar los fallos de las validaciones en cuanto a fechas
(si fecha inicial es mayor que la final)

-Webstorage para guardar el idioma y no tener uno por defecto,
o coger el idioma por defecto desde el navegador (no se reconoce el valenciano)
*/
