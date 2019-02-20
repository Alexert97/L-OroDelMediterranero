<%@ page import="java.util.List" %>
<%@ page import="bean.Olio" %>
<%@ page import="java.util.Iterator" %><%--
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
    <title>Shop</title>
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
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.2/css/all.css" integrity="sha384-fnmOCqbTlWIlj8LyTjo7mOUStjsKC4pOpQbqyi7RrhN7udi9RwhKkMHpvLbHG9Sr" crossorigin="anonymous">



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
<%@ include file="navBar2.jsp"%>
<div class="main-container">
    <section class="space--sm">
        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <div class="masonry">
                        <div class="masonry__container row masonry--active" style="position: relative; height: 5894.16px;">
                            <div class="masonry__item col-md-4" style="position: absolute; left: 0px; top: 0px;"></div>
                            <%
                                List<Olio> lista = (List<Olio>) session.getAttribute("listaOlio");
                                Iterator<Olio> i = lista.iterator();
                                while (i.hasNext()) {
                                    Olio o = i.next();
                            %>
                            <!--begin item-->
                            <div class="masonry__item col-md-4" style="position: absolute; left: 0px; top: 0px;">
                                <div class="product boxed boxed--border bg--secondary">
                                    <form method="post" action="addPrenotazione">
                                        <a href="${pageContext.request.contextPath}/addToCarrello?id=<%=o.getId()%>">
                                            <img alt="Image" src="img/olivo/olio%20seconda%20qualità.jpg">
                                        </a>
                                        <a class="block" href="${pageContext.request.contextPath}/addToCarrello?id=<%=o.getId()%>">
                                            <div>
                                                <h5><%=o.getNome()%>, <%=o.getCentilitri()%>cl</h5>
                                                <span> <%=o.getCategoria()%></span>
                                            </div>
                                            <div>
                                                <span class="h4 inline-block">&euro;<%=o.getPrezzo()%></span>
                                            </div>
                                            <div class="form-group">
                                                <div class='input-group' >
                                                    <div class="input-group-addon">
                                                        <i class="fas fa-wine-bottle p-1 mt-2">
                                                        </i>
                                                    </div>
                                                    <input id="quintali" type='number' name="quantita" placeholder="Numero bottiglie" class="form-control" />
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <div>
                                                    <button class="btn btn-success  text-light" name="submit" type="submit" >
                                                        Compra olio
                                                    </button>
                                                </div>
                                            </div>
                                        </a>
                                    </form>
                                </div>
                            </div>
                            <!--end item-->

                            <%
                                }
                            %>
                        </div>
                        <!--end masonry container-->
                    </div>
                    <!--end masonry-->
                </div>
            </div>
            <!--end of row-->
        </div>
        <!--end of container-->
    </section>v
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
