<%@page import="BusinnesLogik.Zahnarzt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="components/header.jsp"%>
<%@ include file="components/bodyErsterTeil.jsp"%>

<h1>Zahnarzt bearbeiten</h1>
<p>Hier können Sie einen Zahnarzt modifizieren.</p>

    <% Zahnarzt zahn = (Zahnarzt) request.getSession().getAttribute("zahnarztBearbeiten");%>

<form class="user" action="SvZahnarztBearbeiten" method="Post">
                                <div class="form-group col">
                                    <div class="col-sm-6 mb-3">
                                        <input type="text" class="form-control form-control-user" id="ausweisnummer" name="ausweisnummer"
                                            placeholder="ausweisnummer" value="<%=zahn.getAusweisnummer()%>">
                                    </div>
                                    <div class="col-sm-6 mb-3">
                                        <input type="text" class="form-control form-control-user" id="zahnarztName" name="name"
                                            placeholder="Name" value="<%=zahn.getName()%>">
                                    </div>
                                    <div class="col-sm-6 mb-3">
                                        <input type="text" class="form-control form-control-user" id="zahnarztNachname" name="nachname"
                                            placeholder="Nachname" value="<%=zahn.getNachname()%>">
                                    </div>
                                    <div class="col-sm-6 mb-3">
                                        <input type="text" class="form-control form-control-user" id="telefon" name="telefon"
                                            placeholder="Telefon" value="<%=zahn.getTelefon()%>">
                                    </div>
                                    <div class="col-sm-6 mb-3">
                                        <input type="text" class="form-control form-control-user" id="adresse" name="adresse"
                                            placeholder="Adresse" value="<%=zahn.getAdresse()%>">
                                    </div>
                                    <div class="col-sm-6 mb-3">
                                        <input type="text" class="form-control form-control-user" id="geburtsdatum" name="geburtsdatum"
                                            placeholder="Geburtsdatum" value="<%=zahn.getFormatiertesDatum()%>">
                                    </div>
                                    <div class="col-sm-6 mb-3">
                                        <input type="text" class="form-control form-control-user" id="fachrichtung" name="fachrichtung"
                                            placeholder="Fachrichtung" value="<%=zahn.getFachrichtung()%>">
                                    </div>
                                <button class="btn btn-primary btn-user btn-block" type="submit">
                                    Modifizierung speichern
                                </button>
                            </form>

<%@ include file="components/bodyFinal.jsp"%>