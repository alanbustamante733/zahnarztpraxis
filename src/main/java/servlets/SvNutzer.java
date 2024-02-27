
package servlets;

import BusinnesLogik.KontrollerEinheit;
import BusinnesLogik.Nutzer;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "SvNutzer", urlPatterns = {"/SvNutzer"})
public class SvNutzer extends HttpServlet {

    KontrollerEinheit control = new KontrollerEinheit();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        List<Nutzer> nutzerListe = control.getNutzer();
        
        HttpSession meineSessionNutzer = request.getSession();
        meineSessionNutzer.setAttribute("nutzerListe", nutzerListe);
        
        response.sendRedirect("NutzerAnzeigen.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String nutzerName = request.getParameter("nutzerName");
        String passwort = request.getParameter("passwort");
        String rolle = request.getParameter("rolle");
        
        control.nutzerErstellen(nutzerName, passwort, rolle);
        
        response.sendRedirect("index.jsp");
        
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

    private void getNutzer() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
