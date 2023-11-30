package com.example.week01_lab_20010211_huynhminhthu.controllers;

import com.example.week01_lab_20010211_huynhminhthu.models.Account;
import com.example.week01_lab_20010211_huynhminhthu.services.AccountServices;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/ViewAccount")
public class ViewAccount extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Account> accounts = AccountServices.getAccounts();
        req.setAttribute("listAccounts",accounts);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/viewAccount.jsp");
        requestDispatcher.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}