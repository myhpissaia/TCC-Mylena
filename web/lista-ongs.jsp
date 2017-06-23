<!-- Lista das ONGs -->
<div class="container" style="margin-top: 40px;">
    <div class="row">
        <%
            for(int i = 0; i < 10; i++) {
        %>
        <div class="col-md-12">
            <a href="#" class="list-group-item" style="border-radius: 0px;">
                <div class="media col-md-3">
                    <figure class="pull-left">
                        <img class="media-object img-rounded img-responsive" style="border-radius: 0px;" src="http://placehold.it/350x250" alt="placehold.it/350x250" >
                    </figure>
                </div>
                <div class="col-md-6">
                    <h3 class="list-group-item-heading" style="color: white;"> Nome da Ong </h3>
                    <p class="list-group-item-text">
                        Descrição da ONG
                    </p>
                    <p class="list-group-item-text">
                        Necessidades: Alimento, Brinquedo.
                    </p>
                </div>
                <div class="col-md-3 text-center">
                    <h2> (41) 8457-9568 </h2>
                    <button type="button" class="btn btn-primary btn-lg btn-block"> Doar </button>
                </div>
            </a>
        </div>
        <%
            }
        %>
    </div>
</div>