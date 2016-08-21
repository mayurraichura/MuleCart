/**
 * 
 */
package com.api.mvcscart.categories;

/**
 * @author srikanth vaddella
 * srikanth.vaddella@gmail.com
 *
 */
public class CsCartCategory {

	
	private String category_id;
    private String parent_id;
    private String category;
    
    
    
	/**
	 * @param category_id
	 * @param category
	 */
	public CsCartCategory(String category_id, String category) {
		this.category_id = category_id;
		this.category = category;
	}


	/**
	 * @param category_id
	 * @param parent_id
	 * @param category
	 */
	public CsCartCategory(String category_id, String parent_id, String category) {
		this.category_id = category_id;
		this.parent_id = parent_id;
		this.category = category;
	}
	
	
	/**
	 * @return the category_id
	 */
	public String getCategory_id() {
		return category_id;
	}
	/**
	 * @param category_id the category_id to set
	 */
	public void setCategory_id(String category_id) {
		this.category_id = category_id;
	}
	/**
	 * @return the parent_id
	 */
	public String getParent_id() {
		return parent_id;
	}
	/**
	 * @param parent_id the parent_id to set
	 */
	public void setParent_id(String parent_id) {
		this.parent_id = parent_id;
	}
	/**
	 * @return the category
	 */
	public String getCategory() {
		return category;
	}
	/**
	 * @param category the category to set
	 */
	public void setCategory(String category) {
		this.category = category;
	}
    
    
    
    
    
	
	
}
