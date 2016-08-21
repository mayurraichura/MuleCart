/**
 * 
 */
package com.mulecart.core.exceptions;

import org.mule.api.MuleEvent;
import org.mule.api.exception.MessagingExceptionHandler;

/**
 * @author lenovo
 *
 */
public class CustomeException implements MessagingExceptionHandler {

	/* (non-Javadoc)
	 * @see org.mule.api.exception.MessagingExceptionHandler#handleException(java.lang.Exception, org.mule.api.MuleEvent)
	 */
	@Override
	public MuleEvent handleException(Exception exception, MuleEvent event) {
		
		//exception.getDetailedMessage();
		return event;
		// TODO Auto-generated method stub
		//exception.getStackTrace().toString()''
		//event.get
		//return exception.getStackTrace().toString();
		
	}

}
