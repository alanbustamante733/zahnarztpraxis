package servlets;

import BusinnesLogik.KontrollerEinheit;
import BusinnesLogik.Zahnarzt;
import java.io.IOException;
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

@WebServlet(name = "SvZahnarztBearbeiten", urlPatterns = {"/SvZahnarztBearbeiten"})
public class SvZahnarztBearbeiten extends HttpServlet {

    KontrollerEinheit control = new KontrollerEinheit();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int id = Integer.parseInt(request.getParameter("id"));
        Zahnarzt zahn = control.zahnarztBringen(id);
        
        HttpSession meinesessionZahnarzt = request.getSession();
        meinesessionZahnarzt.setAttribute("zahnarztBearbeiten", zahn);
        
        response.sendRedirect("ZahnarztBearbeiten.jsp");
        
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
            String fachrichtung = request.getParameter("fachrichtung");
            
            SimpleDateFormat formatiertesDatum = new SimpleDateFormat("dd-MM-yyyy");
            
            Date geburtsdatum = formatiertesDatum.parse(request.getParameter("geburtsdatum"));
            
            Zahnarzt zahn = (Zahnarzt) request.getSession().getAttribute("zahnarztBearbeiten");
            zahn.setAusweisnummer(ausweisnummer);
            zahn.setName(name);
            zahn.setNachname(nachname);
            zahn.setTelefon(telefon);
            zahn.setAdresse(adresse);
            zahn.setFachrichtung(fachrichtung);
            zahn.setGeburtsdatum(geburtsdatum);
            control.zahnarztBearbeiten(zahn);
            
            response.sendRedirect("SvZahnarzt");
        } catch (ParseException ex) {
            Logger.getLogger(SvZahnarzt.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
