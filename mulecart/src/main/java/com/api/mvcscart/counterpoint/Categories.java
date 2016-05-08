package com.api.mvcscart.counterpoint;

import org.codehaus.jackson.annotate.JsonAutoDetect;

/**
 * @author Srikanth
 * It is going to Represent the categories from cs cart
 */

@JsonAutoDetect
public class Categories {
	
	public String category_id;
    public String parent_id ;
    public String id_path;
    public String category;
    public String position;
    public String status;
    public String product_count;
    public String seo_name;
    public String seo_path;
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
	 * @return the id_path
	 */
	public String getId_path() {
		return id_path;
	}
	/**
	 * @param id_path the id_path to set
	 */
	public void setId_path(String id_path) {
		this.id_path = id_path;
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
	/**
	 * @return the position
	 */
	public String getPosition() {
		return position;
	}
	/**
	 * @param position the position to set
	 */
	public void setPosition(String position) {
		this.position = position;
	}
	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	/**
	 * @return the product_count
	 */
	public String getProduct_count() {
		return product_count;
	}
	/**
	 * @param product_count the product_count to set
	 */
	public void setProduct_count(String product_count) {
		this.product_count = product_count;
	}
	/**
	 * @return the seo_name
	 */
	public String getSeo_name() {
		return seo_name;
	}
	/**
	 * @param seo_name the seo_name to set
	 */
	public void setSeo_name(String seo_name) {
		this.seo_name = seo_name;
	}
	/**
	 * @return the seo_path
	 */
	public String getSeo_path() {
		return seo_path;
	}
	/**
	 * @param seo_path the seo_path to set
	 */
	public void setSeo_path(String seo_path) {
		this.seo_path = seo_path;
	}
	
	
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Categories [category_id=" + category_id + ", parent_id="
				+ parent_id + ", id_path=" + id_path + ", category=" + category
				+ ", position=" + position + ", status=" + status
				+ ", product_count=" + product_count + ", seo_name=" + seo_name
				+ ", seo_path=" + seo_path + "]";
	}
    
    
    
	

}
