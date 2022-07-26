/**
 * The LoggingAspect class implements an application that
 * displays log for each and every method configured in application
 *
 * @author Neelsys - ChandraM/L
 */

package com.neelsys.aspect;

import java.util.List;
import org.aspectj.lang.JoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggingAspect {

	private static final Logger log = LoggerFactory
			.getLogger(LoggingAspect.class);

	private static final String SEPERATOR = "\n----------------------------------------";

	/**
	 * This method is used to print log after method execution
	 * 
	 * @param jointPoint
	 *            is a joinPoint argument which identifies complete method
	 *            information at execution point
	 */
	public void logAfterMethod(JoinPoint jointPoint) {

		StringBuffer logStr = new StringBuffer();

		logStr.append("\nInvoking After Method: \nMethod Full Signature : "
				+ jointPoint.getSignature().toLongString() + "\nName : "
				+ jointPoint.getSignature().getName() + SEPERATOR);

		log.debug(logStr.toString());
	}

	/**
	 * This method is used to print log before method execution
	 * 
	 * @param jointPoint
	 *            is a joinPoint argument which identifies complete method
	 *            information at execution point
	 */
	public void logBeforeMethod(JoinPoint jointPoint) {
		StringBuffer logStr = new StringBuffer();

		logStr.append("\nInvoking Before Method: \nMethod Full Signature : "
				+ jointPoint.getSignature().toLongString() + "\nName : "
				+ jointPoint.getSignature().getName()
				+ "\nArguments Passed are :");

		for (Object arg : jointPoint.getArgs()) {

			if (arg != null)
				logStr.append("  " + arg.toString());
		}

		logStr.append(SEPERATOR);

		log.debug(logStr.toString());
	}

	/**
	 * This method is used to print log after returning arguments from method
	 * execution
	 * 
	 * @param jointPoint
	 *            is a joinPoint argument which identifies complete method
	 *            information at execution point
	 * 
	 * @param result
	 *            is an argument which results the returned object value from
	 *            method at execution point
	 */
	public void logAfterReturningMethod(JoinPoint jointPoint, Object result) {

		StringBuffer logStr = new StringBuffer();

		logStr.append("\nAOP calling Returning Method: \nMethod Full Signature : "
				+ jointPoint.getSignature().toLongString()
				+ "\nName : "
				+ jointPoint.getSignature().getName());

		/**
		 * Note: Assumption application all dao's are returning lists other than
		 * any object/primitive type
		 */

		if (result != null) {
			logStr.append("\nMethod ");

			if (result instanceof List<?>) {
				List<?> list = (List<?>) result;

				if (list != null)
					logStr.append("Return value is a List & size is: "
							+ list.size());
			} else {
				logStr.append("Returned value is:" + result);
			}
		}

		logStr.append(SEPERATOR);

		log.debug(logStr.toString());
	}

	/**
	 * This method is used to print log after returning arguments from method
	 * execution
	 * 
	 * @param jointPoint
	 *            is a joinPoint argument which identifies complete method
	 *            information at execution point
	 * 
	 * @param error
	 *            is an argument which represents the exception object from
	 *            method at execution point
	 */
	public void logAfterThrowingMethod(JoinPoint jointPoint, Throwable error) {

		StringBuffer logStr = new StringBuffer();

		logStr.append("\nAOP calling After throwing Method: \nMethod Full Signature : "
				+ jointPoint.getSignature().toLongString()
				+ "\nName : "
				+ jointPoint.getSignature().getName() + "\nError Message is : ");

		if (error != null)
			logStr.append(error.getMessage());

		logStr.append(SEPERATOR);

		log.debug(logStr.toString());
	}
}