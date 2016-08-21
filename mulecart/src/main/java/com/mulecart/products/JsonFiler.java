/**
 * 
 */
package com.mulecart.products;

import org.mule.api.MuleMessage;
import org.mule.api.routing.filter.Filter;

/**
 * @author lenovo
 *
 */
public class JsonFiler implements Filter {

	/* (non-Javadoc)
	 * @see org.mule.api.routing.filter.Filter#accept(org.mule.api.MuleMessage)
	 */
	@Override
	public boolean accept(MuleMessage message) {
		if (message.getPayload() instanceof java.util.ArrayList) {
			return true;			
		}
		return false;
	}

}
