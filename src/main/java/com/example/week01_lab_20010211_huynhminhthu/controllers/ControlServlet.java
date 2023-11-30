package com.example.week01_lab_20010211_huynhminhthu.controllers;

import com.example.week01_lab_20010211_huynhminhthu.models.Account;
import com.example.week01_lab_20010211_huynhminhthu.services.AccountServices;
import com.example.week01_lab_20010211_huynhminhthu.services.GrantAccessServices;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;


import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;

@WebServlet("/ControlServlet")
public class ControlServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String accountId = req.getParameter("accountId");
        String pwd = req.getParameter("pwd");
        Account account = AccountServices.searchAccount(accountId);
        if(account!=null){
            if(!account.getPassword().equals(pwd)){
                Cookie cookie = new Cookie("state_login","user_pwd_fail");
                resp.addCookie(cookie);
                resp.sendRedirect("index.jsp");
            } else {
                Cookie cookie = new Cookie("state_login","oke");
                resp.addCookie(cookie);
                if(GrantAccessServices.searchGrantAccessByAccountId(accountId).getRole().getRole_id().equals("admin")){
                    HttpSession session = req.getSession();
                    Date date = new Date();

                    session.setAttribute("accountId",accountId);
                    session.setAttribute("timeIn",new Timestamp(date.getTime()));

                    req.setAttribute("account",account);
                    RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/dashboard_admin.jsp");
                    requestDispatcher.forward(req,resp);
                }
                else{
                    HttpSession session = req.getSession();
                    Date date = new Date();

                    session.setAttribute("accountId",accountId);
                    session.setAttribute("timeIn",new Timestamp(date.getTime()));

                    req.setAttribute("account",account);
                    RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/dashboard_user.jsp");
                    requestDispatcher.forward(req,resp);
                }

            }
        } else {
            Cookie cookie = new Cookie("state_login","user_null");
            resp.addCookie(cookie);
            resp.sendRedirect("index.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String str = req.getParameter("action");
        System.out.println(str);
    }
}