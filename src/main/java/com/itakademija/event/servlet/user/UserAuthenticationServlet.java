package com.itakademija.event.servlet.user;

import com.itakademija.event.ejb.user.UserServiceLocal;
import jakarta.inject.Inject;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "userAuthenticationServlet", urlPatterns = {"/authentication"})
public class UserAuthenticationServlet extends HttpServlet {

    /**
     * Imam samo API Application Programming Interface.
     * <p>
     *     Princip programiranja: Razdvoji kreiranje objekata od njihovog korištenja.
     * @Inject - mi nećemo pozvati konstruktor i kreirati userServiceLocal instancu/objekat
     * nego će to uraditi EJB kontejner za nas, a mi ćemo samo INJEKTOVATI tu već kreiranu instancu
     * </p>
     *
     *
     */
    @Inject
    private UserServiceLocal userServiceLocal;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        boolean authenticated = userServiceLocal.login(username, password);

        if (authenticated) {
            request.setAttribute("username", username);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("dashboard/dashboard.jsp");
            requestDispatcher.forward(request, response);
        } else {
            request.setAttribute("errorMessage", "Neispravna kombinacija lozinke i korisničkog naloga.");
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("login/login.jsp");
            requestDispatcher.forward(request, response);
        }
    }
}
