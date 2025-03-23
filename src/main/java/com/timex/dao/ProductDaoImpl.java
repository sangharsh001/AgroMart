package com.timex.dao;

import com.timex.dto.Cart;
import com.timex.dto.Order;
import com.timex.dto.Product;
import com.timex.dto.Timex;

import java.sql.*;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

public class ProductDaoImpl implements ProductDAO {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/timex";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "tiger";

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
   
    public ArrayList<Product> viewAllProduct() {
        ArrayList<Product> productList = new ArrayList<>();
        String query = "SELECT id, pname, price, pic, pdetails FROM addproduct";

        try (Connection conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Product product = new Product();
                product.setId(rs.getLong("id"));
                product.setPname(rs.getString("pname"));
                product.setPrice(rs.getDouble("price"));
                product.setPdetails(rs.getString("pdetails"));

                // Convert Image to Base64
                byte[] imageBytes = rs.getBytes("pic");
                if (imageBytes != null && imageBytes.length > 0) {
                    String base64Image = "data:image/jpeg;base64," + Base64.getEncoder().encodeToString(imageBytes);
                    product.setBase64Image(base64Image);
                } else {
                    product.setBase64Image(null); // No image
                }

                productList.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productList;
    }

	@Override
	public Product addCart(long id) {
		// TODO Auto-generated method stub
		Product product =null;
	
		String query="select * from addproduct where id="+id;
		 try (
				 
				 Connection conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
	             PreparedStatement stmt = conn.prepareStatement(query);
	             ResultSet rs = stmt.executeQuery())
		    {

	            while (rs.next()) {
	                product = new Product();
	                product.setId(rs.getLong("id"));
	                product.setPname(rs.getString("pname"));
	                product.setPrice(rs.getDouble("price"));
	                product.setPdetails(rs.getString("pdetails"));

	                // Convert Image to Base64
	                byte[] imageBytes = rs.getBytes("pic");
	                if (imageBytes != null && imageBytes.length > 0) {
	                    String base64Image = "data:image/jpeg;base64," + Base64.getEncoder().encodeToString(imageBytes);
	                    product.setBase64Image(base64Image);
	                } else {
	                    product.setBase64Image(null); // No image
	                }

	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
		
		
		return product;
	}

	@Override
	public boolean updateCart(Product p, Timex t) {
	    String query = "INSERT INTO cart  VALUES (?,?, ?, ?, ?, ?, ?, ?, ?)";
	    int i = 0;

	    try (Connection conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
	         PreparedStatement stmt = conn.prepareStatement(query)) {

	        // Setting parameters inside the try block
	        stmt.setLong(1, p.getId());
	        stmt.setString(2, p.getPname());

	        // Convert Base64 image string to byte array before storing
	        byte[] imageBytes = (p.getBase64Image() != null && !p.getBase64Image().isEmpty()) 
	                ? Base64.getDecoder().decode(p.getBase64Image().split(",")[1]) 
	                : null;
	        stmt.setBytes(3, imageBytes);
	        stmt.setInt(4, 0);
	        stmt.setString(5, t.getStreet());
	        stmt.setString(6, t.getCity());
	        stmt.setLong(7, t.getPhoneno());
	        stmt.setDouble(8, p.getPrice());
	        stmt.setLong(9, t.getId());

	        // Execute the query
	        i = stmt.executeUpdate();

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    // Return true if at least one row is inserted, false otherwise
	    if(i>0) {
	    	return true;
	    	
	    }
	    else {
	    	return false;
	    }
	}

	@Override
	public ArrayList<Cart> getCart(Timex t) {
		// TODO Auto-generated method stub
		String query="select * from cart where uid="+t.getId();
		 ArrayList<Cart> productList = new ArrayList<>();
	        
	        try (Connection conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
	             PreparedStatement stmt = conn.prepareStatement(query);
	             ResultSet rs = stmt.executeQuery()) {

	            while (rs.next()) {
	                Cart product = new Cart();
	            
	                product.setProductid(rs.getLong("productid"));
	                product.setPname(rs.getString("pname"));
	                byte[] imageBytes = rs.getBytes("pic");
	                if (imageBytes != null && imageBytes.length > 0) {
	                    String base64Image = "data:image/jpeg;base64," + Base64.getEncoder().encodeToString(imageBytes);
	                    product.setPic(base64Image);
	                } else {
	                    product.setPic(null); // No image
	                }
	             product.setQty(rs.getInt("qty"));
	             product.setStreet(rs.getString("street"));
	             product.setCity(rs.getString("city"));
	             product.setPhone(rs.getLong("phone"));
	             product.setAmount(rs.getLong("amount"));
	                // Convert Image to Base64
	             
	                product.setUid(rs.getLong("uid"));

	                productList.add(product);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return productList;
	}

	@Override
	public boolean deleteCart(Cart c) {
		// TODO Auto-generated method stub
		 String query = "DELETE FROM cart WHERE productid=?";
		    
		    try (Connection conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
		         PreparedStatement stmt = conn.prepareStatement(query)) {

		        stmt.setLong(1, c.getProductid());
		        return stmt.executeUpdate() > 0; // Returns true if at least one row is affected

		    } catch (SQLException e) {
		        e.printStackTrace(); // Consider replacing with a proper logging framework
		        return false;
		    }

	}

	@Override
	public ArrayList<Cart> orderDetail(Cart c) {
		// TODO Auto-generated method stub
		
		String query="select * from cart where productid="+c.getProductid();
		 ArrayList<Cart> productList = new ArrayList<Cart>();
	        
	        try (Connection conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
	             PreparedStatement stmt = conn.prepareStatement(query);
	             ResultSet rs = stmt.executeQuery()) {

	            while (rs.next()) {
	                Cart product = new Cart();
	            
	                product.setProductid(rs.getLong("productid"));
	                product.setPname(rs.getString("pname"));
	                byte[] imageBytes = rs.getBytes("pic");
	                if (imageBytes != null && imageBytes.length > 0) {
	                    String base64Image = "data:image/jpeg;base64," + Base64.getEncoder().encodeToString(imageBytes);
	                    product.setPic(base64Image);
	                } else {
	                    product.setPic(null); // No image
	                }
	             product.setQty(rs.getInt("qty"));
	             product.setStreet(rs.getString("street"));
	             product.setCity(rs.getString("city"));
	             product.setPhone(rs.getLong("phone"));
	             product.setAmount(rs.getLong("amount"));
	                // Convert Image to Base64
	             
	                product.setUid(rs.getLong("uid"));

	                productList.add(product);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return productList;
	}

	@Override
	public boolean insertOrder(Cart c) {
		
		  String query = "INSERT INTO orders_table VALUES (0,?,?, ?, ?, ?, ?, ?, ?, ?)";
		  
		  int i = 0;

		    try (Connection conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
		         PreparedStatement stmt = conn.prepareStatement(query)) {

		        // Setting parameters inside the try block
		        stmt.setLong(1,c.getProductid());
		        stmt.setLong(2,c.getUid());
		        stmt.setString(3, c.getPname());
		        
		    

		        // Convert Base64 image string to byte array before storing
		        byte[] imageBytes = (c.getPic() != null && !c.getPic().isEmpty()) 
		                ? Base64.getDecoder().decode(c.getPic().split(",")[1]) 
		                : null;
		        stmt.setBytes(4, imageBytes);
		        stmt.setInt(5,c.getQty());
		        stmt.setString(6, c.getStreet());
		        stmt.setString(7, c.getCity());
		        stmt.setLong(8, c.getPhone());
		        stmt.setDouble(9, c.getAmount());
		       
		        // Execute the query
		        i = stmt.executeUpdate();

		    } catch (SQLException e) {
		        e.printStackTrace();
		    }

		    // Return true if at least one row is inserted, false otherwise
		    if(i>0) {
		    	return true;
		    	
		    }
		    else {
		    	return false;
		    }
	}

	@Override
	public ArrayList< Order> orderDetail(long uid) {
		String query="select * from orders_table where uid="+uid;
		 ArrayList< Order> productList = new ArrayList<Order>();
	        
	        try (Connection conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
	             PreparedStatement stmt = conn.prepareStatement(query);
	             ResultSet rs = stmt.executeQuery()) {

	            while (rs.next()) {
	               Order product = new  Order();
	                product.setOrderid(rs.getLong("orderno"));
	                product.setProductid(rs.getLong("productid"));
	                product.setUid(rs.getLong("uid"));
	                product.setPname(rs.getString("pname"));
	             
	                byte[] imageBytes = rs.getBytes("pic");
	                if (imageBytes != null && imageBytes.length > 0) {
	                    String base64Image = "data:image/jpeg;base64," + Base64.getEncoder().encodeToString(imageBytes);
	                    product.setPic(base64Image);
	                } else {
	                    product.setPic(null); // No image
	                }
	             product.setQty(rs.getInt("qty"));
	             product.setStreet(rs.getString("street"));
	             product.setCity(rs.getString("city"));
	             product.setPhone(rs.getLong("phone"));
	             product.setAmount(rs.getLong("amount"));
	                // Convert Image to Base64
	             
	               

	                productList.add(product);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return productList;
	}

	@Override
	public ArrayList<Order> AllOrder() {
		String query="select * from orders_table";
		 ArrayList< Order> productList = new ArrayList<Order>();
	        
	        try (Connection conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
	             PreparedStatement stmt = conn.prepareStatement(query);
	             ResultSet rs = stmt.executeQuery()) {

	            while (rs.next()) {
	               Order product = new  Order();
	                product.setOrderid(rs.getLong("orderno"));
	                product.setProductid(rs.getLong("productid"));
	                product.setUid(rs.getLong("uid"));
	                product.setPname(rs.getString("pname"));
	             
	                byte[] imageBytes = rs.getBytes("pic");
	                if (imageBytes != null && imageBytes.length > 0) {
	                    String base64Image = "data:image/jpeg;base64," + Base64.getEncoder().encodeToString(imageBytes);
	                    product.setPic(base64Image);
	                } else {
	                    product.setPic(null); // No image
	                }
	             product.setQty(rs.getInt("qty"));
	             product.setStreet(rs.getString("street"));
	             product.setCity(rs.getString("city"));
	             product.setPhone(rs.getLong("phone"));
	             product.setAmount(rs.getLong("amount"));
	                // Convert Image to Base64
	             
	               

	                productList.add(product);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return productList;
		
	}
	
	
	
}

