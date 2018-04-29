package com.wardrobe.model;

public class CartItem 
{
 int itemid, userId, cartItemId, itemQty;
 String itemName, item_ImgUrl;
 double itemPrice;
 
 
	public CartItem() {
	super();
}
	public CartItem(int itemid, int userId, int cartItemId, int itemQty, String itemName, String item_ImgUrl,
		double itemPrice) {
	super();
	this.itemid = itemid;
	this.userId = userId;
	this.cartItemId = cartItemId;
	this.itemQty = itemQty;
	this.itemName = itemName;
	this.item_ImgUrl = item_ImgUrl;
	this.itemPrice = itemPrice;
}
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
	@Override
	public String toString() {
		return "CartItem [itemid=" + itemid + ", userId=" + userId + ", cartItemId=" + cartItemId + ", itemQty="
				+ itemQty + ", itemName=" + itemName + ", item_ImgUrl=" + item_ImgUrl + ", itemPrice=" + itemPrice
				+ "]";
	}
	
	
	 
}
