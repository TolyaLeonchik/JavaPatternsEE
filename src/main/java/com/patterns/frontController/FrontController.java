package com.patterns.frontController;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/*")
public class FrontController extends HttpServlet {

    CookController cookController = new CookController();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String path = req.getRequestURI();
    dispatcher(path, "GET", req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    public void dispatcher(String path, String method, HttpServletRequest req,
                           HttpServletResponse resp) throws ServletException, IOException {
        if ("GET".equals(method)) {
            switch (path) {
                case "/getIngredients" -> cookController.getIngredients(req, resp);
                case "/addIngredient" -> cookController.addIngredient(req, resp);
                case "/deleteIngredient" -> cookController.deleteIngredient(req, resp);
            }
        }
    }
}
