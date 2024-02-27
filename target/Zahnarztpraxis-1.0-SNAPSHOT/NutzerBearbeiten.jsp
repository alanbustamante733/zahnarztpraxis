<%@page import="BusinnesLogik.Nutzer"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="components/header.jsp"%>
<%@ include file="components/bodyErsterTeil.jsp"%>

<h1>Nutzer bearbeiten</h1>
<p>Hier können Sie einen Nutzer modifizieren.</p>

    <% Nutzer nutz = (Nutzer) request.getSession().getAttribute("nutzerBearbeiten");%>

<form class="user" action="SvNutzerBearbeiten" method="Post">
                                <div class="form-group col">
                                    <div class="col-sm-6 mb-3">
                                        <input type="text" class="form-control form-control-user" id="nutzerName" name="nutzerName"
                                            placeholder="Name" value="<%=nutz.getNutzerName()%>">
                                    </div>
                                    <div class="col-sm-6 mb-3">
                                        <input type="password" class="form-control form-control-user" id="passwort" name="passwort"
                                            placeholder="Passwort" value="<%=nutz.getPassword()%>">
                                    </div>
                                    <div class="col-sm-6 mb-3">
                                        <input type="text" class="form-control form-control-user" id="rolle" name="rolle"
                                            placeholder="Rolle" value="<%=nutz.getRolle()%>">
                                </div>
                                <button class="btn btn-primary btn-user btn-block" type="submit">
                                    Modifizierung speichern
                                </button>
                            </form>

<%@ include file="components/bodyFinal.jsp"%>