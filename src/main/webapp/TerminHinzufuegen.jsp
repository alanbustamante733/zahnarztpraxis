<%@page import="BusinnesLogik.Zahnarzt"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="components/header.jsp"%>
<%@ include file="components/bodyErsterTeil.jsp"%>

<h1>Nutzer hinzufügen</h1>
<p>Hier können Sie einen Nutzer erstellen.</p>


                                <div class="form-group col">
                                    <div class="col-sm-6 mb-3">
                                        
                                        <form class="user" action="SvTerminPatientSuchen" method="Post">
                                        <input type="text" class="form-control form-control-user" id="patientSuche" name="patientSuche"
                                            placeholder="patient">
                                        </form>
<form class="user" action="SvTermin" method="Post">
                                        <select name="selectedPatient" id="selectedfPatient">
                                            <option value="">-</option>
                                            <option value="">Albert</option>
                                            <option value="">Olbert</option>
                                        </select>
                                            
                                            
                                    </div>
                                    <%
                                       List<Zahnarzt> zahnaerzteListe = (List)request.getSession().getAttribute("zahnaerzteListeTermin");
                                    %>
                                    <div class="col-sm-6 mb-3">
                                        <select name="selectedZahnarzt" id="selectedZahnarzt" >
                                            <% for(Zahnarzt zahn : zahnaerzteListe) { %>
                                                <option value="<%= zahn.getId() %>"><%= zahn.getName() %> <%= zahn.getNachname() %></option>
                                            <% } %>
                                        </select>
                                    </div>
                                    <div class="col-sm-6 mb-3">
                                        <input type="text" class="form-control form-control-user" id="terminDatum" name="terminDatum"
                                            placeholder="terminDatum">
                                    </div>
                                    <div class="col-sm-6 mb-3">
                                        <input type="text" class="form-control form-control-user" id="terminUhrzeit" name="terminUhrzeit"
                                            placeholder="terminUhrzeit">
                                    </div>
                                    <div class="col-sm-6 mb-3">
                                        <input type="text" class="form-control form-control-user" id="erkrankung" name="erkrankung"
                                            placeholder="erkrankung">
                                    </div>
                                <button class="btn btn-primary btn-user btn-block" type="submit">
                                    Nutzer erstellen
                                </button>
                            </form>

<%@ include file="components/bodyFinal.jsp"%>