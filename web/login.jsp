<html>
    <head>
        <%@include file="/cabecalho.jsp" %>
        <link rel="stylesheet" href="css/form.css" type="text/css">
        <script src="js/form.js"></script>
        <link href="css/stylish-portfolio.css" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,700,300italic,400italic,700italic" rel="stylesheet" type="text/css">
    </head>
    <body>
        <!-- Navigation -->
        <a id="menu-toggle" href="#" class="btn btn-dark btn-lg toggle"><i class="glyphicon glyphicon-home fa fa-bars"></i></a>
        <nav id="sidebar-wrapper">
            <ul class="sidebar-nav">
                <a id="menu-close" href="#" class="btn btn-light btn-lg pull-right toggle"><i class="glyphicon glyphicon-home fa fa-times">
                    </i></a>
                <li class="sidebar-brand">
                    <a href="index.jsp">Donate Solidarity</a>
                </li>
                <li>
                    <a href="login.jsp">Login</a>
                </li>
                <li>
                    <a href="cadastro.jsp">Cadastro</a>
                </li>
            </ul>
        </nav>

        <!-- Header -->
        <header id="top" class="header">
            <!-- Nosso Login -->
            <div class="container" style="margin-top: 150px; opacity: 0.7;">
                <div class="row">
                    <div class="col-md-offset-5 col-md-3" style="background-color: black; padding: 30px 20px; opacity: 0.9;">
                        <div class="form-login" style="margin: 20px; opacity: 0.8;">
                            <!-- Cada campo -->
                            <div class="group">
                                <input type="text" required>
                                <span class="highlight"></span>
                                <span class="bar"></span>
                                <label><i class="material-icons glyphicon glyphicon-user input-ikon"></i><span class="span-input">Usuário</span></label>
                            </div>
                            <div class="group">
                                <input type="text" required>
                                <span class="highlight"></span>
                                <span class="bar"></span>
                                <label><i class="material-icons glyphicon glyphicon-info-sign input-ikon"></i><span class="span-input">Senha</span></label>
                            </div>
                            <div class="wrapper">
                                <span class="group-btn">     
                                    <a href="#" class="btn btn-primary btn-md">Login<i class="fa fa-sign-in"></i></a>
                                </span>
                            </div>
                        </div>

                    </div>
                </div>
            </div>
        </header>



        <!-- Custom Theme JavaScript -->
        <script>
            // Closes the sidebar menu
            $("#menu-close").click(function (e) {
                e.preventDefault();
                $("#sidebar-wrapper").toggleClass("active");
            });
            // Opens the sidebar menu
            $("#menu-toggle").click(function (e) {
                e.preventDefault();
                $("#sidebar-wrapper").toggleClass("active");
            });
            // Scrolls to the selected menu item on the page
            $(function () {
                $('a[href*=#]:not([href=#],[data-toggle],[data-target],[data-slide])').click(function () {
                    if (location.pathname.replace(/^\//, '') == this.pathname.replace(/^\//, '') || location.hostname == this.hostname) {
                        var target = $(this.hash);
                        target = target.length ? target : $('[name=' + this.hash.slice(1) + ']');
                        if (target.length) {
                            $('html,body').animate({
                                scrollTop: target.offset().top
                            }, 1000);
                            return false;
                        }
                    }
                });
            });
            //#to-top button appears after scrolling
            var fixed = false;
            $(document).scroll(function () {
                if ($(this).scrollTop() > 250) {
                    if (!fixed) {
                        fixed = true;
                        // $('#to-top').css({position:'fixed', display:'block'});
                        $('#to-top').show("slow", function () {
                            $('#to-top').css({
                                position: 'fixed',
                                display: 'block'
                            });
                        });
                    }
                } else {
                    if (fixed) {
                        fixed = false;
                        $('#to-top').hide("slow", function () {
                            $('#to-top').css({
                                display: 'none'
                            });
                        });
                    }
                }
            });
            // Disable Google Maps scrolling
            // See http://stackoverflow.com/a/25904582/1607849
            // Disable scroll zooming and bind back the click event
            var onMapMouseleaveHandler = function (event) {
                var that = $(this);
                that.on('click', onMapClickHandler);
                that.off('mouseleave', onMapMouseleaveHandler);
                that.find('iframe').css("pointer-events", "none");
            }
            var onMapClickHandler = function (event) {
                var that = $(this);
                // Disable the click handler until the user leaves the map area
                that.off('click', onMapClickHandler);
                // Enable scrolling zoom
                that.find('iframe').css("pointer-events", "auto");
                // Handle the mouse leave event
                that.on('mouseleave', onMapMouseleaveHandler);
            }
            // Enable map zooming with mouse scroll when the user clicks the map
            $('.map').on('click', onMapClickHandler);
        </script>


    </body>
</html>
