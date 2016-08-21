/**
 * 
 */
package com.api.mulecart.core;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

import com.google.gdata.client.spreadsheet.SpreadsheetService; 
import com.google.gdata.data.spreadsheet.CustomElementCollection;
import com.google.gdata.data.spreadsheet.ListEntry; 
import com.google.gdata.data.spreadsheet.ListFeed; 
import com.google.gdata.util.ServiceException; 

/**
 * @author srikanth vaddella
 *
 */
public class GoogleExcelSheet {
	
	/**
	 * @return
	 * @throws IOException
	 * @throws ServiceException
	 */
	public ArrayList<HashMap<String, String>> readExcelSheet() throws IOException, ServiceException  {
			SpreadsheetService service = new SpreadsheetService("CompanyIds");
			ArrayList<HashMap<String,String>> listOfLocIdCompanyIds = new ArrayList<HashMap<String,String>>();
			HashMap<String, String> hashMap = new HashMap<String, String>();
			String sheetUrl = "https://spreadsheets.google.com/feeds/list/1Wx79V4pFoHXxXqSdnoV7ukoiR-YqPinnABnnCqHC1Sk/default/public/values";
			URL url = new URL(sheetUrl); 
			ListFeed lf = service.getFeed(url, ListFeed.class); 
			for (ListEntry le : lf.getEntries()) {
				
				CustomElementCollection cec = le.getCustomElements(); 
				String companyId = cec.getValue("companyid");
				String locId = cec.getValue("locid");
				hashMap.put(companyId, locId);
				 
			}
			listOfLocIdCompanyIds.add(hashMap);
			return listOfLocIdCompanyIds;
			}
	
	
	/*public static void main(String args[]) throws IOException, ServiceException{
		
		GoogleExcelSheet excelSheet = new GoogleExcelSheet();
		excelSheet.readExcelSheet();
	}*/
}
