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
import sellFan.dao.iterface.*;
import sellFan.dto.*;

@WebServlet(urlPatterns = {"/home"})
public class HomeController extends HttpServlet {

    private static final long serialVersionUID = -5866282446898633441L;
    @Inject
    IProductDAO _productDAO;

    @Inject
    IProductTypeDAO _productTypeDAO;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Product> products;
        List<ProductType> cats = _productTypeDAO.getAllCat();
        //GET params
        String name = req.getParameter("name");
        String catId = req.getParameter("catId");

        if (name == null && catId == null) {
            products = _productDAO.getAllProduct();
        } else if (name != null && catId == null) {
            products = _productDAO.getAllProductByName(name);
        } else if (name == null && catId != null) {
            products = _productDAO.getAllProductByCat(catId);
        } else {
            products = _productDAO.getAllProductByCatAndName(catId, name);
        }

        req.setAttribute("products", products);
        req.setAttribute("cats", cats);

        RequestDispatcher rd = req.getRequestDispatcher("/views/home/home.jsp");
        rd.forward(req, resp);
    }
}
