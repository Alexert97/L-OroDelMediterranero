'use strict';

var gulp = require('gulp');
var conf = require('../../conf');

var $ = require('gulp-load-plugins')({
  pattern: ['gulp-*', 'asset-builder', 'merge-stream', 'browser-sync', 'path-posix'],
  camelize: true
});

function createStyles(callback) {
  var manifest = $.assetBuilder($.pathPosix.join(conf.paths.src, 'assets', 'manifest.json'));
  var merge = $.mergeStream();
  manifest.forEachDependency('css', function(dep) {
    merge.add(
      gulp.src(dep.globs)
      .pipe($.if('*.scss', $.sass({
        outputStyle: 'expanded',
        precision: 10,
        includePaths: [
          'node_modules',
          'assets/scss'
        ],
        indentType: 'space',
        indentWidth: 4
      })))
      .pipe($.batchReplace([
        ['--o--', conf.info.cssPrefix]
      ]))
      .pipe($.if('*.css', $.concat(dep.name)))
      .pipe($.autoprefixer({
        browsers: [
          'last 2 versions',
          'ie 10'
        ]
      }))
    );
  });
  if(merge.isEmpty()) {
    callback();
  }
  else {
    return merge
      .pipe(gulp.dest($.pathPosix.join(conf.paths.dist, 'assets', 'css')))
      .pipe($.browserSync.stream());
  }
}

function minifyStyles() {
  return gulp.src($.pathPosix.join(conf.paths.dist, 'assets', 'css', '*.css'))
    .pipe($.rename(function (path) {
      path.basename = path.basename.replace('.min', '');
    }))
    .pipe(gulp.dest($.pathPosix.join(conf.paths.dist, 'assets', 'css')))
    .pipe($.cssnano({
      safe: true,
      minifyFontValues: false,
      discardComments: {
        removeAll: true
      }
    }))
    .pipe($.rename(function (path) {
      path.extname = '.min.css';
    }))
    .pipe(gulp.dest($.pathPosix.join(conf.paths.dist, 'assets', 'css')));
}

function lintStyles() {
  return gulp.src([
    $.pathPosix.join(conf.paths.dist, 'assets', 'css', 'verso.css'),
    '!' + $.pathPosix.join(conf.paths.dist, 'assets', 'css', '*.min.css')
  ])
    .pipe($.csslint('.csslintrc'))
    .pipe($.csslint.formatter());
}

exports.styles = createStyles;
exports.stylesMinified = gulp.series(createStyles, minifyStyles);

gulp.task('lint-styles', lintStyles);
