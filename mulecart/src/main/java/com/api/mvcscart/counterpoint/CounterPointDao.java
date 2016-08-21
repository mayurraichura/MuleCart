package com.api.mvcscart.counterpoint;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.mule.util.CaseInsensitiveHashMap;

import com.api.mulecart.core.GoogleExcelSheet;
import com.api.mvcscart.categories.CsCartCategory;
import com.google.gdata.util.ServiceException;
import com.mulecart.products.CounterPointProducts;



/**
 * @author Srikanth vaddella
 * 
 * srikanth.vaddella@gmail.com
 *
 */
public class CounterPointDao {
	
	
	
	
	private GoogleExcelSheet excelSheet;
	
	/**
	 * @return the excelSheet
	 */
	public GoogleExcelSheet getExcelSheet() {
		return excelSheet;
	}


	/**
	 * @param excelSheet the excelSheet to set
	 */
	public void setExcelSheet(GoogleExcelSheet excelSheet) {
		this.excelSheet = excelSheet;
	}


	/**
	 * @param sourceCScartCategoriess
	 * @param destinationCounterPointCategories
	 * @return 
	 */
	
	public List<List<LinkedHashMap<String,String>> > insertOrUpdateList(
			java.util.ArrayList<List<LinkedHashMap<String,String>>> sourceCScartCategories,
			java.util.LinkedList<CaseInsensitiveHashMap> destinationCounterPointFolderCategories,
			java.util.LinkedList<CaseInsensitiveHashMap> destinationCounterPointSubFolderCategories) {
	
		//insertable records into from both ends
		ArrayList<List<LinkedHashMap<String,String>> > counterPointCategoriesInsertAndUpdate = new ArrayList<List<LinkedHashMap<String,String>> >();
		
		//insertable records into counterpoint
		List<LinkedHashMap<String,String> > counterPointCategoriesFolderInsertAndUpdate = new ArrayList<LinkedHashMap<String,String>>();
		List<LinkedHashMap<String,String> > counterPointCategoriesSubFolderInsertAndUpdate = new ArrayList<LinkedHashMap<String,String>>();
		
		//folder wise insert or update records
		List<LinkedHashMap<String,String>> counterPointFolderInsertList = new ArrayList<LinkedHashMap<String,String>>();
		List<LinkedHashMap<String,String>> counterPointFolderupdateList = new ArrayList<LinkedHashMap<String,String>>();
		List<LinkedHashMap<String,String>> counterPointSubFolderInsertList = new ArrayList<LinkedHashMap<String,String>>();
		List<LinkedHashMap<String,String>> counterPointSubFolderupdateList = new ArrayList<LinkedHashMap<String,String>>();
		
		//counterpoint records
		java.util.List<CsCartCategory> csCartFolderCategories = new ArrayList<CsCartCategory>();
		java.util.List<CsCartCategory> csCartSubFolderCategories = new ArrayList<CsCartCategory>();
		
		for (List<LinkedHashMap<String, String>> csCartList : sourceCScartCategories) {
			for (LinkedHashMap<String, String> csCortCategory : csCartList) {
				if(csCortCategory.get("id_path").split("/").length  == 1  ){
					counterPointCategoriesFolderInsertAndUpdate.add(csCortCategory);
				}else if(csCortCategory.get("id_path").split("/").length == 2 ){
					counterPointCategoriesSubFolderInsertAndUpdate.add(csCortCategory);
				}
			}
		}
		
		for (CaseInsensitiveHashMap linkedHashMap : destinationCounterPointFolderCategories) {
			csCartFolderCategories.add(new CsCartCategory(linkedHashMap.get("CATEG_COD").toString(), linkedHashMap.get("DESCR").toString()));
		}
		
		for (CaseInsensitiveHashMap linkedHashMap : destinationCounterPointSubFolderCategories) {
			csCartSubFolderCategories.add(new CsCartCategory(linkedHashMap.get("CATEG_COD").toString(), linkedHashMap.get("SUBCAT_COD").toString(), linkedHashMap.get("DESCR").toString()));
		}
		
		
		
		
		for (LinkedHashMap<String,String> counterPointCategoriesFolderInsertAndUpdateMap : counterPointCategoriesFolderInsertAndUpdate) {
			
				boolean recordFound = csCartFolderCategories.stream().anyMatch(
						p -> p.getCategory_id()
								.toString()
								.equalsIgnoreCase(
										counterPointCategoriesFolderInsertAndUpdateMap.get("category_id")
												.toString()));
				if (!recordFound) {
					counterPointFolderInsertList.add(counterPointCategoriesFolderInsertAndUpdateMap);
				} else {
					counterPointFolderupdateList.add(counterPointCategoriesFolderInsertAndUpdateMap);
				}
				
			}
			
		for (LinkedHashMap<String,String> counterPointCategoriesSubFolderInsertAndUpdateMap : counterPointCategoriesSubFolderInsertAndUpdate) {
			
			boolean recordFound = csCartSubFolderCategories.stream().anyMatch(
					p -> p.getParent_id()
							.toString()
							.equalsIgnoreCase(
									counterPointCategoriesSubFolderInsertAndUpdateMap.get("category_id")
											.toString()));
			if (!(recordFound)) {
				counterPointSubFolderInsertList.add(counterPointCategoriesSubFolderInsertAndUpdateMap);
			} else if(recordFound){
				counterPointSubFolderupdateList.add(counterPointCategoriesSubFolderInsertAndUpdateMap);
			}
			
		}
		counterPointCategoriesInsertAndUpdate.add(counterPointFolderInsertList);
		counterPointCategoriesInsertAndUpdate.add(counterPointFolderupdateList);
		counterPointCategoriesInsertAndUpdate.add(counterPointSubFolderInsertList);
		counterPointCategoriesInsertAndUpdate.add(counterPointSubFolderupdateList);
		
	    return counterPointCategoriesInsertAndUpdate;
		
	}
	

