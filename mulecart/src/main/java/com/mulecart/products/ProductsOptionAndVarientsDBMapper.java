/**
 * 
 */
package com.mulecart.products;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

import org.mule.util.CaseInsensitiveHashMap;

/**
 * @author srikanth vaddella Email : srikanth.vaddella@gmail.com Created 
 * version 1.0 
 * Reason : Product Option's and Variants on CounterPoint
 *
 */
public class ProductsOptionAndVarientsDBMapper {

private ProductsOptionsAndVarients productsOptionAndVarients;


	/**
	 * @param listOfProductVarientsAndOptions
	 * Date : 04/06/2016
	 * version : 1.0
	 */
	
	@SuppressWarnings("unchecked")
	public ProductsOptionsAndVarients cscartProductOptionsAndVarients(java.util.ArrayList<LinkedHashMap<String,LinkedHashMap<String,Object>>> listOfProductVarientsAndOptions,
			ArrayList  listOfVarientsAndOptions) {
		productsOptionAndVarients  =  new ProductsOptionsAndVarients();
		
		for ( LinkedHashMap<String,LinkedHashMap<String, Object>> productsWithOptionsAndVarients : listOfProductVarientsAndOptions) {
			Collection<LinkedHashMap<String, Object>> productsWithOptionsAndVarientsInerator = (Collection<LinkedHashMap<String, Object>>) productsWithOptionsAndVarients.values();
			HashMap<String,String> imIteamProductOptionsMap =  new HashMap<String,String>();
			LinkedHashMap<String, Object> optionsAndVarients = null;
			boolean optionType = true;
			for (int k = 0; k < productsWithOptionsAndVarientsInerator.size(); k++) {
				if(k < 3){
					optionsAndVarients = (LinkedHashMap<String, Object>) productsWithOptionsAndVarientsInerator.toArray()[k];
					String optionTypeFromSource = (String)optionsAndVarients.get("option_type");
					
					if((("T".equalsIgnoreCase(optionTypeFromSource)))){
						optionType 	= false;
					}
					if(("I".equalsIgnoreCase(optionTypeFromSource))){
						optionType 	= false;
					}
				}
				
			}
			
			if(optionType){
			for (int J = 0; J < productsWithOptionsAndVarientsInerator.size(); J++) {
				if(J < 3){
				optionsAndVarients = (LinkedHashMap<String, Object>) productsWithOptionsAndVarientsInerator.toArray()[J];
				if(optionsAndVarients.containsKey("variants")){
				if((!("T".equalsIgnoreCase((String)optionsAndVarients.get("option_type"))))){
					if(!("I".equalsIgnoreCase((String)optionsAndVarients.get("option_type")))){
				String iteamNO = optionsAndVarients.get("product_id")+"-"+optionsAndVarients.get("company_id");
				String optionId = (String)optionsAndVarients.get("option_id");
				Object optionName = optionsAndVarients.get("option_name");
				
				imIteamProductOptionsMap.put("grid_ent_"+(J+1),(String.valueOf(Integer.valueOf((String) optionsAndVarients.get("position"))+1)).toUpperCase());
				imIteamProductOptionsMap.put("grid_dim_"+(J+1)+"_tag",(((optionName.toString().length() > 10  )) ? ((String)optionName.toString().substring(0,9)):((String)optionName)).toUpperCase());
				imIteamProductOptionsMap.put("ITEM_NO",iteamNO);
				
				imIteamProductOptionsMap.put("OPTION_ID",optionId);
				//TODO -  ADD OPTION TYPE IS T RECORD INTO AUDIT TABLE
				if((optionsAndVarients.get("variants").toString().length() > 0)){
					LinkedHashMap<String, ArrayList<LinkedHashMap<String,String>>> varients=null;
					 Object[] varientObjects = null;
					
					try{
				 varients = (LinkedHashMap<String,ArrayList<LinkedHashMap<String,String>>>) optionsAndVarients.get("variants");
				  varientObjects =  (Object[]) varients.values().toArray();
					}catch(Exception exception){
						
				}
					
								
			if(!(null == varientObjects)){
				int c=0;
				for (int i = 0; i < varientObjects.length; i++) {
					LinkedHashMap<String,String> varientsMap = (LinkedHashMap<String,String>)varientObjects[i];
					String variantID = varientsMap.get("variant_id");
					int varientNameLength = varientsMap.get("variant_name").length();
					String dimInforMation = (13 < varientNameLength?((varientsMap.get("variant_name")).substring(varientNameLength-13, varientNameLength)):(varientsMap.get("variant_name")));
					String dimSequenceNum = (String.valueOf((Integer.valueOf(varientsMap.get("position"))+1)));
					
					if(J == 0){
						HashMap<String,String> gridDimoneMap = new HashMap<String,String>();
						    gridDimoneMap.put("ITEM_NO", iteamNO);
							gridDimoneMap.put("DIM_1", dimInforMation.toUpperCase());
							gridDimoneMap.put("DIM_1_SEQ_NO", dimSequenceNum);
							gridDimoneMap.put("option_id",optionId);
							gridDimoneMap.put("variant_id", variantID);
							productsOptionAndVarients.getGridDimone().add(gridDimoneMap);
					}if(J == 1){
						
						HashMap<String,String> gridDimTwoMap = new HashMap<String,String>();
					   		gridDimTwoMap.put("ITEM_NO", iteamNO);
					   		gridDimTwoMap.put("DIM_2", dimInforMation.toUpperCase());
					   		gridDimTwoMap.put("DIM_2_SEQ_NO", dimSequenceNum);
					   		gridDimTwoMap.put("option_id",optionId);
					   		gridDimTwoMap.put("variant_id", variantID);
					   		productsOptionAndVarients.getGridDimTwo().add(gridDimTwoMap);
					   		
					}if(J == 2){
						HashMap<String,String> gridDimThreeMap = new HashMap<String,String>();
							gridDimThreeMap.put("ITEM_NO", iteamNO);
							gridDimThreeMap.put("DIM_3", dimInforMation.toUpperCase());
							gridDimThreeMap.put("DIM_3_SEQ_NO", dimSequenceNum);
							gridDimThreeMap.put("option_id",optionId);
							gridDimThreeMap.put("variant_id", variantID);
							productsOptionAndVarients.getGridDimThree().add(gridDimThreeMap);
					}if(productsWithOptionsAndVarientsInerator.size() > 0 && productsWithOptionsAndVarientsInerator.size() < 3){
					
						if(c==0){
							if(productsWithOptionsAndVarientsInerator.size() == 2){
							c = 1;
							HashMap<String,String> gridDimThreeMap1 = new HashMap<String,String>();
								gridDimThreeMap1.put("ITEM_NO", iteamNO);
								gridDimThreeMap1.put("DIM_3", "*");
								gridDimThreeMap1.put("DIM_3_SEQ_NO", "");
								gridDimThreeMap1.put("option_id","*");
								gridDimThreeMap1.put("variant_id", "*");
								productsOptionAndVarients.getGridDimThree().add(gridDimThreeMap1);
							}else if(productsWithOptionsAndVarientsInerator.size() == 1){
								c = 1;
								HashMap<String,String> gridDimTwoMap1 = new HashMap<String,String>();
								gridDimTwoMap1.put("ITEM_NO", iteamNO);
								gridDimTwoMap1.put("DIM_2", "*");
								gridDimTwoMap1.put("DIM_3_SEQ_NO", "");
								gridDimTwoMap1.put("option_id","*");
								gridDimTwoMap1.put("variant_id", "*");
								productsOptionAndVarients.getGridDimTwo().add(gridDimTwoMap1);
								
								HashMap<String,String> gridDimThreeMap2 = new HashMap<String,String>();
								gridDimThreeMap2.put("ITEM_NO", iteamNO);
								gridDimThreeMap2.put("DIM_3", "*");
								gridDimThreeMap2.put("DIM_3_SEQ_NO", "");
								gridDimThreeMap2.put("option_id","*");
								gridDimThreeMap2.put("variant_id", "*");
								productsOptionAndVarients.getGridDimThree().add(gridDimThreeMap2);
								
							}
						}
						//break;
			}	
				}
				
				
				}
				}}
				}}}else{
					break;
				}
				
			}}
			productsOptionAndVarients.getImiteamProductOption().add(imIteamProductOptionsMap);
	}
		return verifyDataWithDBTableData(productsOptionAndVarients,listOfVarientsAndOptions);
	}
	
	
	
