package servlets;

import BusinnesLogik.KontrollerEinheit;
import BusinnesLogik.Zahnarzt;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "SvTermin", urlPatterns = {"/SvTermin"})
public class SvTermin extends HttpServlet {

    KontrollerEinheit control = new KontrollerEinheit();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        List<Zahnarzt> zahnaerzteListe = control.getZahnaerzte();
                
        HttpSession meineSessionZahnarztTermin = request.getSession();
        meineSessionZahnarztTermin.setAttribute("zahnaerzteListeTermin", zahnaerzteListe);
        
        response.sendRedirect("TerminHinzufuegen.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
       
        
    }

    public String getServletInfo() {
        return "Short description";
    }

}
