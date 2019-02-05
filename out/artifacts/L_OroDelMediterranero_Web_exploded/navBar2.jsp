<%--
  Created by IntelliJ IDEA.
  User: aleoa
  Date: 01/02/2019
  Time: 11:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="nav-container nav-container--sidebar">
    <div class="nav-sidebar-column bg--dark">
        <div class="text-center text-block">
            <a href="home1.jsp">
                <img alt="logo" class="logo" src="img/logo-tondo.png" />
            </a>
            <p>
                Cosa Aspetti
                <em>Prenotati!!</em>
            </p>
            <hr>
            <p>
                User
            </p>
        </div>
        <hr>
        <div class="text-block">
            <ul class="menu-vertical">
                <li class="dropdown">
                    <span class="dropdown__trigger">Gestione Prenotazioni</span>
                    <div class="dropdown__container">
                        <div class="dropdown__content">
                            <ul class="menu-vertical">
                                <li>
                                    <a href="prenotati.jsp">
                                        Prenota
                                    </a>
                                </li>
                                <li>
                                    <a href="home-construction.html">
                                        Modifica
                                    </a>
                                </li>
                                <li>
                                    <a href="home-construction.html">
                                        Elimina
                                    </a>
                                </li>
                            </ul>
                        </div>
                    </div>
                </li>
                <li>
                    <a href="home-construction.html">
                        Acquista Olio
                    </a>
                </li>
            </ul>
        </div>
        <hr>
        <div>
            <ul class="social-list list-inline list--hover">
                <li>
                    <a href="#">
                        <i class="socicon socicon-google icon icon--xs"></i>
                    </a>
                </li>
                <li>
                    <a href="#">
                        <i class="socicon socicon-twitter icon icon--xs"></i>
                    </a>
                </li>
                <li>
                    <a href="#">
                        <i class="socicon socicon-facebook icon icon--xs"></i>
                    </a>
                </li>
                <li>
                    <a href="#">
                        <i class="socicon socicon-instagram icon icon--xs"></i>
                    </a>
                </li>
            </ul>
            <div>
                        <span class="type--fine-print type--fade">
                            &copy; Copyright
                            <span class="update-year"></span> Medium Rare
                        </span>
            </div>
        </div>
    </div>
    <div class="nav-sidebar-column-toggle visible-xs visible-sm" data-toggle-class=".nav-sidebar-column;active">
        <i class="stack-menu"></i>
    </div>
</div>
