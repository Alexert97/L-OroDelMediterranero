'use strict';

var gulp = require('gulp');
var conf = require('../../conf');
var build = require('./build');
var styles = require('../shared/styles');
var scripts = require('../shared/scripts');

var $ = require('gulp-load-plugins')({
  pattern: ['gulp-*', 'path-posix', 'del', 'browser-sync', 'nunjucks-render', 'batch-replace']
});

function setPathDist(done) {
  conf.paths.dist = '.server';
  done();
}

function setTargetDist(done) {
  conf.target.dist = '.server';
  done();
}

function browser() {
  $.browserSync({
    notify: false,
    port: 9001,
    server: {
      baseDir: ['.server'],
      index: 'index.html'
    }
  });

  gulp.watch([
    '.server/**/*.html',
    '.server/**/*.php',
    '.server/**/*.js',
    '.server/**/*.{jpg,png}'
  ], {
    delay: 500
  }, function(callback) {
    $.browserSync.reload();
    callback();
  });
}

function createDemoServe(src) {
  gulp.task('serve' + conf.separator + src, function() {
    conf.paths.src = $.pathPosix.join(conf.paths.src, src);

    // watch styles (assets/ and current demo)
    gulp.watch('assets/scss/**/*.scss', styles.styles);
    gulp.watch($.pathPosix.join(conf.paths.src, 'assets', 'scss', '**/*.scss'), styles.styles);
    // watch scripts (assets/ and current demo)
    gulp.watch('assets/js/*.js', scripts.scripts);
    gulp.watch($.pathPosix.join(conf.paths.src, 'assets', 'js', '**/*.js'), scripts.scripts);
    // watch images
    gulp.watch($.pathPosix.join(conf.paths.src, 'assets', 'images', '**/*.{jpg,png}'), build.images);
    // watch HTML
    gulp.watch($.pathPosix.join(conf.paths.src, '**/*.html'), build.nunjucks);
    // watch manifest
    gulp.watch($.pathPosix.join(conf.paths.src, 'assets', 'manifest.json'), gulp.parallel(styles.styles, scripts.scripts));

    return serve();
  });
}

for (var demo in conf.htmlDemos) {
  if (conf.htmlDemos.hasOwnProperty(demo)) {
    createDemoServe(demo);
  }
}

var serve = gulp.series(setPathDist, build.build, browser);
var serveAll = gulp.series(setTargetDist, build.buildAll, browser);

gulp.task('serve', serveAll);
