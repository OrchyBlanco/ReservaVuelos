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
    //$('#campoFechaIni').datepicker();
    var fechaFin = $("#campoFechaFin").find("input");
    var fechaIni = $("#campoFechaIni").find("input");
    reservar = new ReservaVuelos();

})
