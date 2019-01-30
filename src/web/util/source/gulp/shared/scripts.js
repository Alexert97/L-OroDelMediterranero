'use strict';

var gulp = require('gulp');
var conf = require('../../conf');

var $ = require('gulp-load-plugins')({
  pattern: ['gulp-*', 'asset-builder', 'merge-stream', 'path-posix'],
  camelize: true
});

function createScripts(callback) {
  var manifest = $.assetBuilder($.pathPosix.join(conf.paths.src, 'assets', 'manifest.json'));
  var merge = $.mergeStream();
  manifest.forEachDependency('js', function(dep) {
    merge.add(
      gulp.src(dep.globs)
      .pipe($.concat(dep.name))
    );
  });
  if(merge.isEmpty()) {
    callback();
  }
  else {
    return merge
      .pipe($.batchReplace([
        ['--o--', conf.info.cssPrefix]
      ]))
      .pipe(gulp.dest($.pathPosix.join(conf.paths.dist, 'assets', 'js')));
  }
}

function minifyScripts() {
  return gulp.src($.pathPosix.join(conf.paths.dist, 'assets', 'js', '*.js'))
    // rename min.js to .js cos its not really minified. Yet.
    .pipe($.rename(function (path) {
      path.basename = path.basename.replace('.min', '');
    }))
    .pipe(gulp.dest($.pathPosix.join(conf.paths.dist, 'assets', 'js')))
    .pipe($.uglify())
    .pipe($.rename(function (path) {
      path.extname = '.min.js';
    }))
    .pipe(gulp.dest($.pathPosix.join(conf.paths.dist, 'assets', 'js')));
}

exports.scripts = createScripts;
exports.scriptsMinified = gulp.series(createScripts, minifyScripts);
