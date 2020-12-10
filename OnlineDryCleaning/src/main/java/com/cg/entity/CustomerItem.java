package com.cg.entity;

import javax.persistence.Column;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "CUSTOMER_ITEM")


public class CustomerItem {
	@Id
	@Column(name = "ITEM_ID")
	private int itemId;
	@Column(name = "ITEM_NAME")
	private String name;
	@Column(name = "ITEM_COLOR")
	private String color;
	@Column(name = "ITEM_CATEGORY")
	private String category;
	@Column(name = "ITEM_QUANTITY")
	private int quantity;
	@Column(name = "ITEM_MATERIAL")
	private String material;
	@Column(name = "ITEM_DESCRIPTION")
	private String description;
    public CustomerItem() {
        super();
    }
	/*
	 * Parameterized constructor.
	 */

	public CustomerItem(int itemId, String name, String color, String category, int quantity, String material,
			String description) {
		super();
		this.itemId = itemId;
		this.name = name;
		this.color = color;
		this.category = category;
		this.quantity = quantity;
		this.material = material;
		this.description = description;
	}

	

	// getters and setters
	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "CustomerItem [itemId=" + itemId + ", name=" + name + ", color=" + color + ", category=" + category
				+ ", quantity=" + quantity + ", material=" + material + ", description=" + description + "]";
	}
	

}