<%@page import="Model.Ong"%>
<%@page import="DAO.OngDAO"%>
<!-- Lista das ONGs -->
<div class="container" style="margin-top: 40px;">

    <div class="row">
        <form action="ServletPesquisa" method="GET">
            <div class="col-md-12">
                <div class="col-md-8">
                    <div class="group">
                        <input requered name="pesquisa" type="text" required>
                        <span class="highlight"></span>
                        <span class="bar"></span>
                        <label>
                            <i class="material-icons glyphicon glyphicon-user input-ikon"></i>
                            <span class="span-input">Digite sua pesquisa</span>
                        </label>
                    </div>
                </div>
                <div class="col-md-2">
                    <div class="wrapper">
                        <span class="group-btn">  
                            <button type="submit" class="btn btn-primary btn-md">Pesquisar<i class="fa fa-sign-in"></i></button>
                        </span>
                    </div>
                </div>
                <div class="col-md-2">
                    <div class="wrapper">
                        <span class="group-btn">  
                            <button type="submit" class="btn btn-primary btn-md">Gerar PDF<i class="fa fa-sign-in"></i></button>
                        </span>
                    </div>
                </div>
            </div>
        </form>
    </div>

    <div class="row">
        <%
            OngDAO dao = new OngDAO();
            for (Ong ong : dao.getOng()) {
        %>
        <div class="col-md-12">
            <a href="ServletOng?id=<%= ong.getId()%>" class="list-group-item" style="border-radius: 0px;">
                <div class="media col-md-3">
                    <figure class="pull-left">
                        <img class="media-object img-rounded img-responsive" style="border-radius: 0px;" src="<%= ong.getFoto()%>" alt="placehold.it/350x250" >
                    </figure>
                </div>
                <div class="col-md-6">
                    <h3 class="list-group-item-heading" style="color: white;"> <%= ong.getNome()%> </h3>
                    <p class="list-group-item-text" style="color: white;">
                        <%= ong.getDescricao()%>
                    </p>
                    <p class="list-group-item-text" style="color: white;">
                        Necessidades: 
                        <%
                            if (ong.isNecAlimento()) {
                                out.print("Alimento ");
                            }
                            if (ong.isNecRoupa()) {
                                out.print("Roupa ");
                            }
                            if (ong.isNecBrinquedo()) {
                                out.print("Brinquedo ");
                            }
                            if (ong.isNecHigiene()) {
                                out.print("Higiene ");
                            }
                        %>
                    </p>
                </div>
                <div class="col-md-3 text-center" style="color: white;">
                    <h3> <%= ong.getEmail()%> </h3>
                    <button type="button" class="btn btn-primary btn-lg btn-block"> Doar </button>
                </div>
            </a>
        </div>
        <%
            }
        %>
    </div>
</div>