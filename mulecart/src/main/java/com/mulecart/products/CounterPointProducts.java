/**
 * 
 */
package com.mulecart.products;

/**
 * @author srikanth vaddella
 * srikanth.vaddella@gmail.com
 *
 */
public class CounterPointProducts {

	
	/**
	 * @param iTEM_NO
	 * @param dESCR
	 */
	public CounterPointProducts(String iTEM_NO, String dESCR) {
		ITEM_NO = iTEM_NO;
		DESCR = dESCR;
	}


	private String ITEM_NO;
	private String DESCR;
	/**
	 * @return the iTEM_NO
	 */
	public String getITEM_NO() {
		return ITEM_NO;
	}
	/**
	 * @param iTEM_NO the iTEM_NO to set
	 */
	public void setITEM_NO(String iTEM_NO) {
		ITEM_NO = iTEM_NO;
	}
	/**
	 * @return the dESCR
	 */
	public String getDESCR() {
		return DESCR;
	}
	/**
	 * @param dESCR the dESCR to set
	 */
	public void setDESCR(String dESCR) {
		DESCR = dESCR;
	}
	
	
	
	
}
