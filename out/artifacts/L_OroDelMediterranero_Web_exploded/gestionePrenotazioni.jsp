<%--
  Created by IntelliJ IDEA.
  User: aleoa
  Date: 31/01/2019
  Time: 19:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="it">
<head>
    <meta charset="utf-8">
    <title>Nuova prenotazione</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="Site Description Here">
    <link href="css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
    <link href="css/stack-interface.css" rel="stylesheet" type="text/css" media="all" />
    <link href="css/socicon.css" rel="stylesheet" type="text/css" media="all" />
    <link href="css/lightbox.min.css" rel="stylesheet" type="text/css" media="all" />
    <link href="css/flickity.css" rel="stylesheet" type="text/css" media="all" />
    <link href="css/iconsmind.css" rel="stylesheet" type="text/css" media="all" />
    <link href="css/jquery.steps.css" rel="stylesheet" type="text/css" media="all" />
    <link href="css/theme.css" rel="stylesheet" type="text/css" media="all" />
    <link href="css/custom.css" rel="stylesheet" type="text/css" media="all" />
    <link href="css/font-roboto.css" rel="stylesheet" type="text/css" media="all" />
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:200,300,400,400i,500,600,700%7CMerriweather:300,300i" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Roboto:300,400,400i,500,700" rel="stylesheet" />
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous">
    <script src="https://unpkg.com/gijgo@1.9.11/js/gijgo.min.js" type="text/javascript"></script>
    <link href="https://unpkg.com/gijgo@1.9.11/css/gijgo.min.css" rel="stylesheet" type="text/css" />
    <link rel="stylesheet" href="css/bootstrap-datetimepicker.css">
    <link rel="stylesheet" href="css/bootstrap-datetimepicker.min.csss">
    <link rel="stylesheet" href="sample%20in%20bootstrap%20v3">
    <script src="js/bootstrap-datetimepicker.js"></script>
    <script src="js/locales/bootstrap-datetimepicker.it.js"></script>
    <script src="js/bootstrap-datetimepicker.min.js"></script>

    <!--  jQuery -->
    <script type="text/javascript" src="https://code.jquery.com/jquery-1.11.3.min.js"></script>

    <!-- Isolated Version of Bootstrap, not needed if your site already uses Bootstrap -->
    <link rel="stylesheet" href="https://formden.com/static/cdn/bootstrap-iso.css" />

    <!-- Bootstrap Date-Picker Plugin -->
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/js/bootstrap-datepicker.min.js"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/css/bootstrap-datepicker3.css"/>
    <link rel="stylesheet" href="css/jquery.timepicker.css">
    <script src="js/jquery.timepicker.js"></script>
</head>

