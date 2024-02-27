<%@page import="BusinnesLogik.Praxismitarbeiter"%>
<%@page import="BusinnesLogik.Zahnarzt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="components/header.jsp"%>
<%@ include file="components/bodyErsterTeil.jsp"%>

<h1>Zahnarzt bearbeiten</h1>
<p>Hier können Sie einen Zahnarzt modifizieren.</p>

    <% Praxismitarbeiter praxis = (Praxismitarbeiter) request.getSession().getAttribute("prixisMitarbeiterBearbeiten");%>

<form class="user" action="SvPraxismitarbeiterBearbeiten" method="Post">
                                <div class="form-group col">
                                    <div class="col-sm-6 mb-3">
                                        <input type="text" class="form-control form-control-user" id="ausweisnummer" name="ausweisnummer"
                                            placeholder="ausweisnummer" value="<%=praxis.getAusweisnummer()%>">
                                    </div>
                                    <div class="col-sm-6 mb-3">
                                        <input type="text" class="form-control form-control-user" id="zahnarztName" name="name"
                                            placeholder="Name" value="<%=praxis.getName()%>">
                                    </div>
                                    <div class="col-sm-6 mb-3">
                                        <input type="text" class="form-control form-control-user" id="zahnarztNachname" name="nachname"
                                            placeholder="Nachname" value="<%=praxis.getNachname()%>">
                                    </div>
                                    <div class="col-sm-6 mb-3">
                                        <input type="text" class="form-control form-control-user" id="telefon" name="telefon"
                                            placeholder="Telefon" value="<%=praxis.getTelefon()%>">
                                    </div>
                                    <div class="col-sm-6 mb-3">
                                        <input type="text" class="form-control form-control-user" id="adresse" name="adresse"
                                            placeholder="Adresse" value="<%=praxis.getAdresse()%>">
                                    </div>
                                    <div class="col-sm-6 mb-3">
                                        <input type="text" class="form-control form-control-user" id="geburtsdatum" name="geburtsdatum"
                                            placeholder="Geburtsdatum" value="<%=praxis.getFormatiertesDatum()%>">
                                    </div>
                                    <div class="col-sm-6 mb-3">
                                        <input type="text" class="form-control form-control-user" id="abteilung" name="abteilung"
                                            placeholder="Abteilung" value="<%=praxis.getAbteilung()%>">
                                    </div>
                                <button class="btn btn-primary btn-user btn-block" type="submit">
                                    Modifizierung speichern
                                </button>
                            </form>

<%@ include file="components/bodyFinal.jsp"%>