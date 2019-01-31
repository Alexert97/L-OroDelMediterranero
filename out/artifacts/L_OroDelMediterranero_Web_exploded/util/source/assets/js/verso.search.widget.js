/* ------------------------------------------------------------------------
 * Verso: verso.search.widgetjs
 * Search widget JS
 * ------------------------------------------------------------------------
 * Copyright 2017 Oxygenna LTD
 * ------------------------------------------------------------------------ */


jQuery(document).ready(function($) {
    var mainContainer = $('.--o--content-box'),
        openCtrl = $('.--o--search-widget-button-open'),
        closeCtrl = $('.--o--search-widget-button-close'),
        searchContainer = $('.--o--search-widget-container'),
        inputSearch = $('.--o--search-widget-input');

    function init() {
        initEvents();
    }

    function initEvents() {
        openCtrl.on('click', openSearch);
        closeCtrl.on('click', closeSearch);
        $(document).on('keyup', function(ev) {
            // escape key.
            if(ev.keyCode === 27) {
                console.log('close');
                closeSearch();
            }
        });
    }

    function openSearch(e) {
        mainContainer.addClass('--o--content-box-moved');
        searchContainer.addClass('--o--search-widget-container-open');
        setTimeout(function() {
            inputSearch.focus();
        }, 600);
        e.preventDefault();
    }

    function closeSearch() {
        mainContainer.removeClass('--o--content-box-moved');
        searchContainer.removeClass('--o--search-widget-container-open');
        inputSearch.blur();
        inputSearch.value = '';
    }

    init();

});
