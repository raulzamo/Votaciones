<%-- 
    Document   : menu
    Created on : 01-ene-2020, 19:45:45
    Author     : Raul
--%>
            <nav class="navbar navbar-expand-lg">
                <a class="navbar-brand" href="VistaMenu.jsp"><img src="../img/logo.png" alt="Logo"></a>
                <button class="navbar-toggler menuMovil" type="button" data-toggle="collapse" data-target="#navbarNavDropdown"
                        aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarNavDropdown">
                    <ul class="navbar-nav">
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle menuamovil2" href="#" id="navbarDropdownMenuLink" role="button"
                               data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                Votante
                            </a>
                            <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
                               
                                <a class="dropdown-item" href="../ControladorDispatcher?opcion=ListadoCenso">Listado Censo</a>
                                <a class="dropdown-item" href="../ControladorDispatcher?opcion=ModificarVotante">Modificar Votante</a>
                                <a class="dropdown-item" href="../ControladorDispatcher?opcion=BajaVotante">Baja Votante</a>
                            </div>
                        </li>
                        <li class="nav-item dropdown">
                            <a class="nav-link menuamovil2" href="../ControladorDispatcher?opcion=Escrutinio" >
                                Escrutinio
                            </a>
                        </li>
                        <li class="nav-item dropdown">
                            <a class="nav-link menuamovil2" href="../ControladorDispatcher?opcion=Votar" >
                                Votar
                            </a>
                        </li>
                        <li class="nav-item dropdown">
                            <a class="nav-link menuamovil2" href="../ControladorDispatcher?opcion=Electos" >
                                Electos
                            </a>
                        </li>
                        <li class="nav-item dropdown">
                            <a class="nav-link menuamovil2" href="../index.jsp" >
                                Salir
                            </a>
                        </li>
                    </ul>
                </div>
            </nav>