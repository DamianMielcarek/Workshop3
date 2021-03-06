package controller;

import model.Solution;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/user_details")
public class UserDetails extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int id = Integer.parseInt(request.getParameter("id"));

            User user = User.loadUserById(id);
            request.setAttribute("user", user);

            Solution[] solutions = Solution.loadAllByUsersId(id);
            request.setAttribute("solutions", solutions);

            request.getServletContext().getRequestDispatcher("/WEB-INF/user_details.jsp").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
