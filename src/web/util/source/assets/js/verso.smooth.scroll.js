/* ------------------------------------------------------------------------
 * Verso: hue.smooth.scroll.js
 * Initialises smooth scrolling to ids classes on page
 * ------------------------------------------------------------------------
 * Copyright 2017 Oxygenna LTD
 * ------------------------------------------------------------------------ */

/* global smoothScroll */

jQuery(document).ready(function($) {
    $('body').on('click', '.--o--nav-smooth-scroll', function(event) {
        var link = event.target;

        // Do we have smoothScroll?
        if(undefined === smoothScroll) {
            return;
        }

        // Do we have a hash link?
        if (!link.hash) {
            return;
        }

        // Is it on this page?
        if (window.location.hostname !== link.hostname || link.pathname !== window.location.pathname) {
            return;
        }

        // Get the element to scroll to
        var scrollToMe = $(link.hash);

        // Is the scroll to element on the page?
        if (scrollToMe.length === 0) {
            return;
        }
        // Ok we have a has link and something to go to.  Lets scroll to it...smoothly!
        var options = {};
        var offsetAttr = $(link).attr('data-offset');

        if(undefined !== offsetAttr && offsetAttr !== '') {
            options.offset = offsetAttr;
        }
        smoothScroll.animateScroll(scrollToMe[0], null, options);

        // Prevent regular events.
        event.preventDefault();
        event.stopPropagation();
    });

    /********************
     Smooth Scrolling init
    /*******************/
    smoothScroll.init({
        speed: 500, // Integer. How fast to complete the scroll in milliseconds
        easing: 'easeInOutCubic' // Easing pattern to use
    });

});
