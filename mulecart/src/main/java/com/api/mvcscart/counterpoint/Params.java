package com.api.mvcscart.counterpoint;

import org.codehaus.jackson.annotate.JsonAutoDetect;

/**
 * @author Srikanth
 *
 */

@JsonAutoDetect
public class Params {
	
	 public String category_id;
	 public String visible;
	 public String current_category_id;
	 public String simple;
	 public String plain;
	 public String limit;
	 public String item_ids;
	 public String  group_by_level;
	 public String get_images;
	 public String category_delimiter;
	 public String get_frontend_urls;
	 public String max_nesting_level;
	 public String sort_order;
	 public String sort_by;
	 public String sort_order_rev;
	 public String  items_per_page;
	 public String page;
	 public String total_items;
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
	 * @return the visible
	 */
	public String getVisible() {
		return visible;
	}
	/**
	 * @param visible the visible to set
	 */
	public void setVisible(String visible) {
		this.visible = visible;
	}
	/**
	 * @return the current_category_id
	 */
	public String getCurrent_category_id() {
		return current_category_id;
	}
	/**
	 * @param current_category_id the current_category_id to set
	 */
	public void setCurrent_category_id(String current_category_id) {
		this.current_category_id = current_category_id;
	}
	/**
	 * @return the simple
	 */
	public String getSimple() {
		return simple;
	}
	/**
	 * @param simple the simple to set
	 */
	public void setSimple(String simple) {
		this.simple = simple;
	}
	/**
	 * @return the plain
	 */
	public String getPlain() {
		return plain;
	}
	/**
	 * @param plain the plain to set
	 */
	public void setPlain(String plain) {
		this.plain = plain;
	}
	/**
	 * @return the limit
	 */
	public String getLimit() {
		return limit;
	}
	/**
	 * @param limit the limit to set
	 */
	public void setLimit(String limit) {
		this.limit = limit;
	}
	/**
	 * @return the item_ids
	 */
	public String getItem_ids() {
		return item_ids;
	}
	/**
	 * @param item_ids the item_ids to set
	 */
	public void setItem_ids(String item_ids) {
		this.item_ids = item_ids;
	}
	/**
	 * @return the group_by_level
	 */
	public String getGroup_by_level() {
		return group_by_level;
	}
	/**
	 * @param group_by_level the group_by_level to set
	 */
	public void setGroup_by_level(String group_by_level) {
		this.group_by_level = group_by_level;
	}
	/**
	 * @return the get_images
	 */
	public String getGet_images() {
		return get_images;
	}
	/**
	 * @param get_images the get_images to set
	 */
	public void setGet_images(String get_images) {
		this.get_images = get_images;
	}
	/**
	 * @return the category_delimiter
	 */
	public String getCategory_delimiter() {
		return category_delimiter;
	}
	/**
	 * @param category_delimiter the category_delimiter to set
	 */
	public void setCategory_delimiter(String category_delimiter) {
		this.category_delimiter = category_delimiter;
	}
	/**
	 * @return the get_frontend_urls
	 */
	public String getGet_frontend_urls() {
		return get_frontend_urls;
	}
	/**
	 * @param get_frontend_urls the get_frontend_urls to set
	 */
	public void setGet_frontend_urls(String get_frontend_urls) {
		this.get_frontend_urls = get_frontend_urls;
	}
	/**
	 * @return the max_nesting_level
	 */
	public String getMax_nesting_level() {
		return max_nesting_level;
	}
	/**
	 * @param max_nesting_level the max_nesting_level to set
	 */
	public void setMax_nesting_level(String max_nesting_level) {
		this.max_nesting_level = max_nesting_level;
	}
	/**
	 * @return the sort_order
	 */
	public String getSort_order() {
		return sort_order;
	}
	/**
	 * @param sort_order the sort_order to set
	 */
	public void setSort_order(String sort_order) {
		this.sort_order = sort_order;
	}
	/**
	 * @return the sort_by
	 */
	public String getSort_by() {
		return sort_by;
	}
	/**
	 * @param sort_by the sort_by to set
	 */
	public void setSort_by(String sort_by) {
		this.sort_by = sort_by;
	}
	/**
	 * @return the sort_order_rev
	 */
	public String getSort_order_rev() {
		return sort_order_rev;
	}
	/**
	 * @param sort_order_rev the sort_order_rev to set
	 */
	public void setSort_order_rev(String sort_order_rev) {
		this.sort_order_rev = sort_order_rev;
	}
	/**
	 * @return the items_per_page
	 */
	public String getItems_per_page() {
		return items_per_page;
	}
	/**
	 * @param items_per_page the items_per_page to set
	 */
	public void setItems_per_page(String items_per_page) {
		this.items_per_page = items_per_page;
	}
	/**
	 * @return the page
	 */
	public String getPage() {
		return page;
	}
	/**
	 * @param page the page to set
	 */
	public void setPage(String page) {
		this.page = page;
	}
	/**
	 * @return the total_items
	 */
	public String getTotal_items() {
		return total_items;
	}
	/**
	 * @param total_items the total_items to set
	 */
	public void setTotal_items(String total_items) {
		this.total_items = total_items;
	}
	
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Params [category_id=" + category_id + ", visible=" + visible
				+ ", current_category_id=" + current_category_id + ", simple="
				+ simple + ", plain=" + plain + ", limit=" + limit
				+ ", item_ids=" + item_ids + ", group_by_level="
				+ group_by_level + ", get_images=" + get_images
				+ ", category_delimiter=" + category_delimiter
				+ ", get_frontend_urls=" + get_frontend_urls
				+ ", max_nesting_level=" + max_nesting_level + ", sort_order="
				+ sort_order + ", sort_by=" + sort_by + ", sort_order_rev="
				+ sort_order_rev + ", items_per_page=" + items_per_page
				+ ", page=" + page + ", total_items=" + total_items + "]";
	}

	 
	 
	 
}