<body class=" ">
<a id="start"></a>
<%@ include file="navBar.jsp"%>
<div class="main-container">
    <section class="cover height-80 imagebg text-center" data-overlay="2" id="home">
        <div class="background-image-holder">
            <img alt="background" src="img/frantoio-Presicce.jpg" />
        </div>
        <hr>
        <div class="bootstrap-iso">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-md-11 p-5 bg-light border--round ">
                        <table class="border--round table--alternate-row">
                            <thead>
                            <tr>
                                <th>Nome</th>
                                <th>Cogome</th>
                                <th>Data</th>
                                <th>Ora</th>
                                <th>Quantità</th>
                                <th>Util</th>

                            </tr>
                            </thead>
                            <tbody>
                            <tr>
                                <td>Alessandro</td>
                                <td>Rigido</td>
                                <td>13/02/1997</td>
                                <td>13:00</td>
                                <td>15 quintali</td>
                                <td>
                                    <div>
                                        <div class="modal-instance">
                                            <div class="align-content-center p-2">
                                                <button class="btn btn-success modal-trigger ">
                                                    Modifica
                                                </button>
                                            </div>
                                            <div class="modal-container">
                                                <div class="modal-content">
                                                    <section class="imageblock feature-large bg--white border--round ">
                                                        <div class="imageblock__content col-lg-5 col-md-3 pos-left">
                                                            <div class="background-image-holder">
                                                                <img alt="image" src="img/olivo/frantoio1.jpg" />
                                                            </div>
                                                        </div>
                                                        <div class="container">
                                                            <div class="row justify-content-end">
                                                                <div class="col-lg-7">
                                                                    <div class="row justify-content-center">
                                                                        <div class="col-lg-10 col-md-11">
                                                                            <h1 class="text-center">Modifica prenotazione</h1>
                                                                            <hr>
                                                                            <form method="post" action="addPrenotazione">
                                                                                <div class="form-group ">
                                                                                    <label class="control-label text-secondary" for="data">
                                                                                        Data & Ora & Quintali
                                                                                    </label>
                                                                                    <div class="input-group">
                                                                                        <div class="input-group-addon">
                                                                                            <i class="fa fa-calendar p-2 mt-2">
                                                                                            </i>
                                                                                        </div>
                                                                                        <input class="form-control" id="data" name="date" placeholder="DD/MM/YYYY" type="text"/>
                                                                                    </div>
                                                                                </div>
                                                                                <div class="form-group">
                                                                                    <div class='input-group' >
                                                                                        <div class="input-group-addon">
                                                                                            <i class="fa fa-clock-o p-2 mt-2">
                                                                                            </i>
                                                                                        </div>
                                                                                        <input id="datepicker3" type='text' name="ora" class="form-control" />
                                                                                    </div>
                                                                                </div>

                                                                                <div class="form-group">
                                                                                    <div class='input-group' >
                                                                                        <div class="input-group-addon">
                                                                                            <i class="fa fa-balance-scale p-1 mt-2">
                                                                                            </i>
                                                                                        </div>
                                                                                        <input id="quintali" type='number' name="quantita" placeholder="Inserire approssimativamente il peso in quintali" class="form-control" />
                                                                                    </div>
                                                                                </div>
                                                                                <div class="form-group">
                                                                                    <div>
                                                                                        <button class="btn btn-success  text-light" name="submit" type="submit" >
                                                                                            Salva Modifiche
                                                                                        </button>
                                                                                    </div>
                                                                                </div>
                                                                            </form>
                                                                        </div>
                                                                    </div>
                                                                    <!--end of row-->
                                                                </div>
                                                                <!--end of col-->
                                                            </div>
                                                            <!--end of row-->
                                                        </div>
                                                        <!--end of container-->
                                                        <script>
                                                            $('#data').datepicker(function(){
                                                                var date_input=$('input[name="data"]'); //our date input has the name "date"
                                                                var container=$('.bootstrap-iso form').length>0 ? $('.bootstrap-iso form').parent() : "body";
                                                                date_input.datetimepicker({
                                                                    format: 'dd/mm/yyyy',
                                                                    container: container,
                                                                    todayHighlight: true,
                                                                    autoclose: true,
                                                                })
                                                            })
                                                        </script>
                                                        <script>
                                                            $('#datepicker3').timepicker({
                                                                // 12 or 24 hour
                                                                darktheme: true,
                                                            });
                                                        </script>
                                                    </section>
                                                </div>
                                            </div>
                                        </div>
                                        <!--end of row-->

                                        <div class="align-content-center p-2">
                                            <button class="btn btn-danger" data-notification-link="trigger">
                                                Elimina
                                            </button>
                                        </div>

                                    </div>
                                </td>

                            </tr>

                            </tbody>
                        </table>

                    </div>
                </div>
            </div>
        </div>

    </section>
    <div class="notification pos-right pos-bottom col-md-11 col-lg-11 " data-animation="from-bottom" data-notification-link="trigger">
        <div class="boxed boxed--border border--round box-shadow">
            <img alt="avatar" class="image--sm" src="img/olivo/604a0cadf94914c7ee6c6e552e9b4487-curved-check-mark-circle-icon-by-vexels.png" />
            <div class="text-block">
                <h5>Eliminato con successo</h5>
            </div>
        </div>
    </div>

    <%@ include file="footer.jsp"%>
</div>
<!--<div class="loader"></div>-->
<a class="back-to-top inner-link" href="#start" data-scroll-class="100vh:active">
    <i class="stack-interface stack-up-open-big"></i>
</a>
<script src="js/jquery-3.1.1.min.js"></script>
<script src="js/flickity.min.js"></script>
<script src="js/easypiechart.min.js"></script>
<script src="js/parallax.js"></script>
<script src="js/typed.min.js"></script>
<script src="js/datepicker.js"></script>
<script src="js/isotope.min.js"></script>
<script src="js/ytplayer.min.js"></script>
<script src="js/lightbox.min.js"></script>
<script src="js/granim.min.js"></script>
<script src="js/jquery.steps.min.js"></script>
<script src="js/countdown.min.js"></script>
<script src="js/twitterfetcher.min.js"></script>
<script src="js/spectragram.min.js"></script>
<script src="js/smooth-scroll.min.js"></script>
<script src="js/scripts.js"></script>
</body>
</html>
