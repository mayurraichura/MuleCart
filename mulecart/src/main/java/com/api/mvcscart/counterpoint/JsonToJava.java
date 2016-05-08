package com.api.mvcscart.counterpoint;

import java.util.List;

import org.codehaus.jackson.annotate.JsonAutoDetect;

/**
 * @author Srikanth
 *
 */

@JsonAutoDetect
public class JsonToJava {
	
	private List<Categories> categoriesList ;
    private Params paramsMap;
	
	
	/**
	 * @return the categoriesList
	 */
	public List<Categories> getCategoriesList() {
		return categoriesList;
	}
	/**
	 * @param categoriesList the categoriesList to set
	 */
	public void setCategoriesList(List<Categories> categoriesList) {
		this.categoriesList = categoriesList;
	}
	/**
	 * @return the paramsMap
	 */
	public Params getParamsMap() {
		return paramsMap;
	}
	/**
	 * @param paramsMap the paramsMap to set
	 */
	public void setParamsMap(Params paramsMap) {
		this.paramsMap = paramsMap;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	
	
	@Override
	public String toString() {
		return "JsonToJava [categoriesList=" + categoriesList + ", paramsMap="
				+ paramsMap + "]";
	}
	
	
	

}
