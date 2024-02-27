
package servlets;

import BusinnesLogik.GesetzlicherVertreter;
import BusinnesLogik.KontrollerEinheit;
import BusinnesLogik.Patient;
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

@WebServlet(name = "SvPatient", urlPatterns = {"/SvPatient"})
public class SvPatient extends HttpServlet {

    KontrollerEinheit control = new KontrollerEinheit();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        //List<Patient> zahnaerzteListe = control.getPatienten();
        
        
        HttpSession meineSessionPatient = request.getSession();
        //meineSessionPatient.setAttribute("patientenListe", zahnaerzteListe);
        
        response.sendRedirect("PatientenAnzeigen.jsp");
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        try {
            String ausweisnummerGesetzlicherVertreter = request.getParameter("ausweisnummerGesetzlicherVertreter");
            String nameGesetzlicherVertreter = request.getParameter("nameGesetzlicherVertreter");
            String nachnameGesetzlicherVertreter = request.getParameter("nachnameGesetzlicherVertreter");
            String telefonGesetzlicherVertreter = request.getParameter("telefonGesetzlicherVertreter");
            String adresseGesetzlicherVertreter = request.getParameter("adresseGesetzlicherVertreter");
            String artDerVerantwortung = request.getParameter("artDerVerantwortung");
            
            SimpleDateFormat formatiertesDatum = new SimpleDateFormat("dd-MM-yyyy");
            
            Date geburtsdatumGesetzlicherVertreter = formatiertesDatum.parse(request.getParameter("geburtsdatumGesetzlicherVertreter"));
            
            
            control.vertreterHerstellen(ausweisnummerGesetzlicherVertreter, nameGesetzlicherVertreter, nachnameGesetzlicherVertreter, telefonGesetzlicherVertreter, adresseGesetzlicherVertreter, artDerVerantwortung, geburtsdatumGesetzlicherVertreter);

            String ausweisnummer = request.getParameter("ausweisnummer");
            String name = request.getParameter("name");
            String nachname = request.getParameter("nachname");
            String telefon = request.getParameter("telefon");
            String adresse = request.getParameter("adresse");
            String istSozialversichert = request.getParameter("istSozialversichert");
            String istPrivatversichert = request.getParameter("istPrivatversichert");
            String bluttgruppe = request.getParameter("bluttgruppe");
            
         
            Date geburtsdatum = formatiertesDatum.parse(request.getParameter("geburtsdatum"));
            
            
            control.patientErstellen(ausweisnummer, name, nachname, telefon, adresse, geburtsdatum, istSozialversichert, istPrivatversichert, bluttgruppe);
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
