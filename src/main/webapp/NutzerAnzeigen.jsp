<%@page import="BusinnesLogik.Nutzer"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="components/header.jsp"%>
<%@ include file="components/bodyErsterTeil.jsp"%>


        <!-- Begin Page Content -->
                <div class="container-fluid">

                    <!-- Page Heading -->
                    <h1 class="h3 mb-2 text-gray-800">Nutzer anzeigen</h1>
                    <p class="mb-4">Hier können sie die gesamte Liste von Nutzern ansehen</p>
        
        <!-- DataTales Example -->
                    <div class="card shadow mb-4">
                        <div class="card-header py-3">
                            <h6 class="m-0 font-weight-bold text-primary">Nutzer</h6>
                        </div>
                        <div class="card-body">
                            <div class="table-responsive">
                                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                    <thead>
                                        <tr>
                                            <th>Id</th>
                                            <th>Nutzer Name</th>
                                            <th>Rolle</th>
                                            <th style="width: 210px">Action</th>
                                        </tr>
                                    </thead>
                                    <tfoot>
                                        <tr>
                                            <th>Id</th>
                                            <th>Nutzer Name</th>
                                            <th>Rolle</th>
                                            <th style="width: 210px">Action</th>
                                        </tr>
                                    </tfoot>
                                    
                                    <%
                                       List<Nutzer> nutzerListe = (List)request.getSession().getAttribute("nutzerListe");
                                    %>
                                    
                                    <tbody>
                                        <% for (Nutzer nutz : nutzerListe) {%>
                                        <tr>
                                            <td><%=nutz.getId_nutzer()%></td>
                                            <td><%=nutz.getNutzerName()%></td>
                                            <td><%=nutz.getRolle()%></td>
                                            
                                            <td style="display: flex; width: 230px;">
                                                <form name="löschen" action="SvNutzerLoeschen" method="POST">
                                                    <button type="submit" class="btn btn-primary btn-user btn-block" style="background-color:red; margin-right: 5px; ">
                                                        <i class="fas fa-trash-alt"></i> Löschen
                                                    </button>
                                                    <input type="hidden" name="id" value="<%=nutz.getId_nutzer()%>">
                                                </form>
                                                <form name="bearbeiten" action="SvNutzerBearbeiten" method="GET">
                                                    <button type="submit" class="btn btn-primary btn-user btn-block" style="margin-right: 5px; ">
                                                        <i class="fas fa-trash-alt"></i> Bearbeiten
                                                    </button>
                                                    <input type="hidden" name="id" value="<%=nutz.getId_nutzer()%>">
                                                </form>
                                            </td>
                                        
                                        </tr>
                                        
                                        <% } %>
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