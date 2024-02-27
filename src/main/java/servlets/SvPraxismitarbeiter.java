
package servlets;

import BusinnesLogik.KontrollerEinheit;
import BusinnesLogik.Praxismitarbeiter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "SvPraxismitarbeiter", urlPatterns = {"/SvPraxismitarbeiter"})
public class SvPraxismitarbeiter extends HttpServlet {

    KontrollerEinheit control = new KontrollerEinheit();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        List<Praxismitarbeiter> praxisMitarbeiterListe = control.getPraxisMitarbeiter();
        
        HttpSession meineSessionPraxisMirarbeiter = request.getSession();
        meineSessionPraxisMirarbeiter.setAttribute("praxismitarbeiterListe", praxisMitarbeiterListe);
        
        response.sendRedirect("PraxismitarbeiterAnzeigen.jsp");
        
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
            
            
            control.praxisMitarbeiterErstellen(ausweisnummer, name, nachname, telefon, adresse, abteilung, geburtsdatum);
            System.out.println("Fecha recibida: " + geburtsdatum);
            response.sendRedirect("index.jsp");
        } catch (ParseException ex) {
            Logger.getLogger(SvZahnarzt.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
