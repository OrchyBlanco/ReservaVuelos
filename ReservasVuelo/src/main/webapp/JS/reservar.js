var reservar = null;
window.addEventListener("DOMContentLoaded", function() {
    toastr.options = {
        "closeButton": false,
        "debug": false,
        "newestOnTop": false,
        "progressBar": false,
        "positionClass": "toast-top-right",
        "preventDuplicates": false,
        "onclick": null,
        "showDuration": "10",
        "hideDuration": "10",
        "timeOut": "1000",
        "extendedTimeOut": "1000",
        "showEasing": "swing",
        "hideEasing": "linear",
        "showMethod": "fadeIn",
        "hideMethod": "fadeOut"
    }
    reservar = new ReservaVuelos();
    $.getJSON("JS/Datos.json", function(datos) {
      that.fechas(datos.DatosReservaVuelos.fechaEspanol);
    })
    var fechaFin = $("#campoFechaFin").find("input");
    var fechaIni = $("#campoFechaIni").find("input");
    var botonSub = $("#botonSubmit");
    var idiomas = $("#idiomas").find("a").click(function(ev){
        reservar.crearFechas(ev);
    })
    botonSub.click(function(){
      reservar.enviarDatos();
    });

})