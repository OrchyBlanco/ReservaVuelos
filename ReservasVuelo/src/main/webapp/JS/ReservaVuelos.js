/*
 Author: Adrián Morales Martín
 11/02/2017
 
 ReservaVuelos V.2
 */

var ReservaVuelos = function () {
    that = this;
    this.idioma = "es";
}
/*
 Funcion que carga el objeto según el idioma que el usuario haya escogido
 y se lo pasa a la función fecha (1=Español , 2=Ingles , 3=Valenciano)
 */
ReservaVuelos.prototype.crearFechas = function (ev) {
    if (ev.target.tagName == "a") {
        $.getJSON("JS/Datos.json", function (datos) {
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
ReservaVuelos.prototype.validarCosteMaximo = function (campo) {
    if (campo.val() != undefined) {
        if (/\d/.test(campo.val())) {
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
ReservaVuelos.prototype.validarHoraLlegada = function (campo) {
    if (campo.val() != undefined || campo.val() == "") {
        if (/\d/.test(campo.val())) {
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
ReservaVuelos.prototype.validarHoraSalida = function (campo, campo2) {
    if (campo.val() != undefined) {
        if (/\d/.test(campo.val()) && /\d/.test(campo2.val())) {
            return true;
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
ReservaVuelos.prototype.validarFecha = function (campo) {
    var valor = campo.value;
    if (campo.val() != undefined) {
        valor = campo.val()
    }
    if (this.idioma == "en") {
        //Si el idioma es inglés, el formato será yyyy/mm/dd;
        var exp = /^[0-9]{4}\-(0[1-9]|1[012])\-(0[1-9]|[12][0-9]|3[01])/
        if (exp.test(valor)) {
            return true;
        }
        return false;
    } else {
        //Si el idioma no es inglés, el formato será dd/mm/yyyy;
        var exp = /^(\d+)(-|\/)(\d+)(?:-|\/)(?:(\d+)\s+(\d+):(\d+)(?::(\d+))?(?:\.(\d+))?)?/
        if (exp.test(valor)) {
            return true;
        }
        return false;
    }
}
//Crea los DatePickers
ReservaVuelos.prototype.fechas = function (options) {
    var fechaFin = $("#campoFechaFin").find("input");
    var fechaIni = $("#campoFechaIni").find("input");
    //Elimina los datepickers de los campos fecha para volver a crearlos con el nuevo objeto options
    fechaIni.datepicker("destroy");
    fechaFin.datepicker("destroy");
    fechaIni.datepicker(options);
    fechaFin.datepicker(options);
}
//Al revisar que todos los datos sean validados, se prosigue a mostrar los vuelos
ReservaVuelos.prototype.enviarDatos = function () {
    var error = "";
    var costeMax = $("#precioMaximo");
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
        error += "Hay un error en el campo hora salida<br>";
    }
    /*    if (this.validarFecha(campoFechaIni) == false) {
     error += "Hay un error en el campo fecha inicio<br>";
     }
     if (this.validarFecha(campoFechaFin) == false) {
     error += "Hay un error en el campo fecha fin<br>";
     }*/
    //No mostrar errores
    if (error == "") {
        toastr.success("La busqueda ha sido resuelta")
        //Actualiza la vista de vuelos o la crea
        this.actualizarVuelosGenericos();
    }
    //Mostrar errores
    else {
        toastr.error(error)
    }

}
//Función que oculta el formulario n1 con una animación
ReservaVuelos.prototype.hideShowForm = function () {
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
//Función que recoge los datos de la pagina "rest"
//y crea una lista con los objetos con el json que le de la página
ReservaVuelos.prototype.actualizarVuelosGenericos = function () {
    var objParametro= {
        horaSalida:$("#horaSalida").val(),
        horaLlegada:$("#horaLlegada").val(),
        aerolineaId:$("#selectAerolineas").val(),
        precio:$("#precioMaximo").val(),
    }
    console.log(objParametro);
    var that = this;
    $.ajax({
        "url": "PHP/vuelogenerico.php?param="+JSON.stringify(objParametro),
        "type": "get",
        "dataType": "json",
        "success": function (vuelos) {
            console.log(vuelos);
            that.pintarVuelos(vuelos);
        },
        "error": function(er){
            console.log(er.responseText);
            console.log(er);
        }
    });
}
//Mock de vuelos
ReservaVuelos.prototype.vuelosMock = function () {
    var vuelos = [{origen: "Madrid", horaSalida:14, horaLlegada:18, destino: "París", fecha: "22 / 03 / 2017", nVuelo: 3, aerolinea: "Aerolinea1", precio: 520}, {plazasLibres: 23, horaSalida:24, horaLlegada:3, origen: "Albacete", destino: "Lleida", fecha: "26 / 02 / 2017", nVuelo: 1, aerolinea: "Aerolinea1", precio: 875}, {plazasLibres: 120, horaSalida:8, horaLlegada:12, fecha: "12 / 04 / 2017", origen: "Córdoba", destino: "Menorca", nVuelo: 7, aerolinea: "Aerolinea1", precio: 775}]
    this.pintarVuelos(vuelos);
}
//Mock del combo de aerolineas
ReservaVuelos.prototype.comboAerolineasMock = function () {
    var aerolineas = [{aerlonineaId: 1, codigo: "AMR", nombre: "Aerolinea1"}, {aerlonineaId: 2, codigo: "DMR", nombre: "Aerolinea2"}, {aerlonineaId: 3, codigo: "GPT", nombre: "Aerolinea3"}];
    this.pintarSelect(aerolineas);
}
//Mock, No funciona, me devuelve el php entero en error.responseText
ReservaVuelos.prototype.comboAerolineas = function () {
    var that = this;
    $.ajax({
        url: "webresources/aerolinea",
        dataType: "json",
        type: "GET",
        success: function (aerolineas) {
            that.pintarSelect(aerolineas);
        },
        error: function (error) {
            error.responseText;
        }
    });
}

//Pinta el combo con el objeto que le pasen
ReservaVuelos.prototype.pintarSelect = function (aerolineas) {
    var select = $("#selectAerolineas");
    select.empty();

    if (aerolineas.length === 0) {
        console.log("petición al servidor no devuelve nada")
    } else {
        $.each(aerolineas, function (i) {
            select.append('<option value=' + aerolineas[i].aerolineaId + '>' + aerolineas[i].nombre + '</option>')
        })
    }
}

//Pintar una lista vuelos con el objeto que le pasen


ReservaVuelos.prototype.pintarVuelos = function (vuelos) {
    var that = this;
    var tr;
    if (vuelos.length == 0) {
        console.log("No se ha recibido nada");
    } else {
        for(var i = 0; i < vuelos.length ; i++ ){
                tr = $('<tr><td>'+ vuelos[i].nVuelo + '</td>'
                    + "<td>" + vuelos[i].horaSalida + '</td>'
                    + "<td>" + vuelos[i].horaLlegada + '</td>'
                    + "<td>" + vuelos[i].origen + "</td>"
                    + "<td>" + vuelos[i].destino + "</td>"
                    + "<td>" + vuelos[i].aerolinea + "</td>"
                    + "<td>" + vuelos[i].precio + "</td></tr>")
                    console.log(tr)
                    $("#tablaVuelos").find("table").append(tr);
                    console.log(vuelos)
                    console.log(vuelos[i])
                    tr.click(function () {
                        that.dialogReserva($("#reservas").find("form"));
                    });
        }
        
    }
}
//Crea un dialogo con el form que le pases
ReservaVuelos.prototype.dialogReserva = function (form) {
    form.dialog({
        modal: true,
        resizable: false,
        show: {effect: "blind", duration: 800},
        title: "Reservar Vuelo",
        width: 550,
        height: 400,
        position:{ my: "center", at: "center", of: window }

    })
};
