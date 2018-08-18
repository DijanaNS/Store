package com.store.web.dto;

public class ShoppingCardDTO {
	private String orderingDate;
	private String deliveryDate;
	//private Long userId;
	private Integer totalPrice;
	private String status;

	public String getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(String deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

//	public Long getUserId() {
//		return userId;
//	}
//
//	public void setUserId(Long userId) {
//		this.userId = userId;
//	}

	public String getOrderingDate() {
		return orderingDate;
	}

	public void setOrderingDate(String orderingDate) {
		this.orderingDate = orderingDate;
	}

	public Integer getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Integer totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
