/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author tweet
 */
public class ShoppingListServlet extends HttpServlet {

    List<String> useritems = new ArrayList();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session =request.getSession(); 
        
        String action = request.getParameter("action");
        System.out.println("ACTION IS: " + action);
        String username = request.getParameter("username");

        if (action.equals("register")){
            System.out.println("Register If statement");
            session.setAttribute("user", username);
            getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
            return;
        }
        if (action.equals("add")){
            String item = request.getParameter("item");
            System.out.println("item is: " + item);
            useritems.add(item);
            session.setAttribute("itemList", useritems);
            getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
            return;
        } 
        
        if (action.equals("delete")){
            String item = request.getParameter("addeditems");
            System.out.println("item to delete is: " + item);
            for(int i = 0; i< useritems.size();i++){
                if(useritems.get(i).equals(item))
                {
                    useritems.remove(i);
                }
            }
            session.setAttribute("itemList", useritems);
            getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
            return;
        } 
        
        if (action.equals("logout")){
            session.invalidate();
            getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
            return;
        } 
        getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
    }
}
