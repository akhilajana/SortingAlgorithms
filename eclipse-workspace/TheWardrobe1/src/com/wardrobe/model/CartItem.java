package com.wardrobe.model;

public class CartItem 
{
 int itemid, userId, cartItemId, itemQty;
 String itemName, item_ImgUrl;
 double itemPrice;
 
	public int getItemid() {
		return itemid;
	}
	public void setItemid(int itemid) {
		this.itemid = itemid;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getCartItemId() {
		return cartItemId;
	}
	public void setCartItemId(int cartItemId) {
		this.cartItemId = cartItemId;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getItem_ImgUrl() {
		return item_ImgUrl;
	}
	public void setItem_ImgUrl(String item_ImgUrl) {
		this.item_ImgUrl = item_ImgUrl;
	}
	public double getItemPrice() {
		return itemPrice;
	}
	public void setItemPrice(double itemPrice) {
		this.itemPrice = itemPrice;
	}
	public int getItemQty() {
		return itemQty;
	}
	public void setItemQty(int itemQty) {
		this.itemQty = itemQty;
	}
	 
}
