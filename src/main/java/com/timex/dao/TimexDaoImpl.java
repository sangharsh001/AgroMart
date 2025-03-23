package com.timex.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.timex.connection.Connector;
import com.timex.dto.Cart;
import com.timex.dto.Product;
import com.timex.dto.Products;
import com.timex.dto.Timex;

public class TimexDaoImpl implements TimexDao {

	
	private Connection con;
	
		
	public TimexDaoImpl() {
	
		this.con = Connector.requestConnection();
	}


	@Override
	public boolean insertRecord(Timex t) {
		String query="INSERT INTO signup VALUES(0,?,?,?,?,?,?,?,?,?,?,?,?)";
		int i=0;
			PreparedStatement ps;
			try {
				ps = con.prepareStatement(query);
//				ps.setLong(1, t.getId());
				
				ps.setString(1, t.getEmail());
				
				ps.setString(2, t.getPassword());
				ps.setLong(3, t.getPhoneno());
				ps.setString(4, t.getDob());
				ps.setString(5, t.getGender());
				ps.setString(6, t.getStreet());
				ps.setString(7, t.getCity());
				ps.setString(8, t.getCountry());
				ps.setString(9, t.getState());
				ps.setString(10, t.getDistrict());
				ps.setString(11, t.getZipcode());
				ps.setString(12, t.getFname());
				
				
				
				i=ps.executeUpdate();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(i>0) {
				
				return true;
			}	else {
				
				return false;
			}
			
	}


	@Override
	public Timex getRecord(String email, String password) {
		// TODO Auto-generated method stub+
		Timex tx =null;
		String query="SELECT * FROM SIGNUP WHERE EMAIL=? AND PASSWORD=?";
		PreparedStatement ps;
		ResultSet rs=null;
	
			try {
				ps = con.prepareStatement(query);
				ps.setString(1, email);
				ps.setString(2, password);
				rs=ps.executeQuery();
				while(rs.next()) {
					tx=new Timex();
					tx.setId(rs.getLong("ID"));
					tx.setEmail(rs.getString("email"));
					tx.setPassword(rs.getString("password"));
					tx.setPhoneno(rs.getLong("phonno"));
					tx.setDob(rs.getString("dob"));
					tx.setGender(rs.getString("gender"));
					tx.setStreet(rs.getString("street"));
					tx.setCity(rs.getString("city"));
					tx.setCountry(rs.getString("country"));
					tx.setState(rs.getString("state"));
					tx.setDistrict(rs.getString("district"));
					tx.setZipcode(rs.getString("zipcode"));
					tx.setFname(rs.getString("fname"));
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		
		
		
		
		return tx;
	}


	@Override
	public ArrayList<Timex> viewallUser() {
		Timex tx;
		ResultSet rs=null;
		ArrayList<Timex> list=new ArrayList<Timex>();
		String query="SELECT * FROM signup";
		try {
			PreparedStatement ps=con.prepareStatement(query);
			rs=ps.executeQuery();
			while(rs.next()) {
				tx=new Timex();
				tx.setId(rs.getLong("ID"));
				tx.setEmail(rs.getString("email"));
				tx.setPassword(rs.getString("password"));
				tx.setPhoneno(rs.getLong("phonno"));
				tx.setDob(rs.getString("dob"));
				tx.setGender(rs.getString("gender"));
				tx.setStreet(rs.getString("street"));
				tx.setCity(rs.getString("city"));
				tx.setCountry(rs.getString("country"));
				tx.setState(rs.getString("state"));
				tx.setDistrict(rs.getString("district"));
				tx.setZipcode(rs.getString("zipcode"));
				tx.setFname(rs.getString("fname"));
				list.add(tx);
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	return list;
	}


	@Override
	public boolean deleteUser(Timex t) {
		String query="Delete from signup where id=?";
		PreparedStatement ps;
		int i=0;
		try {
			ps=con.prepareStatement(query);
			ps.setLong(1,t.getId());
			i=ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(i>0) {
			return true;
		}else
		{
		// TODO Auto-generated method stub
		return false;
		}
	}


	@Override
	public int userCount() {
		String query="SELECT * FROM SIGNUP";
				
			ResultSet res=null;	
		PreparedStatement ps;
		int i=-1;
		try {
			ps=con.prepareStatement(query);
			
			res=ps.executeQuery();
			
			while(res.next())
			{
				i=i+1;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return i;
	}


	@Override
	public boolean addProduct(Products p) {
		// TODO Auto-generated method stub
		
		
		
		String query="INSERT INTO addproduct VALUES (0,?, ?, ?, ?)";
			
		PreparedStatement ps;
		int i=0;
		try {
			ps=con.prepareStatement(query);
			ps.setString(1,p.getPname());
			ps.setDouble(2,p.getPrice());
			ps.setBytes(3,p.getPic());
			ps.setString(4, p.getPdetails());
			i=ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(i>0) {
			return true;
		}else {
		// TODO Auto-generated method stub
		return false;
		}
		
	}


	@Override
	public ArrayList<Products> viewAllProduct() {
		ArrayList<Products> productList = new ArrayList<Products>();
		Products product=null;
        try {
          
          

            String sql = "SELECT id, pname, price, pic, pdetails FROM addproduct";
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
             product   = new Products();
                      product.setId(rs.getLong("id"));
                      product.setPname(rs.getString("pname"));
             product.setPrice(rs.getDouble("price"));
             product.setPic(rs.getBytes("pic"));
             product.setPdetails(rs.getString("pdetails"));
            
             
                productList.add(product);
            }

            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return productList;
    }
		
		
	


	@Override
	public boolean deletProduct(Product p) {
		String query="Delete from addproduct where id=?";
		PreparedStatement ps;
		int i=0;
		try {
			ps=con.prepareStatement(query);
			ps.setLong(1,p.getId());
			i=ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(i>0) {
			return true;
		}else {
		// TODO Auto-generated method stub
		return false;
		}
		
	}


	
	@Override
	public boolean incQty(Product c) {
	    String query = "UPDATE cart SET qty = qty + 1 WHERE product_id = ?";
	    int rowsUpdated = 0;

	    try (PreparedStatement stmt = con.prepareStatement(query)) {  // Try-with-resources to auto-close
	        stmt.setLong(1, c.getId());  // Use parameterized query
	        rowsUpdated = stmt.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return rowsUpdated > 0;
	}


}
	
	
	






