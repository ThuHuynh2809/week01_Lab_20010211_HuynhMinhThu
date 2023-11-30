package com.example.week01_lab_20010211_huynhminhthu.controllers;

import com.example.week01_lab_20010211_huynhminhthu.models.Account;
import com.example.week01_lab_20010211_huynhminhthu.services.AccountServices;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


import java.io.IOException;

import static java.lang.Byte.parseByte;

@WebServlet("/AddAccount")
public class AddAccount extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Account account = new Account(
                req.getParameter("id").toString(),
                req.getParameter("name").toString(),
                req.getParameter("pwd").toString(),
                req.getParameter("email").toString(),
                req.getParameter("phone").toString(),
                parseByte(req.getParameter("status").toString(), 10)
        );

        AccountServices.insertAccount(account);

        resp.sendRedirect("/week01_lab_20010211_huynhminhthu/ViewAccount");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        super.doPost(req, resp);
    }
}