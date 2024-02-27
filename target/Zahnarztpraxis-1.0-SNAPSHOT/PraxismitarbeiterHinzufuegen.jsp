
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="components/header.jsp"%>
<%@ include file="components/bodyErsterTeil.jsp"%>

<h1>Praxismitarbeiter hinzufügen</h1>
<p>Hier können Sie einen Praxismitarbeiter erstellen.</p>



<form class="user" action="SvPraxismitarbeiter" method="Post">
                                <div class="form-group col">
                                    <div class="col-sm-6 mb-3">
                                        <input type="text" class="form-control form-control-user" id="ausweisnummer" name="ausweisnummer"
                                            placeholder="Ausweisnummer">
                                    </div>
                                    <div class="col-sm-6 mb-3">
                                        <input type="text" class="form-control form-control-user" id="name" name="name"
                                            placeholder="Name">
                                    </div>
                                    <div class="col-sm-6 mb-3">
                                        <input type="text" class="form-control form-control-user" id="nachname" name="nachname"
                                            placeholder="Nachname">
                                    </div>
                                    <div class="col-sm-6 mb-3">
                                        <input type="text" class="form-control form-control-user" id="telefon" name="telefon"
                                            placeholder="Telefon">
                                    </div>
                                    <div class="col-sm-6 mb-3">
                                        <input type="text" class="form-control form-control-user" id="adresse" name="adresse"
                                            placeholder="Adresse">
                                    </div>
                                    <div class="col-sm-6 mb-3">
                                        <input type="text" class="form-control form-control-user" id="geburtsdatum" name="geburtsdatum"
                                            placeholder="Geburtsdatum / Format Beispiel dd-MM-yyyy">
                                    </div>
                                    <div class="col-sm-6 mb-3">
                                        <input type="text" class="form-control form-control-user" id="fachrichtung" name="abteilung"
                                            placeholder="Abteilung">
                                    </div>
                                </div>
                                <button class="btn btn-primary btn-user btn-block" type="submit">
                                    Zahnarzt erstellen
                                </button>
                            </form>

<%@ include file="components/bodyFinal.jsp"%>