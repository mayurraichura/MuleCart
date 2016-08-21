/**
 * 
 */
package com.api.mulecart.core;

import org.mule.api.MuleEvent;
import org.mule.api.exception.MessagingExceptionHandler;

/**
 * @author lenovo
 *
 */
public class EmailNotification implements MessagingExceptionHandler {

	/* (non-Javadoc)
	 * @see org.mule.api.exception.MessagingExceptionHandler#handleException(java.lang.Exception, org.mule.api.MuleEvent)
	 */
	@Override
	public MuleEvent handleException(Exception exception, MuleEvent event) {
		// TODO Auto-generated method stub
		return event;
	}

}
