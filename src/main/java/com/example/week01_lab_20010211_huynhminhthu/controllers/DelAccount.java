package com.example.week01_lab_20010211_huynhminhthu.controllers;

import com.example.week01_lab_20010211_huynhminhthu.services.AccountServices;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/DelAccount")
public class DelAccount extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        AccountServices.dellAccount(req.getParameter("id"));
        resp.sendRedirect("/week01_lab_20010211_huynhminhthu/ViewAccount");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        super.doPost(req, resp);
    }
}