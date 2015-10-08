package org.tourgune.mdp.api.utils;

public class Constants {

// Las siguientes constantes se usarán como parte del "Asunto" en el mail. Respetar los espacios en blanco.
	public final static String MAIL_SUBJECT_PREFIX				= "[MDP-API]";
	public final static String MAIL_CAUSE_GENERAL				= " GENERAL ";
	public final static String MAIL_CAUSE_ERROR					= " ERROR ";
	public final static String MAIL_CAUSE_LOG					= " LOG ";	
	public final static String MAIL_FROM						= "dev.mail.mdp@gmail.com";
	public final static String MAIL_TO							= "hugosalas@tourgune.org, anderjuaristi@tourgune.org";

	
	public final static String JSON_STATUS_OK									= "OK";
	public final static String JSON_STATUS_ERROR								= "ERROR";
	public final static String JSON_STATUS_API_KEY_NOT_VALID					= "API_KEY_NOT_VALID";
	public final static String JSON_STATUS_DESTINATION_COMPETITORS_NO_DATA		= "DESTINATION_COMPETITORS_NO_DATA";
	
	public final static String DB_STORED_PROCEDURES_PRICES_DESTINATION	= "prices_destination";
	public final static String DB_STORED_PROCEDURES_PRICES_COMPETITORS	= "prices_competitors";
	public final static String DB_STORED_PROCEDURES_RATINGS_DESTINATION	= "ratings_destination";
	public final static String DB_STORED_PROCEDURES_RATINGS_COMPETITORS	= "ratings_competitors";
	
	public static final String CONTROLLER_PRODUCES_JSON_UTF_8 = "application/json; charset=utf-8";
	
	public final static String PRICES_CONTROLLER	 					= "/prices";
	public final static String PRICES_CONTROLLER_BY_YEAR_MONTH			=  "/date";
	
	
	
}
