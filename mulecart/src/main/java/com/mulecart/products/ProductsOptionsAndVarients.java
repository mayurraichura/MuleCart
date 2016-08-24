/**
 * 
 */
package com.mulecart.products;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import org.mule.util.CaseInsensitiveHashMap;

/**
 * @author lenovo
 *
 */
public class ProductsOptionsAndVarients {
	
	private List<HashMap<String, String>> gridDimone   = new ArrayList<HashMap<String,String>>();
	private List<HashMap<String, String>> gridDimTwo   = new ArrayList<HashMap<String,String>>();
	private List<HashMap<String, String>> gridDimThree = new ArrayList<HashMap<String,String>>();
	private List<HashMap<String, String>> gridDimoneInsert   = new ArrayList<HashMap<String,String>>();
	private List<HashMap<String, String>> gridDimTwoInsert  = new ArrayList<HashMap<String,String>>();
	private List<HashMap<String, String>> gridDimThreeInsert = new ArrayList<HashMap<String,String>>();
	private List<HashMap<String, String>> gridDimoneUpdate   = new ArrayList<HashMap<String,String>>();
	private List<HashMap<String, String>> gridDimTwoUpdate  = new ArrayList<HashMap<String,String>>();
	private List<HashMap<String, String>> gridDimThreeUpdate = new ArrayList<HashMap<String,String>>();
	private List<HashMap<String, String>> imiteamProductOption = new ArrayList<HashMap<String,String>>();
	
	@Deprecated
	private List<HashMap<String, String>> listOfOptionIds = new ArrayList<HashMap<String,String>>();
	private List<HashMap<String, String>> listOfOptionAndVarientIds = new ArrayList<HashMap<String,String>>();
	
	java.util.LinkedList<CaseInsensitiveHashMap> invCellInsert = new LinkedList<CaseInsensitiveHashMap>();
	java.util.LinkedList<CaseInsensitiveHashMap> invCellUpDate = new LinkedList<CaseInsensitiveHashMap>();
	
	
	
	
	
	
	
	
	
