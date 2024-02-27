<%@page contentType="text/html" pageEncoding="UTF-8"%>
<body id="page-top">

    <!-- Validierung Session -->
    <% HttpSession meinesession = request.getSession();
    String nutzer = (String) request.getSession().getAttribute("nutzer");
    
    if(nutzer==null) {
    response.sendRedirect("ohneLogin.jsp");
        }
        
    %>
    <!-- Page Wrapper -->
    <div id="wrapper">

        <!-- Sidebar -->
        <ul class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion" id="accordionSidebar">

            <!-- Sidebar - Brand -->
            <a class="sidebar-brand d-flex align-items-center justify-content-center" href="index.jsp">
                <div class="sidebar-brand-icon rotate-n-15">
                    <i class="fas fa-regular fa-tooth"></i>
                </div>
                <div class="sidebar-brand-text mx-3">Zahnartzpraxis</div>
            </a>

            <!-- Divider -->
            <hr class="sidebar-divider my-0">

            <!-- Nav Item - Dashboard -->
            <li class="nav-item active">
                <a class="nav-link" href="#">
                    <i class="fas fa-solid fa-bars"></i>
                    <span>Menu</span></a>
            </li>

            <!-- Divider -->
            <hr class="sidebar-divider">

            <!-- Heading -->
            <div class="sidebar-heading">
                Verwaltung
            </div>

            <!-- Nav Item - Pages Collapse Menu -->
            <li class="nav-item">
                <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseTwo"
                    aria-expanded="true" aria-controls="collapseTwo">
                    <i class="fas fa-hospital-user"></i>
                    <span>Zahnartz</span>
                </a>
                <div id="collapseTwo" class="collapse" aria-labelledby="headingTwo" data-parent="#accordionSidebar">
                    <div class="bg-white py-2 collapse-inner rounded">
                        <h6 class="collapse-header">Aktion:</h6>
                        <a class="collapse-item" href="SvZahnarzt">Zahnärzte anzeigen</a>
                        <a class="collapse-item" href="Zahnarzthinzufuegen.jsp">Zahnarzt hinzufügen</a>
                    </div>
                </div>
            </li>

            <!-- Nav Item - Utilities Collapse Menu -->
            <li class="nav-item">
                <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseUtilities"
                    aria-expanded="true" aria-controls="collapseUtilities">
                     <i class="fas fa-solid fa-user"></i>
                    <span>Patienten</span>
                </a>
                <div id="collapseUtilities" class="collapse" aria-labelledby="headingUtilities"
                    data-parent="#accordionSidebar">
                    <div class="bg-white py-2 collapse-inner rounded">
                        <h6 class="collapse-header">Aktion:</h6>
                        <a class="collapse-item" href="">Patienten anzeigen</a>
                        <a class="collapse-item" href="PatientHinzufuegen.jsp">Patient hinzufügen</a>
                    </div>
                </div>
            </li>
            
            <!-- Nav Item - Utilities Collapse Menu -->
            <li class="nav-item">
                <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseTermin"
                    aria-expanded="true" aria-controls="collapseTermin">
                     <i class="fas fa-solid fa-user"></i>
                    <span>Termine</span>
                </a>
                <div id="collapseTermin" class="collapse" aria-labelledby="headingUtilities"
                    data-parent="#accordionSidebar">
                    <div class="bg-white py-2 collapse-inner rounded">
                        <h6 class="collapse-header">Aktion:</h6>
                        <a class="collapse-item" href="">Termine anzeigen</a>
                        <a class="collapse-item" href="SvTermin">Termin hinzufügen</a>
                    </div>
                </div>
            </li>
            
            <!-- Primer menú desplegable - Praxismitarbeiter -->
            <li class="nav-item">
                <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapsePraxismitarbeiter"
                    aria-expanded="true" aria-controls="collapsePraxismitarbeiter">
                    <i class="fas fa-solid fa-user-friends"></i>
                    <span>Praxismitarbeiter</span>
                </a>
                <div id="collapsePraxismitarbeiter" class="collapse" aria-labelledby="headingPraxismitarbeiter"
                    data-parent="#accordionSidebar">
                    <div class="bg-white py-2 collapse-inner rounded">
                        <h6 class="collapse-header">Aktion:</h6>
                        <a class="collapse-item" href="SvPraxismitarbeiter">Praxismitarbeiter anzeigen</a>
                        <a class="collapse-item" href="PraxismitarbeiterHinzufuegen.jsp">Praxismitarbeiter hinzufügen</a>
                    </div>
                </div>
            </li>
            
            <!-- Nav Item - Utilities Collapse Menu -->
            <li class="nav-item">
                <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseUhrzeit"
                    aria-expanded="true" aria-controls="collapseUhrzeit">
                     <i class="fas fa-solid fa-user"></i>
                    <span>Arbeituhrzeit</span>
                </a>
                <div id="collapseUhrzeit" class="collapse" aria-labelledby="headingUtilities"
                    data-parent="#accordionSidebar">
                    <div class="bg-white py-2 collapse-inner rounded">
                        <h6 class="collapse-header">Aktion:</h6>
                        <a class="collapse-item" href="">Arbeituhrzeit anzeigen</a>
                        <a class="collapse-item" href="">Arbeituhrzeit hinzufügen</a>
                    </div>
                </div>
            </li>
            
            <!-- Nav Item - Utilities Collapse Menu -->
            <li class="nav-item">
                <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseUsers"
                    aria-expanded="true" aria-controls="collapseUtilities">
                     <i class="fas fa-solid fa-user"></i>
                    <span>Nutzer</span>
                </a>
                <div id="collapseUsers" class="collapse" aria-labelledby="headingUtilities"
                    data-parent="#accordionSidebar">
                    <div class="bg-white py-2 collapse-inner rounded">
                        <h6 class="collapse-header">Aktion:</h6>
                        <a class="collapse-item" href="SvNutzer">Nutzer anzeigen</a>
                        <a class="collapse-item" href="NutzerHinzufuegen.jsp">Nutzer hinzufügen</a>
                    </div>
                </div>
            </li>

            <!-- Divider -->
            <hr class="sidebar-divider">

           

        </ul>
        <!-- End of Sidebar -->

        <!-- Content Wrapper -->
        <div id="content-wrapper" class="d-flex flex-column">

            <!-- Main Content -->
            <div id="content">

                <!-- Topbar -->
                <nav class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">

                    <!-- Sidebar Toggle (Topbar) -->
                    <button id="sidebarToggleTop" class="btn btn-link d-md-none rounded-circle mr-3">
                        <i class="fa fa-bars"></i>
                    </button>

                     

                    <!-- Topbar Navbar -->
                    <ul class="navbar-nav ml-auto">

                        

                        <!-- Nav Item - User Information -->
                        <li class="nav-item dropdown no-arrow">
                            <a class="nav-link dropdown-toggle" href="#" id="userDropdown" role="button"
                                data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                <span class="mr-2 d-none d-lg-inline text-gray-600 small"><%=request.getSession().getAttribute("nutzer")%></span>
                                <img class="img-profile rounded-circle"
                                    src="img/undraw_profile.svg">
                            </a>
                            <!-- Dropdown - User Information -->
                            <div class="dropdown-menu dropdown-menu-right shadow animated--grow-in"
                                aria-labelledby="userDropdown">
                                <a class="dropdown-item" href="#">
                                    <i class="fas fa-user fa-sm fa-fw mr-2 text-gray-400"></i>
                                    Profile
                                </a>
                                <a class="dropdown-item" href="#">
                                    <i class="fas fa-cogs fa-sm fa-fw mr-2 text-gray-400"></i>
                                    Settings
                                </a>
                                <a class="dropdown-item" href="#">
                                    <i class="fas fa-list fa-sm fa-fw mr-2 text-gray-400"></i>
                                    Activity Log
                                </a>
                                <div class="dropdown-divider"></div>
                                <a class="dropdown-item" href="#" data-toggle="modal" data-target="#logoutModal">
                                    <i class="fas fa-sign-out-alt fa-sm fa-fw mr-2 text-gray-400"></i>
                                    Logout
                                </a>
                            </div>
                        </li>

                    </ul>

                </nav>
                <!-- End of Topbar -->

                <!-- Begin Page Content -->
                <div class="container-fluid">

                    <!-- Page Heading -->
                    <div class="d-sm-flex align-items-center justify-content-between mb-4">
                        <h1 class="h3 mb-0 text-gray-800">Zahnarztpraxis</h1>
                        
                    </div>
