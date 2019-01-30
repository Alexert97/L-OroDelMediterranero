'use strict';

var gulp = require('gulp');
var conf = require('../../conf');

var $ = require('gulp-load-plugins')({
  pattern: ['gulp-*', 'path-posix'],
  camelize: true
});

function favicon() {
  return gulp.src('./assets/favicon/logo.png')
    .pipe($.favicons({
      icons: {
        android: false,              // Create Android homescreen icon. `boolean`
        appleIcon: false,            // Create Apple touch icons. `boolean` or `{ offset: offsetInPercentage }`
        appleStartup: false,         // Create Apple startup images. `boolean`
        coast: false,      // Create Opera Coast icon with offset 25%. `boolean` or `{ offset: offsetInPercentage }`
        favicons: true,             // Create regular favicons. `boolean`
        firefox: false,              // Create Firefox OS icons. `boolean` or `{ offset: offsetInPercentage }`
        windows: false,              // Create Windows 8 tile icons. `boolean`
        yandex: false                // Create Yandex browser icon. `boolean`
      }
    }))
    .pipe(gulp.dest($.pathPosix.join(conf.paths.dist, 'assets', 'favicon')));
}

exports.favicon = favicon;
