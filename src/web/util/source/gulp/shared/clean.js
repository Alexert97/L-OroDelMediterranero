var gulp = require('gulp');
var conf = require('../../conf');

var $ = require('gulp-load-plugins')({
  pattern: ['gulp-*', 'del', 'path-posix'],
  camelize: true
});

function clean() {
  return $.del($.pathPosix.join(conf.paths.dist, '/'), {
    force: true
  });
}

exports.clean = clean;

gulp.task(clean);
