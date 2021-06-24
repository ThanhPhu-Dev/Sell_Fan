package sellFan.controller;

import java.io.IOException;
import java.util.*;
import javax.inject.Inject;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sellFan.dao.iterface.IProductDAO;
import sellFan.dto.*;

@WebServlet(urlPatterns = {"/home"})
public class HomeController extends HttpServlet {

    private static final long serialVersionUID = -5866282446898633441L;
    @Inject
    IProductDAO _productDAO;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Product> products = _productDAO.getAllProduct();
        req.setAttribute("products", products);

        RequestDispatcher rd = req.getRequestDispatcher("/views/home/home.jsp");
        rd.forward(req, resp);
    }
}
