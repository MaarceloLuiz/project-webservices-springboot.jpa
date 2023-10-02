package com.webservicesproject.project.entities.enums;

public enum OrderStatus {
	
	WAITING_PAYMENT(1),
	PAID(2),
	SHIPPED(3),
	DELIVERED(4),
	CANCELED(5);
	
	private int code;
	
	private OrderStatus(int code){
		this.code = code;
	}
	
	public int getCode() {
		return code;
	}
	
	//returning the value according to the code number you type in
	public static OrderStatus valueOf(int code) {
		for(OrderStatus value : OrderStatus.values()) {
			if(value.getCode() == code ) {
				return value;
			}
		}
		//in case the method finds no value for the code
		throw new IllegalArgumentException("Invalid OrderStatus code");
	}
}
