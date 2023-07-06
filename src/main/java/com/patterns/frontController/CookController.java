package com.patterns.frontController;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;

public class CookController {
    Connection connection = null;

    public void getIngredients(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        PrintWriter printWriter = resp.getWriter();

        try {
            Class.forName("org.postgresql.Driver");

            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/patterns_ee", "postgres", "root");
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM ingredients");

            ResultSet resultSet = statement.executeQuery();

            ArrayList<Ingredients> userList = new ArrayList<>();

            while (resultSet.next()) {
                Ingredients list = new Ingredients();
                list.setId(resultSet.getLong("id"));
                list.setNameIngredients(resultSet.getString("name_ingredient"));
                userList.add(list);
            }
            printWriter.write(String.valueOf(userList));
            System.out.println(userList);
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            try {
                connection.close();
                printWriter.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void addIngredient(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        PrintWriter printWriter = resp.getWriter();
        String addIngredient = req.getParameter("add");

        req.setAttribute("add", addIngredient);

        try {
            Class.forName("org.postgresql.Driver");

            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/patterns_ee", "postgres", "root");
            PreparedStatement statement = connection.prepareStatement("INSERT INTO ingredients " +
                    "(id,name_ingredient) VALUES (DEFAULT, ?);");
            statement.setString(1, addIngredient);

            printWriter.println("Ingredient was added!");
            statement.executeQuery();

        } catch (ClassNotFoundException e) {
            System.out.println(e);
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            try {
                connection.close();
                printWriter.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void deleteIngredient(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        PrintWriter printWriter = resp.getWriter();
        String deleteIngredient = req.getParameter("delete");

        req.setAttribute("delete", deleteIngredient);

        try {
            Class.forName("org.postgresql.Driver");

            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/patterns_ee", "postgres", "root");
            PreparedStatement statement = connection.prepareStatement("DELETE FROM ingredients WHERE name_ingredient=?");
            statement.setString(1, deleteIngredient);

            int result = statement.executeUpdate();
            if (result == 1) {
                printWriter.println("Deleted!");
            } else {
                printWriter.println("Such ingredient doesn't exist!");
            }
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            try {
                connection.close();
                printWriter.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