	/**
	 * @param productsOptionAndVarients2
	 * @param listOfVarientsAndOptions
	 * @return
	 */
	public ProductsOptionsAndVarients verifyDataWithDBTableData(ProductsOptionsAndVarients productsOptionAndVarients2, ArrayList<LinkedList<CaseInsensitiveHashMap>> listOfVarientsAndOptions){
	
		ArrayList<HashMap<String, String>> listOfMapsOnImIteam = new ArrayList<HashMap<String, String>>();
		for (HashMap<String, String> linkedList : productsOptionAndVarients2.getImiteamProductOption()) {
			if(!(linkedList.isEmpty())){
				listOfMapsOnImIteam.add(linkedList);
			}
			
		}
		
		productsOptionAndVarients2.getImiteamProductOption().clear();
		productsOptionAndVarients2.setImiteamProductOption(listOfMapsOnImIteam);
		
		for (HashMap<String, String>  gridOne : productsOptionAndVarients2.getGridDimone()) {
			boolean recordFound = listOfVarientsAndOptions.get(0).stream().anyMatch(option->(((null != option.get("ITEM_NO"))? ((String) option.get("ITEM_NO").toString().trim()):"")+((null != option.get("USR_OPTION_ID"))? ((String) option.get("USR_OPTION_ID").toString().trim()):"")+((null != option.get("USR_VARIANT_ID"))? ((String) option.get("USR_VARIANT_ID").toString().trim()):"")).equalsIgnoreCase(gridOne.get("ITEM_NO")+gridOne.get("option_id")+gridOne.get("variant_id")));
			if (!recordFound) {
				productsOptionAndVarients2.getGridDimoneInsert().add(gridOne);
			} else {
				productsOptionAndVarients2.getGridDimoneUpdate().add(gridOne);
			}
			
		}
		
		for (HashMap<String, String>  gridTwo : productsOptionAndVarients2.getGridDimTwo()) {
			boolean recordFound = listOfVarientsAndOptions.get(1).stream().anyMatch(option->(((null != option.get("ITEM_NO"))? ((String) option.get("ITEM_NO").toString().trim()):"")+((null != option.get("USR_OPTION_ID"))?((String) option.get("USR_OPTION_ID").toString().trim()):"")+((null != option.get("USR_VARIANT_ID"))? ((String) option.get("USR_VARIANT_ID").toString().trim()):"")).equalsIgnoreCase(gridTwo.get("ITEM_NO")+gridTwo.get("option_id")+gridTwo.get("variant_id")));
			if (!recordFound) {
				productsOptionAndVarients2.getGridDimTwoInsert().add(gridTwo);
			} else {
				productsOptionAndVarients2.getGridDimTwoUpdate().add(gridTwo);
			}
			
		}
		
		for (HashMap<String, String>  gridThree : productsOptionAndVarients2.getGridDimThree()) {
			boolean recordFound = listOfVarientsAndOptions.get(2).stream().anyMatch(option->(((null != option.get("ITEM_NO"))? ((String) option.get("ITEM_NO").toString().trim()):"")+((null != option.get("USR_OPTION_ID"))? ((String) option.get("USR_OPTION_ID").toString().trim()):"")+((null != option.get("USR_VARIANT_ID"))? ((String) option.get("USR_VARIANT_ID").toString().trim()):"")).equalsIgnoreCase(gridThree.get("ITEM_NO")+gridThree.get("option_id")+gridThree.get("variant_id")));
			if (!recordFound) {
				productsOptionAndVarients2.getGridDimThreeInsert().add(gridThree);
			} else {
				productsOptionAndVarients2.getGridDimThreeUpdate().add(gridThree);
			}
			
		}
		
		return productsOptionAndVarients2;
	}
	
	
	
	
	
