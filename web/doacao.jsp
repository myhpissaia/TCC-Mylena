<!DOCTYPE html>
<html>
    <head>
        <%@include file="/cabecalho.jsp" %>
        <!-- Cadastro(CSS) -->
        <link rel="stylesheet" href="css/cadastro.css" type="text/css">
        <!-- Form(CSS e JavaScript) -->
        <link rel="stylesheet" href="css/form.css" type="text/css">
        <script src="js/form.js"></script>
    </head>
    <body>
        <!-- Menu -->
        <%@include file="/menu-sistema.jsp" %>

        <!-- Principal -->
        <header id="top" class="header">
            <!-- Nosso Cadastro -->
            <div class="container fundo1">
                <div class="row">
                    <div class="col-md-12 fundo2">
                        <div class="form-login" style="margin: 20px;">
                            <form action="ServletDoacao" method="POST">
                                <div class="col-md-6">
                                    <!-- Campos -->
                                    <div class="group">
                                        <input requered name="nome" type="text" value="${usuario.nome}" required>
                                        <span class="highlight"></span>
                                        <span class="bar"></span>
                                        <label>
                                            <i class="material-icons glyphicon glyphicon-user input-ikon"></i>
                                            <span class="span-input">Nome</span>
                                        </label>
                                    </div>
                                    <div class="group">
                                        <input requered name="email" type="text" value="${usuario.email}" required>
                                        <span class="highlight"></span>
                                        <span class="bar"></span>
                                        <label>
                                            <i class="material-icons  glyphicon glyphicon-envelope"></i>
                                            <span class="span-input">Email</span>
                                        </label>
                                    </div>
                                    <div class="group">
                                        <input requered name="ong" type="text" value="${ong.nome}" required>
                                        <span class="highlight"></span>
                                        <span class="bar"></span>
                                        <label>
                                            <i class="material-icons glyphicon glyphicon-home"></i>
                                            <span class="span-input">ONG</span>
                                        </label>
                                    </div>
                                </div>
                                <div class="col-md-6">
                                    <div class="checkbox">
                                        <label>
                                            <input name="alimento" type="checkbox" style="width:3vw; height:3vh;"> <span class="bar" style="font-size: 20px; padding-left: 20px; color: #bbb;">Alimento</span>
                                        </label>
                                    </div>
                                    <div class="checkbox">
                                        <label>
                                            <input name="roupa" type="checkbox" style="width:3vw; height:3vh;"> <span class="bar" style="font-size: 20px; padding-left: 20px; color: #bbb;">Roupa</span>
                                        </label>
                                    </div>
                                    <div class="checkbox">
                                        <label>
                                            <input name="brinquedo" type="checkbox" style="width:3vw; height:3vh;"> <span class="bar" style="font-size: 20px; padding-left: 20px; color: #bbb;">Brinquedo</span>
                                        </label>
                                    </div>
                                    <div class="checkbox">
                                        <label>
                                            <input name="higiene" type="checkbox" style="width:3vw; height:3vh;"> <span class="bar" style="font-size: 20px; padding-left: 20px; color: #bbb;">Higiene</span>
                                        </label>
                                    </div>
                                    <div class="wrapper" style="margin-top: 40px;">
                                        <span class="group-btn">     
                                            <button type="submit" class="btn btn-primary btn-md">Doar<i  class="fa fa-sign-in"></i></button>
                                        </span>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </header>

        <!-- Menu(JavaScript) -->
        <script src="js/menu.js"></script>
    </body>
</html>
