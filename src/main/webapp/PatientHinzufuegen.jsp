
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="components/header.jsp"%>
<%@ include file="components/bodyErsterTeil.jsp"%>

<h1>Patient hinzufügen</h1>
<p>Hier können Sie einen Patient erstellen.</p>



<form class="user" action="SvPatient" method="Post">
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
                                        <input type="text" class="form-control form-control-user" id="istSozialversichert" name="istSozialversichert"
                                            placeholder="ja oder nein">
                                    </div>
                                    <div class="col-sm-6 mb-3">
                                        <input type="text" class="form-control form-control-user" id="istPrivatversichert" name="istPrivatversichert"
                                            placeholder="ja oder nein">
                                    </div>
                                    <div class="col-sm-6 mb-3">
                                        <input type="text" class="form-control form-control-user" id="bluttgruppe" name="bluttgruppe"
                                            placeholder="Bluttgruppe">
                                    </div>
                                    
<h1>Gesetzlicher Vertreter hinzufügen</h1>
<p>Nur ausfüllen, wenn der Patient minderjährig ist</p>
                                    <div class="col-sm-6 mb-3">
                                        <input type="text" class="form-control form-control-user" id="ausweisnummerGesetzlicherVertreter" name="ausweisnummerGesetzlicherVertreter"
                                            placeholder="Ausweisnummer">
                                    </div>
                                    <div class="col-sm-6 mb-3">
                                        <input type="text" class="form-control form-control-user" id="nameGesetzlicherVertreter" name="nameGesetzlicherVertreter"
                                            placeholder="Name">
                                    </div>
                                    <div class="col-sm-6 mb-3">
                                        <input type="text" class="form-control form-control-user" id="nachnameGesetzlicherVertreter" name="nachnameGesetzlicherVertreter"
                                            placeholder="Nachname">
                                    </div>
                                    <div class="col-sm-6 mb-3">
                                        <input type="text" class="form-control form-control-user" id="telefonGesetzlicherVertreter" name="telefonGesetzlicherVertreter"
                                            placeholder="Telefon">
                                    </div>
                                    <div class="col-sm-6 mb-3">
                                        <input type="text" class="form-control form-control-user" id="adresseGesetzlicherVertreter" name="adresseGesetzlicherVertreter"
                                            placeholder="Adresse">
                                    </div>
                                    <div class="col-sm-6 mb-3">
                                        <input type="text" class="form-control form-control-user" id="geburtsdatumGesetzlicherVertreter" name="geburtsdatumGesetzlicherVertreter"
                                            placeholder="Geburtsdatum / Format Beispiel dd-MM-yyyy">
                                    </div>
                                    <div class="col-sm-6 mb-3">
                                        <input type="text" class="form-control form-control-user" id="artDerVerantwortung" name="artDerVerantwortung"
                                            placeholder="ArtderVerantwortung">
                                    </div>
                                </div>
                                <button class="btn btn-primary btn-user btn-block" type="submit">
                                    Zahnarzt erstellen
                                </button>
                            </form>

<%@ include file="components/bodyFinal.jsp"%>