	/**
	 * @param optionsAndVarients
	 * @return
	 */
	
	public ProductsOptionsAndVarients prepareCombinationsForVarients(java.util.LinkedList<CaseInsensitiveHashMap> combinations_From_CP,
			                               java.util.LinkedList<CaseInsensitiveHashMap>  Prepared_Combinations_From_CP_Prepared){
		ProductsOptionsAndVarients combinatinos = new ProductsOptionsAndVarients();
		java.util.LinkedList<CaseInsensitiveHashMap> invCellInsert = new LinkedList<>();
		java.util.LinkedList<CaseInsensitiveHashMap> invCellUpDate = new LinkedList<>();
		
		for (CaseInsensitiveHashMap p_Combination : Prepared_Combinations_From_CP_Prepared) {
			
			if(! (null == (p_Combination.get("DIM1_OPTION_ID"))) 
					&& (!(null == p_Combination.get("DIM2_OPTION_ID")))
					&& (!(null == p_Combination.get("DIM1_VARIENTID")))
					&& (!(null == p_Combination.get("DIM2_VARIENTID")))){
			
			if(! ("*".equalsIgnoreCase(p_Combination.get("DIM1_OPTION_ID").toString().trim())) 
					&& (!("*".equalsIgnoreCase(p_Combination.get("DIM2_OPTION_ID").toString().trim())))
					&& (!("*".equalsIgnoreCase(p_Combination.get("DIM1_VARIENTID").toString().trim())))
					&& (!("*".equalsIgnoreCase( p_Combination.get("DIM2_VARIENTID").toString().trim())))){
			boolean recordFound = combinations_From_CP.stream().anyMatch(preparedCombination ->			
			((preparedCombination.get("ITEM_NO")).toString()+(!(null == preparedCombination.get("USR_DIM1_OPTION_ID"))?(preparedCombination.get("USR_DIM1_OPTION_ID")).toString():"")+(!(null == preparedCombination.get("USR_DIM2_OPTION_ID"))?(preparedCombination.get("USR_DIM2_OPTION_ID")).toString():"")+(!(null == preparedCombination.get("USR_DIM3_OPTION_ID"))?(preparedCombination.get("USR_DIM3_OPTION_ID")).toString():"")+(!(null == preparedCombination.get("USR_DIM1_VARIANT_ID"))?(preparedCombination.get("USR_DIM1_VARIANT_ID")).toString():"")+(!(null == preparedCombination.get("USR_DIM2_VARIANT_ID"))?(preparedCombination.get("USR_DIM2_VARIANT_ID")).toString():"")+(!(null == preparedCombination.get("USR_DIM3_VARIANT_ID"))?(preparedCombination.get("USR_DIM3_VARIANT_ID")).toString():""))
			.equalsIgnoreCase((p_Combination.get("itemno")).toString()+(!(null == p_Combination.get("DIM1_OPTION_ID"))?p_Combination.get("DIM1_OPTION_ID").toString():"")+(!(null == p_Combination.get("DIM2_OPTION_ID"))?p_Combination.get("DIM2_OPTION_ID").toString():"")+(!(null == p_Combination.get("DIM3_OPTION_ID"))?p_Combination.get("DIM3_OPTION_ID").toString():"")+(!(null == p_Combination.get("DIM1_VARIENTID"))?p_Combination.get("DIM1_VARIENTID").toString():"")+(!(null == p_Combination.get("DIM2_VARIENTID"))?p_Combination.get("DIM2_VARIENTID").toString():"")+(!(null == p_Combination.get("DIM3_VARIENTID"))?p_Combination.get("DIM3_VARIENTID").toString():"")));
		
		if(!(recordFound)){
			combinatinos.getInvCellInsert().add(p_Combination);
		}else{
			combinatinos.getInvCellUpDate().add(p_Combination);
		}
			}}}
		
		return combinatinos;
		
	}
	
	
	/**
	 * @param optionsAndVarients
	 * @return
	 */
	
