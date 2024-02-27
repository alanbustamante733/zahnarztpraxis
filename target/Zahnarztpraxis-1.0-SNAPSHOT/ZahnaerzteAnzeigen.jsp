<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="BusinnesLogik.Zahnarzt"%>
<%@page import="BusinnesLogik.Nutzer"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="components/header.jsp"%>
<%@ include file="components/bodyErsterTeil.jsp"%>


        <!-- Begin Page Content -->
                <div class="container-fluid">

                    <!-- Page Heading -->
                    <h1 class="h3 mb-2 text-gray-800">Zahnärzte anzeigen</h1>
                    <p class="mb-4">Hier können sie die gesamte Liste von Zahnärzte ansehen</p>
        
        <!-- DataTales Example -->
                    <div class="card shadow mb-4">
                        <div class="card-header py-3">
                            <h6 class="m-0 font-weight-bold text-primary">Zahnarzt</h6>
                        </div>
                        <div class="card-body">
                            <div class="table-responsive">
                                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                    <thead>
                                        <tr>
                                            <th>Ausweisnummer</th>
                                            <th>Name</th>
                                            <th>Nachame</th>
                                            <th>Telefon</th>
                                            <th>Adresse</th>
                                            <th>Geburstsdatum</th>
                                            <th>Fachrichtung</th>
                                            <th style="width: 210px">Action</th>
                                        </tr>
                                    </thead>
                                    <tfoot>
                                        <tr>
                                            <th>Ausweisnummer</th>
                                            <th>Name</th>
                                            <th>Nachame</th>
                                            <th>Telefon</th>
                                            <th>Adresse</th>
                                            <th>Geburstsdatum</th>
                                            <th>Fachrichtung</th>
                                            <th style="width: 210px">Action</th>
                                        </tr>
                                    </tfoot>
                                         
                                    <%
                                       List<Zahnarzt> zahnaerzteListe = (List)request.getSession().getAttribute("zahnaerzteListe");
                                    %>
                                    
                                    <tbody>
                                        <% for (Zahnarzt zahn : zahnaerzteListe) {%>
                                        <tr>
                                            <% 
                                                SimpleDateFormat formatDesDatum = new SimpleDateFormat("dd-MM-yyyy");
                                                Date datum = zahn.getGeburtsdatum();
                                                String formatiertesDatum = formatDesDatum.format(datum);     
                                            %>
                                            <td><%=zahn.getAusweisnummer()%></td>
                                            <td><%=zahn.getName()%></td>
                                            <td><%=zahn.getNachname()%></td>
                                            <td><%=zahn.getTelefon()%></td>
                                            <td><%=zahn.getAdresse()%></td>
                                            <td><%=formatiertesDatum%></td>
                                            <td><%=zahn.getFachrichtung()%></td>
                                        </tr>
                                        
                                        <td style="display: flex; width: 230px;">
                                                <form name="löschen" action="SvZahnarztLoeschen" method="POST">
                                                    <button type="submit" class="btn btn-primary btn-user btn-block" style="background-color:red; margin-right: 5px; ">
                                                        <i class="fas fa-trash-alt"></i> Löschen
                                                    </button>
                                                    <input type="hidden" name="id" value="<%=zahn.getId()%>">
                                                </form>
                                                <form name="bearbeiten" action="SvZahnarztBearbeiten" method="GET">
                                                    <button type="submit" class="btn btn-primary btn-user btn-block" style="margin-right: 5px; ">
                                                        <i class="fas fa-trash-alt"></i> Bearbeiten
                                                    </button>
                                                    <input type="hidden" name="id" value="<%=zahn.getId()%>">
                                                </form>
                                        </td>
                                        
                                        <% }%>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>

                </div>
                <!-- /.container-fluid -->

            </div>
            <!-- End of Main Content -->
            

        
<%@ include file="components/bodyFinal.jsp"%>