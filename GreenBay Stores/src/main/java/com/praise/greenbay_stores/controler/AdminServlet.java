package com.praise.greenbay_stores.controler;

import com.praise.greenbay_stores.dao.AdminDAO;
import com.praise.greenbay_stores.model.Admin;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/AdminServlet")
public class AdminServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private AdminDAO adminDAO;

    public void init(){
        adminDAO = new AdminDAO();
    }

    public AdminServlet(){
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().append("Served at:  ").append(request.getContextPath());

        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/AdminRegister.jsp");
        dispatcher.forward(request, response);
    }
    protected void soPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
       String username = request.getParameter("username");
       String password = request.getParameter("password");
       String fname = request.getParameter("fname");
       String address = request.getParameter("address");
       String contact = request.getParameter("contact");

        Admin admin = new Admin();
        admin.setUsername(username);
        admin.setPassword(password);
        admin.setFname(fname);
        admin.setAddress(address);
        admin.setContact(contact);

        try {
            adminDAO.registerAdmin(admin);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/AdminDetails.jsp");
        dispatcher.forward(request, response);
    }

}