	public ArrayList<ArrayList<Map<String, String>>> counterPointProductsInsert(
			java.util.LinkedList<LinkedHashMap<String,String>> counterPointProducts,
			java.util.ArrayList<ArrayList<LinkedHashMap<String,String>>> csCortproducts,
			java.util.LinkedList<CaseInsensitiveHashMap> iminv) throws IOException, ServiceException {
		Set<String> readExcelSheet = excelSheet.readExcelSheet().get(0).keySet();
		HashMap<String, String> readExcelSheetLocId = excelSheet.readExcelSheet().get(0);
		//Return type from records with list
		ArrayList<ArrayList<Map<String, String>>> listOfRecordsIntoCounterPointEitherInsertorUpdate = new ArrayList<ArrayList<Map<String, String>>>();
		
		//prepare insert or update able records from list
		ArrayList<Map<String, String>> arrayListProductInsert = new ArrayList<Map<String, String>>();
		ArrayList<Map<String, String>> arrayListProductUpdate = new ArrayList<Map<String, String>>();
		ArrayList<Map<String, String>> arrayListProductIMINVINSERT = new ArrayList<Map<String, String>>();
	
		//create list of products for streaming perpose
		ArrayList<CounterPointProducts> listOfConterPointProducts = new ArrayList<CounterPointProducts>();

		for (Map<String,String> linkedHashMap : counterPointProducts) {
			listOfConterPointProducts.add(new CounterPointProducts(linkedHashMap.get(
					"ITEM_NO").toString(), linkedHashMap.get("DESCR").toString()));
		}

		for (ArrayList<LinkedHashMap<String, String>> counterPointProductsList : csCortproducts) {
		
		for (LinkedHashMap<String,String> cscartProductMap : counterPointProductsList) {
			
			boolean recordFound = listOfConterPointProducts.stream().anyMatch(
					p -> p.getITEM_NO()
							.toString()
							.equalsIgnoreCase(
									cscartProductMap.get("product_id")
											.toString()+"-"+(cscartProductMap.get("company_id").toString())));
		
			if ((recordFound) && (readExcelSheet.contains(cscartProductMap.get("company_id")))) {
				//TODO-READ DATA FORM EXCEL
				/*System.out.println(cscartProductMap.get("product_code") +"    "+
						cscartProductMap.get("product_id")
						.toString()+"-"+(cscartProductMap.get("company_id").toString()));*/
				arrayListProductUpdate.add(cscartProductMap);
			} else if ((!recordFound) && (readExcelSheet.contains(cscartProductMap.get("company_id")))){
				arrayListProductInsert.add(cscartProductMap);
				/*System.out.println(cscartProductMap.get("product_code") +"    "+
									cscartProductMap.get("product_id")
											.toString()+"-"+(cscartProductMap.get("company_id").toString()));*/
			}
			
		}
		}
		
		
		
		for (ArrayList<LinkedHashMap<String, String>> counterPointProductsList1 : csCortproducts) {
			
			for (LinkedHashMap<String,String> cscartProductMap1 : counterPointProductsList1) {
				
				boolean recordFound = iminv.stream().anyMatch(
						p -> p.get("ITEM_NO")
								.toString()
								.equalsIgnoreCase(
										cscartProductMap1.get("product_id")
												.toString()+"-"+(cscartProductMap1.get("company_id").toString())));
				if ((!(recordFound)) && (readExcelSheet.contains(cscartProductMap1.get("company_id")))) {
					cscartProductMap1.put("locid", readExcelSheetLocId.get(cscartProductMap1.get("company_id").toString()));
					arrayListProductIMINVINSERT.add(cscartProductMap1);
			      }
				
			}
			}
		
		listOfRecordsIntoCounterPointEitherInsertorUpdate.add(arrayListProductInsert);
		listOfRecordsIntoCounterPointEitherInsertorUpdate.add(arrayListProductUpdate);
		listOfRecordsIntoCounterPointEitherInsertorUpdate.add(arrayListProductIMINVINSERT);
		
		return listOfRecordsIntoCounterPointEitherInsertorUpdate;
	}
	
	
	
	
	
	
	
