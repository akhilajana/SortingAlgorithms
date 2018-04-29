package com.wardrobe.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.wardrobe.model.CartItem;


public class CartDao {
	private static ResultSet resultSet = null;
	  private static PreparedStatement pstatement=null;
	  public static String USER_TYPE="";
	   public static Connection getConnection(){  
	        Connection con=null;  
	        try{  
	            Class.forName("com.mysql.jdbc.Driver");  
	            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/wardrobeModel","root","root"); 
	        }
	            catch(Exception e){System.out.println(e);}  
		        return con;
	   }
	   
	   public int delete_cart(int itemId)
	   {
		   int status=0;
		   try{
			   Connection con=getConnection();
			   PreparedStatement statement=(PreparedStatement) con.prepareStatement("delete from cart where item_id=?");
			   statement.setInt(1,itemId);
			   status=statement.executeUpdate();
			   return status;
		   }
		   catch(Exception e)
		   {
			  e.printStackTrace(); 
		   }
		   return 0;
	   }
	   public int insert_cart(CartItem cartItem)
	   {
		   int status=0;
		   try{
			   Connection con=getConnection();
			   PreparedStatement statement=(PreparedStatement) con.prepareStatement("insert into cart(item_id,item_name,quantity,user_id,item_price,imageUrl) values(?,?,?,?,?,?)");
			   statement.setInt(1,cartItem.getItemid());
			   statement.setString(2,cartItem.getItemName());
			   statement.setInt(3, cartItem.getItemQty());
			   statement.setInt(4,cartItem.getUserId());
			   statement.setDouble(5,cartItem.getItemPrice());
			   statement.setString(6,cartItem.getItem_ImgUrl());
			   status=statement.executeUpdate();
			   return status;
			   
		   }
		   catch(Exception e)
		   {
			  e.printStackTrace(); 
		   }
		   return status;
	   }
	   public ArrayList<CartItem> getCartItems(int userId)
	   { 
		   try{
			   Connection con=getConnection();
			   ArrayList<CartItem> items=new ArrayList<CartItem>();
			   PreparedStatement statement=(PreparedStatement) con.prepareStatement("select * from cart where user_id=?");
	           statement.setInt(1,userId);
	           resultSet=statement.executeQuery();
	           while(resultSet.next())
	           {
	        	   CartItem item=new CartItem();
	        	   item.setUserId(userId);
	        	   item.setItem_ImgUrl(resultSet.getString("imageUrl"));
	        	   item.setItemName(resultSet.getString("item_name"));
	        	   item.setItemid(resultSet.getInt("item_id"));
	        	   item.setItemPrice(resultSet.getDouble("item_price"));
	        	   item.setCartItemId(resultSet.getInt("cart_id"));
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
