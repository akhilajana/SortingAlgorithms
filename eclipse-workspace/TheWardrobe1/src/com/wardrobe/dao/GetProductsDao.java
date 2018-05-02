package com.wardrobe.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


import com.wardrobe.model.Products;

public class GetProductsDao {
	private static ResultSet resultSet = null;
	 public static Connection getConnection(){  
	        Connection con=null;  
	        try{  
	            Class.forName("com.mysql.jdbc.Driver");  
//	            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/wardrobeModel","root","root");
	            con=DriverManager.getConnection("jdbc:mysql://awswardrobemodel.cjgqsqxh9apc.us-east-1.rds.amazonaws.com:3306/awsDB","awsroot1","awsroot1");

	            //System.out.println(con.isReadOnly());
	        }
	            catch(Exception e){System.out.println(e);}  
		        return con;
	   }

	public ArrayList<Products> get3Products() {
		// TODO Auto-generated method stub
		try{
			   Connection con=getConnection();
			   ArrayList<Products> items=new ArrayList<Products>();
			   PreparedStatement statement=(PreparedStatement) con.prepareStatement("select * from products limit 3");
	           
	           resultSet=statement.executeQuery();
	           while(resultSet.next())
	           {
	        	   Products item=new Products();
	        	   item.setProductId(resultSet.getInt("product_id"));
	        	   item.setName(resultSet.getString("product_name"));
	        	   item.setDesc(resultSet.getString("product_descrption"));
	        	   item.setSize(resultSet.getString("product_size"));
	        	   item.setPrice(resultSet.getDouble("product_price"));
	        	   item.setColor(resultSet.getString("product_color"));
	    		   item.setCategory(resultSet.getString("product_category"));
	    		   item.setImageUrl(resultSet.getString("imageUrl"));
	    		   item.setQty(resultSet.getInt("product_qty"));
	    		   items.add(item);
	           }
	           return items;
		   }
		   catch(Exception e)
		   {
			   e.printStackTrace();
		   }
		   return null;
	}
	
	public ArrayList<Products> getProductsByCategory(String categoryName) {
		// TODO Auto-generated method stub
		try{
			   Connection con=getConnection();
			   ArrayList<Products> items=new ArrayList<Products>();
			   PreparedStatement statement=(PreparedStatement) con.prepareStatement("select * from products where product_category=?");
	           statement.setString(1, categoryName);
	           resultSet=statement.executeQuery();
	           while(resultSet.next())
	           {
	        	   Products item=new Products();
	        	   item.setProductId(resultSet.getInt("product_id"));
	        	   item.setName(resultSet.getString("product_name"));
	        	   item.setDesc(resultSet.getString("product_descrption"));
	        	   item.setSize(resultSet.getString("product_size"));
	        	   item.setPrice(resultSet.getDouble("product_price"));
	        	   item.setColor(resultSet.getString("product_color"));
	    		   item.setCategory(resultSet.getString("product_category"));
	    		   item.setImageUrl(resultSet.getString("imageUrl"));
	    		   item.setQty(resultSet.getInt("product_qty"));
	    		   items.add(item);
	           }
	           return items;
		   }
		   catch(Exception e)
		   {
			   e.printStackTrace();
		   }
		   return null;
	}

}
