<html>
    <head>
        <%@include file="/cabecalho.jsp" %>
        <!-- Login(CSS) -->
        <link rel="stylesheet" href="css/login.css" type="text/css">
        <!-- Form(CSS e JavaScript) -->
        <link rel="stylesheet" href="css/form.css" type="text/css">
        <script src="js/form.js"></script>
    </head>
    <body>
        <!-- Menu -->
        <%@include file="/menu-inicial.jsp" %>

        <!-- Principal -->
        <header id="top" class="header">
            <!-- Nosso Login -->
            <div class="container fundo1">
                <div class="row">
                    <div class="col-md-offset-5 col-md-3 fundo2">
                        <div class="form-login fundo3">
                            <form action="ServletLogin" method="POST">
                                <!-- Campos -->
                                <div class="group">
                                    <input type="text" required name="login">
                                    <span class="highlight"></span>
                                    <span class="bar"></span>
                                    <label>
                                        <i class="material-icons glyphicon glyphicon-user input-ikon"></i>
                                        <span class="span-input">Usuário</span>
                                    </label>
                                </div>
                                <div class="group">
                                    <input type="text" required name="senha">
                                    <span class="highlight"></span>
                                    <span class="bar"></span>
                                    <label>
                                        <i class="material-icons glyphicon glyphicon-lock"></i>
                                        <span class="span-input">Senha</span>
                                    </label>
                                </div>
                                <div class="wrapper">
                                    <span class="group-btn">     
                                        <button type="submit" class="btn btn-primary btn-md">Login<i class="fa fa-sign-in"></i></button>
                                    </span>
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
