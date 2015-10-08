package org.tourgune.mdp.api.utils;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.Timestamp;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.tourgune.mdp.api.bean.ApiLog;

public class Utils {

	public static ApiLog prepareApiLog (HttpServletRequest context, StackTraceElement stack) {
	
		Timestamp startCallTime = new Timestamp(new Date().getTime());
		String urlBase = context.getRequestURL().toString();
		String urlParams = context.getQueryString();
		String urlTarget = urlBase + "?" + urlParams;
		String controller = stack.getClassName() + "." + stack.getMethodName();
		
		return new ApiLog(null, startCallTime, null, controller, urlTarget, null);
	}
	
	public static ApiLog setApiLog (ApiLog apiLog, String apiKey, Timestamp endCallTime, String pricesStatus, String ratingsStatus) {
		apiLog.setApiKey(apiKey);
		apiLog.setDuration(new Float(endCallTime.getTime()-apiLog.getCallTime().getTime()));
		apiLog.setStatus("prices: " + pricesStatus + " | ratings: " + ratingsStatus);
		
		return apiLog;
	}
	/**
	 * Método que permite obtener en un string el stack trace de una excepción
	 * dentro de un String
	 * @param throwable
	 * @return
	 */
	public static String getStackTrace(final Throwable throwable) {
	     final StringWriter sw = new StringWriter();
	     final PrintWriter pw = new PrintWriter(sw, true);
	     throwable.printStackTrace(pw);
	     return sw.getBuffer().toString();
	}
}
