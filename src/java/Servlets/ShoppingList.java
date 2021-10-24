/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author ADMIN
 */
public class ShoppingList extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        if (request.getParameter("action") != null) {
            if (request.getParameter("action").equals("logout")) {
                HttpSession session = request.getSession();
                session.invalidate();
                getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
                return;
            }
        } else {
            HttpSession session = request.getSession();
            System.out.println("run");
            ArrayList<String> item_list = new ArrayList<>();
            session.setAttribute("item_list", item_list);
            
            getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
            return;
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        if (request.getParameter("action") != null) {
            
            if (request.getParameter("action").equals("register")) {
                
                ArrayList<String> item_list = new ArrayList<>();
                session.setAttribute("item_list", item_list);
               
            }
        }

        ArrayList<String> item_list;
        String addedItem = request.getParameter("user_input_addItem");

        item_list = (ArrayList<String>) session.getAttribute("item_list");
        if (addedItem != null) {
            if (!addedItem.trim().isEmpty()) {
                item_list.add(addedItem);
                session.setAttribute("item_list", item_list);
            }

        }

        String username = request.getParameter("username");
        if (username != null) {
            session.setAttribute("username", username);
        }

        if (request.getParameter("item_radio_group") != null) {
            item_list.remove(request.getParameter("item_radio_group"));
            session.setAttribute("item_list", item_list);
        }

        getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
    }

}
