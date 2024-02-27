
package servlets;

import BusinnesLogik.KontrollerEinheit;
import BusinnesLogik.Praxismitarbeiter;
import BusinnesLogik.Zahnarzt;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "SvPraxismitarbeiterBearbeiten", urlPatterns = {"/SvPraxismitarbeiterBearbeiten"})
public class SvPraxismitarbeiterBearbeiten extends HttpServlet {

    KontrollerEinheit control = new KontrollerEinheit();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int id = Integer.parseInt(request.getParameter("id"));
        Praxismitarbeiter praxis = control.praxisMitarbeiterBringen(id);
        
        HttpSession meinesessionPraxismitarbeiter = request.getSession();
        meinesessionPraxismitarbeiter.setAttribute("prixisMitarbeiterBearbeiten", praxis);
        
        response.sendRedirect("PraxismitarbeiterBearbeiten.jsp");
        
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        try {
            String ausweisnummer = request.getParameter("ausweisnummer");
            String name = request.getParameter("name");
            String nachname = request.getParameter("nachname");
            String telefon = request.getParameter("telefon");
            String adresse = request.getParameter("adresse");
            String abteilung = request.getParameter("abteilung");
            
            SimpleDateFormat formatiertesDatum = new SimpleDateFormat("dd-MM-yyyy");
            
            Date geburtsdatum = formatiertesDatum.parse(request.getParameter("geburtsdatum"));
            
            Praxismitarbeiter praxis = (Praxismitarbeiter) request.getSession().getAttribute("prixisMitarbeiterBearbeiten");
            praxis.setAusweisnummer(ausweisnummer);
            praxis.setName(name);
            praxis.setNachname(nachname);
            praxis.setTelefon(telefon);
            praxis.setAdresse(adresse);
            praxis.setAbteilung(abteilung);
            praxis.setGeburtsdatum(geburtsdatum);
            control.praxismitarbeiterBearbeiten(praxis);
            
            response.sendRedirect("SvPraxismitarbeiter");
        } catch (ParseException ex) {
            Logger.getLogger(SvZahnarzt.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
