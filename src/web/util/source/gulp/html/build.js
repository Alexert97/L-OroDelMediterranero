'use strict';

var gulp = require('gulp');
var conf = require('../../conf');
var clean = require('./../shared/clean');
var styles = require('./../shared/styles');
var scripts = require('./../shared/scripts');
var favicon = require('./../shared/favicon');

var $ = require('gulp-load-plugins')({
  pattern: ['gulp-*', 'path-posix', 'del', 'browser-sync', 'nunjucks-render', 'batch-replace']
});

var composer = $.shell.task([
  'composer install',
], {
  cwd: 'html'
});

function nunjucks() {
  return gulp.src($.pathPosix.join(conf.paths.src, '*.html'))
    .pipe($.nunjucksRender({
      path: conf.paths.src,
      inheritExtension: true
    }))
    .pipe($.batchReplace(conf.strings))
    .pipe($.batchReplace([
      ['_VERSION_', conf.versions.html]
    ]))
    .pipe($.jsbeautifier({
      'html': {
        'indent_char': ' ',
        'indent_size': 4,
        'wrap_line_length': 0,
        'unformatted': []
      }
    }))
    .pipe($.jsbeautifier.reporter())
    .pipe(gulp.dest(conf.paths.dist));
}

function mailer() {
  return gulp.src($.pathPosix.join(conf.paths.src, '*.php'))
    .pipe(gulp.dest($.pathPosix.join(conf.paths.dist)));
}

function vendor() {
  return gulp.src(
    [
      'html/vendor/phpmailer/**/*.php'
    ]
  )
    .pipe(gulp.dest($.pathPosix.join(conf.paths.dist, 'vendor')));
}

function images() {
  return gulp.src($.pathPosix.join(conf.paths.src, 'assets', 'images', '**/*.{png,jpg}'))
    .pipe(gulp.dest($.pathPosix.join(conf.paths.dist, 'assets', 'images')));
}

function fonts() {
  return gulp.src('node_modules/font-awesome/fonts/**/*')
    .pipe($.flatten())
    .pipe(gulp.dest($.pathPosix.join(conf.paths.dist, 'assets', 'fonts')));
}

function createDemoBuild(src, dist) {
  gulp.task('build' + conf.separator + src, function(done) {
    conf.paths.dist = $.pathPosix.join(conf.target.dist, dist);
    conf.paths.src = $.pathPosix.join(conf.target.src, src);
    return build(function() {
      done();
    });
  });
}

var fullBuildList = [];

for (var demo in conf.htmlDemos) {
  if (conf.htmlDemos.hasOwnProperty(demo)) {
    createDemoBuild(demo, conf.htmlDemos[demo]);
    fullBuildList.push('build' + conf.separator + demo);
  }
}

var build = gulp.series(
  clean.clean,
  gulp.series(composer, vendor),
  gulp.parallel(
    favicon.favicon,
    fonts,
    images,
    nunjucks,
    mailer,
    styles.stylesMinified,
    scripts.scriptsMinified
  )
);

var buildAll = gulp.series(
  clean.clean,
  fullBuildList
);

exports.nunjucks = nunjucks;
exports.images = images;
exports.build = build;
exports.buildAll = buildAll;

gulp.task('build', buildAll);
