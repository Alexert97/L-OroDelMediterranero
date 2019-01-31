/* ------------------------------------------------------------------------
 * Verso: verso.bootstrao.js
 * Initialises bootstrap components
 * ------------------------------------------------------------------------
 * Copyright 2017 Oxygenna LTD
 * ------------------------------------------------------------------------ */

jQuery(document).ready(function($) {
    /********************
     Bootstrap Tooltips
    /*******************/
    $('[data-toggle="tooltip"]').tooltip();

    /********************
     Bootstrap Popovers
    /*******************/
    $('[data-toggle="popover"]').popover();

    /********************
     Progress Bar Indicator
    /*******************/
    $('.progress').each(function() {
        var progress = $(this);
        var value = progress.find('.progress-bar').attr('aria-valuenow');

        progress.parent().find('.progress-indicator').css('left', value + '%');
    });
});
