package servlets;

import BusinnesLogik.KontrollerEinheit;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "SvZahnarztLoeschen", urlPatterns = {"/SvZahnarztLoeschen"})
public class SvZahnarztLoeschen extends HttpServlet {
    
    KontrollerEinheit control = new KontrollerEinheit();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int id = Integer.parseInt(request.getParameter("id"));
        
        control.zahnarztLoeschen(id);
        
        response.sendRedirect("SvZahnarzt");
        
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