	/**
	 * @param insertableRecords
	 *//*
	public void insertCategoriesIntoDatabase(ArrayList<Map<String,String>> insertableRecords) {
	    Connection conn = null;
		PreparedStatement pstmt = null;
		try {
		  conn = createConnection();
	      for (Map<String, String> categories : insertableRecords) {
	     
	      String query = "INSERT INTO [dbo].[IM_CATEG_COD] ([CATEG_COD] ,[DESCR] ) values(?, ?)";
	      pstmt = conn.prepareStatement(query); 
	      pstmt.setString(1, categories.get("category"));
	      pstmt.setString(2, categories.get("desc")); 
	      pstmt.executeUpdate(); 
	      }
	    } catch (Exception exception) {
	    	exception.printStackTrace();
	    } finally {
	    	
	    	try {
	    		if(null != pstmt){
				pstmt.close();
	    		}
	    		if(null != conn){
					conn.close();
		    		}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	    	
	    }
	  }
	
		
	*//**
	 * @param updatableRecords
	 *//*
	public void updateCategoriesIntoCounterPart(ArrayList<Map<String,String>> updatableRecords){
	    Connection conn = null;
		PreparedStatement pstmt = null;
		try {
	      conn = createConnection();
	      for (Map<String, String> categories : updatableRecords) {
	      String query = "UPDATE [dbo].[IM_CATEG_COD] SET [DESCR] = ?  WHERE [CATEG_COD] = ? AND DESCR ! = ? ";
	
	      pstmt = conn.prepareStatement(query); 
	      pstmt.setString(1, categories.get("desc")); 
	      pstmt.setString(2, categories.get("category"));
	      pstmt.setString(3, categories.get("desc")); 
	     
	      pstmt.executeUpdate();
	      
	      }
	    } catch (Exception e) {
	      e.printStackTrace();
	    } finally {
	    	
	    	try {
	    		if(null != pstmt){
				pstmt.close();
	    		}
	    		if(null != conn){
					conn.close();
		    		}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();s
			}
			
	    	
	    }
	  }
	


	*//**
	 * @return
	 *//*
	public Connection createConnection() {
	      String connectionUrl = "jdbc:sqlserver://localhost:1433;user=sa;password=IN$01$SRI$CI;DataBaseName=KWRI";
		//String connectionUrl = "jdbc:sqlserver://64.251.10.132:1433;user=sa;password=terps.302!;DataBaseName=KWRI";
	      Connection connection = null;
	     
	         try {
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				connection = DriverManager.getConnection(connectionUrl);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return connection;
	}
	
*/
	
}