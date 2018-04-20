package com.wardrobe.model;

public class Products 
{
	int productId, qty;
	String name, desc, size, color, category,imageUrl;
	Double price;
	
	public Products() {
		// TODO Auto-generated constructor stub
	}

	public Products(int productId, int qty, String name, String desc, String size, Double price, String color, String category,
			String imageUrl) {
		super();
		this.productId = productId;
		this.qty=qty;
		this.name = name;
		this.desc = desc;
		this.size = size;
		this.price = price;
		this.color = color;
		this.category = category;
		this.imageUrl = imageUrl;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}


	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getCategory() {
		return category;
	}
	
	public void setCategory(String category) {
		this.category = category;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	@Override
	public String toString() {
		return "Products [productId=" + productId + ", qty=" + qty + ", name=" + name + ", desc=" + desc + ", size="
				+ size + ", color=" + color + ", category=" + category + ", imageUrl=" + imageUrl + ", price=" + price
				+ "]";
	}

}