	/**
	 * @return the invCellInsert
	 */
	public java.util.LinkedList<CaseInsensitiveHashMap> getInvCellInsert() {
		return invCellInsert;
	}
	/**
	 * @param invCellInsert the invCellInsert to set
	 */
	public void setInvCellInsert(
			java.util.LinkedList<CaseInsensitiveHashMap> invCellInsert) {
		this.invCellInsert = invCellInsert;
	}
	/**
	 * @return the invCellUpDate
	 */
	public java.util.LinkedList<CaseInsensitiveHashMap> getInvCellUpDate() {
		return invCellUpDate;
	}
	/**
	 * @param invCellUpDate the invCellUpDate to set
	 */
	public void setInvCellUpDate(
			java.util.LinkedList<CaseInsensitiveHashMap> invCellUpDate) {
		this.invCellUpDate = invCellUpDate;
	}
	/**
	 * @return the gridDimoneInsert
	 */
	public List<HashMap<String, String>> getGridDimoneInsert() {
		return gridDimoneInsert;
	}
	/**
	 * @param gridDimoneInsert the gridDimoneInsert to set
	 */
	public void setGridDimoneInsert(List<HashMap<String, String>> gridDimoneInsert) {
		this.gridDimoneInsert = gridDimoneInsert;
	}
	/**
	 * @return the gridDimTwoInsert
	 */
	public List<HashMap<String, String>> getGridDimTwoInsert() {
		return gridDimTwoInsert;
	}
	/**
	 * @param gridDimTwoInsert the gridDimTwoInsert to set
	 */
	public void setGridDimTwoInsert(List<HashMap<String, String>> gridDimTwoInsert) {
		this.gridDimTwoInsert = gridDimTwoInsert;
	}
	/**
	 * @return the gridDimThreeInsert
	 */
	public List<HashMap<String, String>> getGridDimThreeInsert() {
		return gridDimThreeInsert;
	}
	/**
	 * @param gridDimThreeInsert the gridDimThreeInsert to set
	 */
	public void setGridDimThreeInsert(
			List<HashMap<String, String>> gridDimThreeInsert) {
		this.gridDimThreeInsert = gridDimThreeInsert;
	}
	/**
	 * @return the gridDimoneUpdate
	 */
	public List<HashMap<String, String>> getGridDimoneUpdate() {
		return gridDimoneUpdate;
	}
	/**
	 * @param gridDimoneUpdate the gridDimoneUpdate to set
	 */
	public void setGridDimoneUpdate(List<HashMap<String, String>> gridDimoneUpdate) {
		this.gridDimoneUpdate = gridDimoneUpdate;
	}
	/**
	 * @return the gridDimTwoUpdate
	 */
	public List<HashMap<String, String>> getGridDimTwoUpdate() {
		return gridDimTwoUpdate;
	}
	/**
	 * @param gridDimTwoUpdate the gridDimTwoUpdate to set
	 */
	public void setGridDimTwoUpdate(List<HashMap<String, String>> gridDimTwoUpdate) {
		this.gridDimTwoUpdate = gridDimTwoUpdate;
	}
	/**
	 * @return the gridDimThreeUpdate
	 */
	public List<HashMap<String, String>> getGridDimThreeUpdate() {
		return gridDimThreeUpdate;
	}
	/**
	 * @param gridDimThreeUpdate the gridDimThreeUpdate to set
	 */
	public void setGridDimThreeUpdate(
			List<HashMap<String, String>> gridDimThreeUpdate) {
		this.gridDimThreeUpdate = gridDimThreeUpdate;
	}
	/**
	 * @return the listOfOptionIds
	 */
	@Deprecated
	public List<HashMap<String, String>> getListOfOptionIds() {
		return listOfOptionIds;
	}
	/**
	 * @param listOfOptionIds the listOfOptionIds to set
	 */
	@Deprecated
	public void setListOfOptionIds(List<HashMap<String, String>> listOfOptionIds) {
		this.listOfOptionIds = listOfOptionIds;
	}
	/**
	 * @return the listOfOptionAndVarientIds
	 */
	public List<HashMap<String, String>> getListOfOptionAndVarientIds() {
		return listOfOptionAndVarientIds;
	}
	/**
	 * @param listOfOptionAndVarientIds the listOfOptionAndVarientIds to set
	 */
	public void setListOfOptionAndVarientIds(
			List<HashMap<String, String>> listOfOptionAndVarientIds) {
		this.listOfOptionAndVarientIds = listOfOptionAndVarientIds;
	}
	/**
	 * @return the imiteamProductOption
	 */
	public List<HashMap<String, String>> getImiteamProductOption() {
		return imiteamProductOption;
	}
	/**
	 * @param imiteamProductOption the imiteamProductOption to set
	 */
	public void setImiteamProductOption(
			List<HashMap<String, String>> imiteamProductOption) {
		this.imiteamProductOption = imiteamProductOption;
	}
	/**
	 * @return the gridDimone
	 */
	public List<HashMap<String, String>> getGridDimone() {
		return gridDimone;
	}
	/**
	 * @param gridDimone the gridDimone to set
	 */
	public void setGridDimone(List<HashMap<String, String>> gridDimone) {
		this.gridDimone = gridDimone;
	}
	/**
	 * @return the gridDimTwo
	 */
	public List<HashMap<String, String>> getGridDimTwo() {
		return gridDimTwo;
	}
	/**
	 * @param gridDimTwo the gridDimTwo to set
	 */
	public void setGridDimTwo(List<HashMap<String, String>> gridDimTwo) {
		this.gridDimTwo = gridDimTwo;
	}
	/**
	 * @return the gridDimThree
	 */
	public List<HashMap<String, String>> getGridDimThree() {
		return gridDimThree;
	}
	/**
	 * @param gridDimThree the gridDimThree to set
	 */
	public void setGridDimThree(List<HashMap<String, String>> gridDimThree) {
		this.gridDimThree = gridDimThree;
	}
	
	
	

}
