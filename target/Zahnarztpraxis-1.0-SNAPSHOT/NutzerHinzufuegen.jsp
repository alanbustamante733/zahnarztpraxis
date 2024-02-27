<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="components/header.jsp"%>
<%@ include file="components/bodyErsterTeil.jsp"%>

<h1>Nutzer hinzufügen</h1>
<p>Hier können Sie einen Nutzer erstellen.</p>

<form class="user" action="SvNutzer" method="Post">
                                <div class="form-group col">
                                    <div class="col-sm-6 mb-3">
                                        <input type="text" class="form-control form-control-user" id="nutzerName" name="nutzerName"
                                            placeholder="Name">
                                    </div>
                                    <div class="col-sm-6 mb-3">
                                        <input type="password" class="form-control form-control-user" id="passwort" name="passwort"
                                            placeholder="Passwort">
                                    </div>
                                    <div class="col-sm-6 mb-3">
                                        <input type="text" class="form-control form-control-user" id="rolle" name="rolle"
                                            placeholder="Rolle">
                                    </div>
                                <button class="btn btn-primary btn-user btn-block" type="submit">
                                    Nutzer erstellen
                                </button>
                            </form>

<%@ include file="components/bodyFinal.jsp"%>