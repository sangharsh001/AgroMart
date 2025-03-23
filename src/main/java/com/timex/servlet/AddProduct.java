package com.timex.servlet;

import java.io.IOException;
import java.io.InputStream;

import com.timex.dto.Products;
import com.timex.dao.*;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

@WebServlet("/addproduct")
@MultipartConfig(
    fileSizeThreshold = 1024 * 1024 * 2, // 2MB
    maxFileSize = 1024 * 1024 * 10,      // 10MB
    maxRequestSize = 1024 * 1024 * 50    // 50MB
)

public class AddProduct extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Products p = new Products();
        TimexDao tdao = new TimexDaoImpl();

        p.setPname(req.getParameter("pname"));

        // Handle price input
        String priceStr = req.getParameter("pprice");
        double price = (priceStr == null || priceStr.trim().isEmpty()) ? 0.0 : Double.parseDouble(priceStr);
        p.setPrice(price);

        // Handle image upload
        Part filePart = req.getPart("image1");
        if (filePart != null && filePart.getSize() > 0) {
            InputStream inputStream = filePart.getInputStream();
            byte[] imageBytes = inputStream.readAllBytes();
            p.setPic(imageBytes);
        } else {
            p.setPic(null); // No image provided, set to null or use a default image
        }

        p.setPdetails(req.getParameter("pdetails"));

        // Store product in the database
        if (tdao.addProduct(p)) {
            req.setAttribute("padded", "Product Added Successfully");
        } else {
            req.setAttribute("paddedfailed", "Product Addition Failed");
        }

        // Forward request back to the JSP
        RequestDispatcher rd = req.getRequestDispatcher("addproduct.jsp");
        rd.forward(req, resp);
    }
}
