/**
 * 
 */
package com.api.mvcscart.transformers;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author Srikanth vaddella
 *
 */
public class Orders {
	
private String user_id = "0";
private String payment_id = "2";
private String shipping_id = "1";
private HashMap<String, HashMap<String, String>> products;
private User_data user_data;




/**
 * @return the user_id
 */
public String getUser_id() {
	return user_id;
}
/**
 * @param user_id the user_id to set
 */
public void setUser_id(String user_id) {
	this.user_id = user_id;
}
/**
 * @return the payment_id
 */
public String getPayment_id() {
	return payment_id;
}
/**
 * @param payment_id the payment_id to set
 */
public void setPayment_id(String payment_id) {
	this.payment_id = payment_id;
}
/**
 * @return the shipping_id
 */
public String getShipping_id() {
	return shipping_id;
}
/**
 * @param shipping_id the shipping_id to set
 */
public void setShipping_id(String shipping_id) {
	this.shipping_id = shipping_id;
}
/**
 * @return the products
 */
public HashMap<String, HashMap<String, String>> getProducts() {
	return products;
}
/**
 * @param hashMap the products to set
 */
public void setProducts(HashMap<String, HashMap<String, String>> hashMap) {
	this.products = hashMap;
}
/**
 * @return the user_data
 */
public User_data getUser_data() {
	return user_data;
}
/**
 * @param user_data the user_data to set
 */
public void setUser_data(User_data user_data) {
	this.user_data = user_data;
}




}
