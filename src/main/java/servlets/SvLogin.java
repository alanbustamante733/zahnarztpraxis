
package servlets;

import BusinnesLogik.KontrollerEinheit;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "SvLogin", urlPatterns = {"/SvLogin"})
public class SvLogin extends HttpServlet {

    KontrollerEinheit control = new KontrollerEinheit();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String nutzer = request.getParameter("nutzer");
        String passwort = request.getParameter("passwort");
        
        boolean validierung = false;
        validierung = control.loginUeberpruefung(nutzer,passwort);
        
        if (validierung == true ) {
            HttpSession meinesessionLogin = request.getSession(true);
            meinesessionLogin.setAttribute("nutzer", nutzer);
            response.sendRedirect("index.jsp");
        } else {
            response.sendRedirect("falschesLogin.jsp");
        }
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
