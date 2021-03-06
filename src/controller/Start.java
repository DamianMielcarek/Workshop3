package controller;

import model.Solution;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/")
public class Start extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String solutionsNumber = getServletContext().getInitParameter("number-solutions");
            Solution[] solutions = Solution.loadAll(Integer.parseInt(solutionsNumber));
            request.setAttribute("solutions", solutions);
            getServletContext().getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
