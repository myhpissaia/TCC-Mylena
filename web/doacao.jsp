<html>
    <head>
        <%@include file="/cabecalho.jsp" %>
        <link rel="stylesheet" href="doacao.css" type="text/css">
    </head>
    <body>
        <div class="container">
            <div class="row">
                <div class="col-md-offset-5 col-md-3">
                    <div class="form-login">
                        <br>
                        <input  requered name="nome" type="text" id="userName" class="form-control input-sm chat-input" placeholder="nome" />
                        <br>
                        <input  requered name="sobrenome" type="text" id="userName" class="form-control input-sm chat-input" placeholder="sobrenome" />
                        <br>
                        <input  requered name="doacao" type="text" id="userName" class="form-control input-sm chat-input" placeholder="doação" />
                        <br>
                        <form action="/action_page.php">
                            Data
                            <input type="date" name="Data">
                            <input type="submit">
                        </form>
                        <br> 
                        <button type="submit" class="btn btn-default">Doar</button>
                        <br>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>