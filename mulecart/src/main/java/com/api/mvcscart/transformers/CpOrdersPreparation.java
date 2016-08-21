/**
 * 
 */
package com.api.mvcscart.transformers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.stream.Collectors;

import org.mule.util.CaseInsensitiveHashMap;

/**
 * @author srikanth vaddella
 *
 */
public class CpOrdersPreparation {
	
	

	public ArrayList<HashMap<String,Object>> OrderPreparaiton(java.util.LinkedList<CaseInsensitiveHashMap> listOfOrders){
		ArrayList<String> arrayList = new ArrayList<String>();
		ArrayList<HashMap<String,Object>> orders = new ArrayList<HashMap<String,Object>>();
		
		for (CaseInsensitiveHashMap caseInsensitiveHashMap : listOfOrders) {
			HashMap<String,Object> orderMap = new HashMap<String, Object>();
			String doc_id = caseInsensitiveHashMap.get("DOC_ID").toString();
			if(!(arrayList.contains(doc_id))){
			Orders order = new Orders();
			User_data user_data = new User_data();
			user_data.setEmail(caseInsensitiveHashMap.get("email").toString());
			user_data.setFirstname(caseInsensitiveHashMap.get("firstname").toString());
			user_data.setLastname(caseInsensitiveHashMap.get("lastname").toString());
			
			user_data.setS_firstname(caseInsensitiveHashMap.get("s_firstname").toString());
			user_data.setS_lastname(caseInsensitiveHashMap.get("s_lastname").toString());
			user_data.setS_country(caseInsensitiveHashMap.get("s_country").toString());
			user_data.setS_city(caseInsensitiveHashMap.get("s_city").toString());
			user_data.setS_state(caseInsensitiveHashMap.get("s_state").toString());
			user_data.setS_zipcode(caseInsensitiveHashMap.get("s_zipcode").toString());
			user_data.setS_address(caseInsensitiveHashMap.get("s_address").toString());
			
			user_data.setB_firstname(caseInsensitiveHashMap.get("b_firstname").toString());
			user_data.setB_lastname(caseInsensitiveHashMap.get("b_lastname").toString());
			user_data.setB_country(caseInsensitiveHashMap.get("s_country").toString());
			user_data.setB_city(caseInsensitiveHashMap.get("s_city").toString());
			user_data.setB_state(caseInsensitiveHashMap.get("b_state").toString());
			user_data.setB_zipcode(caseInsensitiveHashMap.get("b_zipcode").toString());
			user_data.setB_address(caseInsensitiveHashMap.get("b_address").toString());			
			
			order.setUser_data(user_data );	
			arrayList.add(doc_id);
		
			HashMap<String,HashMap<String,String>> hashMap = new HashMap<String, HashMap<String,String>>();
			for (CaseInsensitiveHashMap caseInsensitiveHashMa2 : listOfOrders) {
				if(doc_id.equalsIgnoreCase(caseInsensitiveHashMa2.get("DOC_ID").toString())){
					
					HashMap<String, String> value = new HashMap<String, String>();
					 String product_id = caseInsensitiveHashMa2.get("ITEM_NO").toString();
					 value.put("product_id", product_id);
					 value.put("amount", caseInsensitiveHashMa2.get("QTY_SOLD").toString());
					 value.put("price", caseInsensitiveHashMa2.get("PRC").toString());
					 hashMap.put(product_id, value);
					
				}else{
					
				}
			}
			
			order.setProducts(hashMap);
			orderMap.put("docid", doc_id);
			orderMap.put("order", order);
			
			orders.add(orderMap);
			
			
		}
	}
		return orders;
		
	}

}
