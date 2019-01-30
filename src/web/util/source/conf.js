/**
 *  This file contains the variables used in other gulp files
 *  which defines tasks
 *  By design, we only put there very generic config values
 *  which are used in several places to keep good readability
 *  of the tasks
 */

/**
 *  The main paths of your project handle these with care
 */

var argv = require('minimist')(process.argv.slice(2));

exports.versions = {
  html: '1.2.1',
  wordpress: '1.1.0'
};

exports.info = {
  folderName: 'verso',
  zipName: 'verso',
  frontendTextDomain: 'verso',
  adminTextDomain: 'verso-admin',
  functionPrefix: 'verso_',
  definePrefix: 'VERSO_',
  filterPrefix: 'verso_filter_',
  actionPrefix: 'verso_action_',
  styleHandlePrefix: 'verso-',
  scriptHandlePrefix: 'verso-',
  classPrefix: 'Verso',
  cssPrefix: 'verso-',
  childTheme: 'git@bitbucket.org:oxygenna/verso-child.git'
};

exports.strings = [
  ['_NAME_', 'Verso'],
  ['_SHORT_', 'verso'],
  ['_URI_', 'http://themeforest.net/oxygenna/portfolio'],
  ['_LICENSE-NAME_', 'Themeforest Licence'],
  ['_LICENSE_', 'http://themeforest.net/licenses/standard'],
  ['_COPYRIGHT_', new Date().getFullYear() + ' Oxygenna.com'],
  ['_AUTHOR_', 'Oxygenna'],
  ['_AUTHOR-URI_', 'http://www.oxygenna.com'],
  ['_DESCRIPTION_', 'Beautiful Responsive Multi Purpose Bootstrap 4 WordPress Theme'],
  ['_TAGS_', 'post-formats, theme-options, threaded-comments, featured-images'],
  ['_FRONT-TD_', exports.info.frontendTextDomain],
  ['_ADMIN-TD_', exports.info.adminTextDomain],
  ['_DOCS-URL_', 'http://help.oxygenna.com/wordpress/verso'],
  ['_o_', exports.info.functionPrefix],
  ['_O_', exports.info.definePrefix],
  ['_o-filter_', exports.info.filterPrefix],
  ['_o-action_', exports.info.actionPrefix],
  ['_o-style_', exports.info.styleHandlePrefix],
  ['_o-script_', exports.info.scriptHandlePrefix],
  ['OClass', exports.info.classPrefix],
  ['--o--', exports.info.cssPrefix]
];

exports.plugins = ['verso-plugin'];

exports.target = {
  src: 'html/src',
  dist: argv.wp === true ? '../' + exports.info.folderName : './dist'
};

exports.paths = {
  src: exports.target.src,
  dist: exports.target.dist
};

exports.separator = ':';

// html demos folders src -> dest
exports.htmlDemos = {
  'landing'           : '',
  'landing-funky'     : 'landing-funky',
  'wedding'           : 'wedding',
  'magazine-food'     : 'magazine-food',
  'magazine-pastry'   : 'magazine-pastry',
  'corporate-classic' : 'corporate-classic',
  'corporate-modern'  : 'corporate-modern',
  'blog-travel-winter': 'blog-travel-winter',
  'blog-food'         : 'blog-food',
  'creative-personal' : 'creative-personal',
  'creative-agency'   : 'creative-agency',
  'medical-modern'    : 'medical-modern',
  'church-classic'    : 'church-classic',
  'charity-classic'   : 'charity-classic',
  'education-modern'  : 'education-modern',
  'restaurant-dark'   : 'restaurant-dark',
  'commerce-funky'    : 'commerce-funky',
  'web-agency-minimal': 'web-agency-minimal',
  'coming-soon-dark'  : 'coming-soon-dark',
  'photography-light' : 'photography-light'
}
