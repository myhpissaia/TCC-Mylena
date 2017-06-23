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
        <%@include file="/menu-inicial.jsp" %>

        <!-- Principal -->
        <header id="top" class="header">
            <!-- Nosso Cadastro -->
            <div class="container fundo1">
                <div class="row">
                    <div class="col-md-12 fundo2">
                        <div class="form-login" style="margin: 20px;">
                            <form action="ServletCadastro" method="POST">
                                <div class="col-md-6">
                                    <!-- Campos -->
                                    <div class="group">
                                        <input requered name="nome" type="text" required>
                                        <span class="highlight"></span>
                                        <span class="bar"></span>
                                        <label>
                                            <i class="material-icons glyphicon glyphicon-user input-ikon"></i>
                                            <span class="span-input">Nome</span>
                                        </label>
                                    </div>
                                    <div class="group">
                                        <input requered name="sobrenome" type="text" required>
                                        <span class="highlight"></span>
                                        <span class="bar"></span>
                                        <label>
                                            <i class="material-icons glyphicon glyphicon-user input-ikon"></i>
                                            <span class="span-input">Sobrenome</span>
                                        </label>
                                    </div>
                                    <div class="group">
                                        <input requered name="email" type="text" required>
                                        <span class="highlight"></span>
                                        <span class="bar"></span>
                                        <label>
                                            <i class="material-icons glyphicon glyphicon-envelope"></i>
                                            <span class="span-input">E-mail</span>
                                        </label>
                                    </div>
                                </div>
                                <div class="col-md-6">
                                    <div class="group">
                                        <input requered name="login" type="text" required>
                                        <span class="highlight"></span>
                                        <span class="bar"></span>
                                        <label>
                                            <i class="material-icons glyphicon glyphicon-user input-ikon"></i>
                                            <span class="span-input">Login</span>
                                        </label>
                                    </div>
                                    <div class="group">
                                        <input requered name="senha" type="password" required>
                                        <span class="highlight"></span>
                                        <span class="bar"></span>
                                        <label>
                                            <i class="material-icons glyphicon glyphicon-lock"></i>
                                            <span class="span-input">Senha</span>
                                        </label>
                                    </div>
                                    <div class="group">
                                        <input requered name="consenha" type="password" required>
                                        <span class="highlight"></span>
                                        <span class="bar"></span>
                                        <label>
                                            <i class="material-icons glyphicon glyphicon-lock"></i>
                                            <span class="span-input">Confirmar Senha</span>
                                        </label>
                                    </div>
                                    <div class="wrapper">
                                        <span class="group-btn">     
                                            <button type="submit" class="btn btn-primary btn-md">Cadastrar<i  class="fa fa-sign-in"></i></button>
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
