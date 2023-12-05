package QueuePack;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ServletQueue", urlPatterns = {"/ServletQueue"})
public class ServletQueue extends HttpServlet {
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                      
        if (request.getParameter("push") != null) {
            String custname = request.getParameter("name");
            String pushops = OpsQueue.push(custname);
            String pushUpdate = OpsQueue.getLiveQueueContent();
            request.setAttribute("pushops", pushops);
            request.setAttribute("pushUpdate", pushUpdate);           
                       
            request.setAttribute("enqueuecust", "");
            request.setAttribute("dequeuecust", "");
            request.setAttribute("emptyqueue", "");
            request.setAttribute("queuesize", "");
            request.setAttribute("queueservice", "");
                                              
        } else if (request.getParameter("enqueue") != null) {
            String custname = request.getParameter("name");
            String enqueuecust = OpsQueue.enqueue(custname);
            request.setAttribute("enqueuecust", enqueuecust);
            String pushUpdate = OpsQueue.getLiveQueueContent();
            request.setAttribute("pushUpdate", pushUpdate);
                       
            request.setAttribute("dequeuecust", "");
            request.setAttribute("peekcust", "");
            request.setAttribute("emptyqueue", "");
            request.setAttribute("queuesize", "");
            request.setAttribute("queueservice", "");
                       
        } else if (request.getParameter("peek") != null) {
            String custname = request.getParameter("name");
            String peekcust = OpsQueue.peek(custname);
            request.setAttribute("peekcust", peekcust);
            String pushUpdate = OpsQueue.getLiveQueueContent();
            request.setAttribute("pushUpdate", pushUpdate);
            
            request.setAttribute("enqueuecust", "");
            request.setAttribute("dequeuecust", "");
            request.setAttribute("emptyqueue", "");
            request.setAttribute("queuesize", "");
            request.setAttribute("queueservice", "");
            
        } else if (request.getParameter("dequeue") != null) {
            String custname = request.getParameter("name");
            String dequeuecust = OpsQueue.dequeue(custname);
            request.setAttribute("dequeuecust", dequeuecust);
            String pushUpdate = OpsQueue.getLiveQueueContent();
            request.setAttribute("pushUpdate", pushUpdate);
            
            request.setAttribute("enqueuecust", "");
            request.setAttribute("emptyqueue", "");
            request.setAttribute("peekcust", "");
            request.setAttribute("queuesize", "");
            request.setAttribute("queueservice", "");
            
        } else if (request.getParameter("empty") != null) {
            String emptyqueue = OpsQueue.isEmpty();
            request.setAttribute("emptyqueue", emptyqueue);
            String pushUpdate = OpsQueue.getLiveQueueContent();
            request.setAttribute("pushUpdate", pushUpdate);
            
            request.setAttribute("enqueuecust", "");
            request.setAttribute("dequeuecust", "");
            request.setAttribute("peekcust", "");
            request.setAttribute("queuesize", "");
            request.setAttribute("queueservice", "");
                       
        } else if (request.getParameter("size") != null) {
            String queuesize = OpsQueue.size();
            request.setAttribute("queuesize", queuesize);
            String pushUpdate = OpsQueue.getLiveQueueContent();
            request.setAttribute("pushUpdate", pushUpdate);
            
            request.setAttribute("enqueuecust", "");
            request.setAttribute("dequeuecust", "");
            request.setAttribute("peekcust", "");
            request.setAttribute("emptyqueue", "");
            request.setAttribute("queueservice", "");
            
        } else if (request.getParameter("serviced") != null) {
            String queueservice = OpsQueue.serviced();
            request.setAttribute("queueservice", queueservice);
            String pushUpdate = OpsQueue.getLiveQueueContent();
            request.setAttribute("pushUpdate", pushUpdate);
            
            request.setAttribute("enqueuecust", "");
            request.setAttribute("dequeuecust", "");
            request.setAttribute("peekcust", "");
            request.setAttribute("emptyqueue", "");
            request.setAttribute("queuesize", "");
                                                
        } else if (request.getParameter("clear") != null) {
            String clearqueue = OpsQueue.clear();
            request.setAttribute("clearqueue", clearqueue);
            
            request.setAttribute("pushUpdate", "");
            request.setAttribute("enqueuecust", "");
            request.setAttribute("dequeuecust", "");
            request.setAttribute("peekcust", "");
            request.setAttribute("emptyqueue", "");
            request.setAttribute("queuesize", "");
            request.setAttribute("queueservice", "");                        
        }
        
        response.setHeader("Access-Control-Allow-Origin", "http://localhost:8080/");
        response.setHeader("Access-Control-Allow-Methods", "POST");
        response.setHeader("Access-Control-Allow-Headers", "Content-Type");

                     
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ServletQueue</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ServletQueue at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