	public ArrayList<ArrayList<HashMap<String, String>>> combinationsStatusUpdator(java.util.ArrayList<java.util.ArrayList<LinkedHashMap<String,Object>>>  combinations_From_cs,
			java.util.List<CaseInsensitiveHashMap> combinations_From_cp){
		java.util.ArrayList<HashMap<String,String>> combinationStatusAvalible = new ArrayList<HashMap<String,String>>();
		for (java.util.ArrayList<LinkedHashMap<String,Object>> combination_From_cs : combinations_From_cs) {
			for (LinkedHashMap<String, Object> linkedHashMap : combination_From_cs) {
				HashMap<String,String> hashMap = new HashMap<String, String>();
				Set optionAndVarients =  ((Map) linkedHashMap.get("combination")).entrySet();
				//hashMap.put("optionId", optionAndVarients[0]);
				//hashMap.put("varientId", optionAndVarients[1]);
				boolean status = false;
				for (int i = 0; i < optionAndVarients.size(); i++) {
					String[] string = optionAndVarients.toArray()[i].toString().split("=");
					hashMap.put("optionId"+(i+1), string[0]);
					hashMap.put("varientId"+(i+1),string[1]);
					
					if((1 == optionAndVarients.size()) && !status){
						status = true;
						hashMap.put("optionId2", "*");
						hashMap.put("varientId2", "*");
						
						hashMap.put("optionId3", "*");
						hashMap.put("varientId3","*");
					}
					
					if((2 == optionAndVarients.size()) && !status){
						status = true;
						hashMap.put("optionId3", "*");
						hashMap.put("varientId3","*");
						
					}
				}
				hashMap.put("product_id", (String)linkedHashMap.get("product_id"));
				hashMap.put("product_code", (String)linkedHashMap.get("product_code"));
				hashMap.put("combination_hash", (String)linkedHashMap.get("combination_hash"));
				combinationStatusAvalible.add(hashMap);
			}
		}
		
		ArrayList<ArrayList<HashMap<String,String>>> list = new ArrayList<ArrayList<HashMap<String,String>>>();
		ArrayList<HashMap<String,String>> itemFound = new ArrayList<HashMap<String,String>>();
		ArrayList<HashMap<String,String>> itemNotFound = new ArrayList<HashMap<String,String>>();
		
		for (CaseInsensitiveHashMap hashMap : combinations_From_cp) {
			HashMap<String,String> updateAableMap = new HashMap<String, String>();
			String varientId1 = hashMap.get("USR_DIM1_VARIANT_ID").toString().trim();
			String varientId2 = hashMap.get("USR_DIM2_VARIANT_ID").toString().trim();
			String varientId3 = hashMap.get("USR_DIM3_VARIANT_ID").toString().trim();
			String optionId1 = hashMap.get("USR_DIM1_OPTION_ID").toString().trim();
			String optionId2 = hashMap.get("USR_DIM2_OPTION_ID").toString().trim();
			String optionId3 = hashMap.get("USR_DIM3_OPTION_ID").toString().trim();
			boolean found = combinationStatusAvalible.stream().anyMatch(cp->(cp.get("varientId1")+cp.get("varientId2")+cp.get("varientId3"))
					.equalsIgnoreCase(varientId1+varientId2+varientId3));
			updateAableMap.put("varientId1", varientId1);
			updateAableMap.put("varientId2", varientId2);
			updateAableMap.put("varientId3", varientId3);
			updateAableMap.put("optionId1", optionId1);
			updateAableMap.put("optionId2", optionId2);
			updateAableMap.put("optionId3", optionId3);
			updateAableMap.put("ITEM_NO", hashMap.get("ITEM_NO").toString());
			
			if(found){
				itemFound.add(updateAableMap);
			}else if(!found){
				itemNotFound.add(updateAableMap);
			}
			
		}
		list.add(itemFound);
		list.add(itemNotFound);
		return list;
		
	}
}
	
	
	
	
	
	
	

