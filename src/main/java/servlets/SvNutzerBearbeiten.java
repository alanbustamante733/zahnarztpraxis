package servlets;

import BusinnesLogik.KontrollerEinheit;
import BusinnesLogik.Nutzer;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "SvNutzerBearbeiten", urlPatterns = {"/SvNutzerBearbeiten"})
public class SvNutzerBearbeiten extends HttpServlet {
    
    KontrollerEinheit control = new KontrollerEinheit();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int id = Integer.parseInt(request.getParameter("id"));
        Nutzer nutz = control.nutzerBringen(id);
        
        HttpSession meinesession = request.getSession();
        meinesession.setAttribute("nutzerBearbeiten", nutz);
        
        response.sendRedirect("NutzerBearbeiten.jsp");
        
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String nutzerName = request.getParameter("nutzerName");
        String passwort = request.getParameter("passwort");
        String rolle = request.getParameter("rolle");
        
        Nutzer nutz = (Nutzer) request.getSession().getAttribute("nutzerBearbeiten");
        nutz.setNutzerName(nutzerName);
        nutz.setPassword(passwort);
        nutz.setRolle(rolle);
        
        control.nutzerBearbeiten(nutz);
        
        response.sendRedirect("SvNutzer");
        
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
