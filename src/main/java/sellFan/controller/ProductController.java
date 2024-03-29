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

@WebServlet(urlPatterns = {"/product"})
public class ProductController extends HttpServlet {

    private static final long serialVersionUID = -5866282446898633441L;
    @Inject
    IProductDetailDAO _productDetailDAO;

    @Inject
    IProductDAO _productDAO;

    @Inject
    IproductImageDAO _productImageDAO;
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //GET params
        String productId = req.getParameter("id");

        ProductDetail productDetail = _productDetailDAO.getProductDetailById(Integer.parseInt(productId));
        Product product = _productDAO.getProductById(Integer.parseInt(productId));
        List<ProductImage> productImages = _productImageDAO.getAllByProductId(Integer.parseInt(productId));
        req.setAttribute("productDetail", productDetail);
        req.setAttribute("product", product);
        req.setAttribute("productImages", productImages);

        RequestDispatcher rd = req.getRequestDispatcher("/views/product/product.jsp");
        rd.forward(req, resp);
    }
}
