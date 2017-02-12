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
    if (ev.target.tagName == "a") {
        $.getJSON("JS/Datos.json", function(datos) {
            if (ev.target.id == "1") {
                that.fechas(datos.DatosReservaVuelos.fechaEspanol);
                this.idioma = "es";
            }
            if (ev.target.id == "2") {
                that.fechas(datos.DatosReservaVuelos.fechaIngles);
                this.idioma = "en";
            }
            if (ev.target.id == "3") {
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
    if (campo.val() != undefined) {
        if (campo.val().test(/\d/)) {
            return true;
        } else {
            return false;
        }
    } else {
        return true;
    }
}
/*
Funcion que devuelve true tanto si esta vacío como si lo que esté dentro del campo sea numérico
*/
ReservaVuelos.prototype.validarHoraLlegada = function(campo) {
    if (campo.val() != undefined || campo.val() == "") {
        if (campo.val().test(/\d/)) {
            return true;
        } else {
            return false;
        }
    } else {
        return true;
    }
}
/*
Funcion que devuelve true tanto si esta vacío como si lo que esté dentro del campo sea numérico
*/
ReservaVuelos.prototype.validarHoraSalida = function(campo, campo2) {
    if (campo.val() != undefined) {
        if (campo.val().test(/\d/) && campo2.val().test(/\d/)) {
            if (campo2.val() < campo.val()) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    } else {
        return true;
    }
}
/*
Funcion que devuelve true tanto si esta vacío como si lo que esté dentro del campo tenga
un formato adecuado según el idioma que seleccione
*/
ReservaVuelos.prototype.validarFecha = function(campo) {
    var valor = campo.value;
    if (campo.val() != undefined) {
        valor = campo.val()
    }
    if (this.idioma == "en") {
        //Si el idioma es inglés, el formato será yyyy/mm/dd;
        var exp = /^[0-9]{4}\-(0[1-9]|1[012])\-(0[1-9]|[12][0-9]|3[01])/
        if (valor.test(exp)) {
            return true;
        }
        return false;
    } else {
        //Si el idioma no es inglés, el formato será dd/mm/yyyy;
        var exp = /^(\d+)(-|\/)(\d+)(?:-|\/)(?:(\d+)\s+(\d+):(\d+)(?::(\d+))?(?:\.(\d+))?)?/
        if (valor.test(exp)) {
            return true;
        }
        return false;
    }
}
//Crea los DatePickers
ReservaVuelos.prototype.fechas = function(options) {
    var fechaFin = $("#campoFechaFin").find("input");
    var fechaIni = $("#campoFechaIni").find("input");
    //Elimina los datepickers de los campos fecha para volver a crearlos con el nuevo objeto options
    fechaIni.datepicker("destroy");
    fechaFin.datepicker("destroy");
    fechaIni.datepicker(options);
    fechaFin.datepicker(options);
}

ReservaVuelos.prototype.enviarDatos = function() {
    var error = "";
    var costeMax = $("#costeMax");
    var horaLlegada = $("#horaLlegada");
    var horaSalida = $("#horaSalida");
    var campoFechaIni = $("#campoFechaIni");
    var campoFechaFin = $("#campoFechaFin");
    if (this.validarCosteMaximo(costeMax) == false) {
        error += "Hay un error en el campo costes máximos<br>";
    }
    if (this.validarHoraLlegada(horaLlegada) == false) {
        error += "Hay un error en el campo hora llegada<br>";
    }
    if (this.validarHoraSalida(horaSalida, horaLlegada) == false) {
        error += "Hay un error en el campo hora salida<br>"; //<---------FALLA
    }
    if (this.validarFecha(campoFechaIni) == false) {
        error += "Hay un error en el campo fecha inicio<br>";
    }
    if (this.validarFecha(campoFechaFin) == false) {
        error += "Hay un error en el campo fecha fin<br>";
    }
    //No mostrar errores
    if (error == "") {
        $("#errors").hide();
        $("#errors").text = error;

        this.actualizarVuelos();
    }
    //Mostrar errores
    else {
        $("#errors").show();
        $("#errors").text = error;
    }

}
//Función que oculta el formulario n1 con una animación
ReservaVuelos.prototype.hideShowForm = function() {
    //j_idt15 es el id del formulario 1
    //buscarVuelo div que contiene el formulario (JESUS)
    if ($("#buscarVuelo").css("display") == "none") {
        $("#buscarVuelo").show("slide", {
            direction: "left"
        }, 1000);
    } else {
        $("#buscarVuelo").hide("slide", {
            direction: "left"
        }, 1000);
    }

}
//Función que recoge los datos de la pagina "webresources/vuelos/"
//y crea una lista con los objetos que le pase la página
ReservaVuelos.prototype.actualizarVuelos = function() {
    $.ajax({
        "url": "rest",
        "type": "get",
        "dataType": "json",
        "success": function(vuelos) {
            //console.log(vuelos);
            if (vuelos.length==0) {

            } else {
                $.each(vuelos, function(i, vuelo) {
                    var li = $('<li/>')
                        .addClass('ui-menu-item')
                        .attr('role', 'menuitem')
                        .appendTo(resultados);
                    var a = $('<a/>')
                        .addClass('ui-all')
                        .text(vuelo.nVuelo + ' ' +
                            vuelo.horaSalida + ' ' +
                            vuelo.horaLlegada + ' ' +
                            vuelo.aeropuertoSalida + ' ' +
                            vuelo.aeropuertoOrigen + ' ' +
                            vuelo.precio + ' ' +
                            vuelo.capacidad + ' ' +
                            vuelo.ordenAsiento)
                        .appendTo(li);
                });
            }
        }
    });
}

ReservaVuelos.prototype.comboAerolineas = function() {
    var select = $("#selectAerolineas");
    $.ajax({
        "url": "rest/vuelosgenericos",
        "type": "get",
        "dataType": "json",
        success: function(aerolineas) {
          if(aerolineas.length==0){

          }
          else{
            $.each(aerolineas, function(i, aerolineas) {
              var item = $('<f:selectItem itemValue='+aerolineas+'/>')
                  .appendTo(select);
            })
          }
        },
        error:function(error){
          error.responseText;
        }
    });
}
