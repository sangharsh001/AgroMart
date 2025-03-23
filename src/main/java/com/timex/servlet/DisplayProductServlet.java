package com.timex.servlet;

import com.timex.dao.ProductDAO;
import com.timex.dao.ProductDaoImpl;
import com.timex.dto.Product;
import java.io.IOException;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/DisplayProduct")
public class DisplayProductServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ProductDAO productDAO;

    public DisplayProductServlet() {
        this.productDAO = new ProductDaoImpl(); // Now using ProductDaoImpl
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        try {
            List<Product> productList = productDAO.viewAllProduct();
            JSONArray jsonArray = new JSONArray();

            for (Product product : productList) {
                JSONObject json = new JSONObject();
                json.put("id", product.getId());
                json.put("name", product.getPname());
                json.put("price", product.getPrice());
                json.put("details", product.getPdetails());
                json.put("image", product.getBase64Image()); // Base64 Image
                jsonArray.put(json);
            }

            response.getWriter().println(jsonArray.toString());
        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().println("{\"error\": \"Failed to fetch products\"}");
        }
    }
}
