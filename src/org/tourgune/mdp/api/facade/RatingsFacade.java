package org.tourgune.mdp.api.facade;


import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.tourgune.mdp.api.bean.Customer;
import org.tourgune.mdp.api.bean.Ratings;
import org.tourgune.mdp.api.bean.RatingsBean;
import org.tourgune.mdp.api.dao.RatingsDao;
import org.tourgune.mdp.api.utils.Constants;

@Service("ratingsFacade")
public class RatingsFacade {

	@Resource
	private RatingsDao ratingsDao;
	
	public Ratings getRatingsByYearMonth (Customer customer, String year, String month) throws Exception {
		
		Ratings ratings = new Ratings();
		try {
			ratings.setDestination(getRatingsDestinationByYearMonth(customer, year, month));
			ratings.setCompetitors(getRatingsCompetitorsByYearMonth(customer, year, month));

			if (ratings.getDestination().size() == 0 || ratings.getCompetitors().size() == 0) 
				ratings.setStatus(Constants.JSON_STATUS_DESTINATION_COMPETITORS_NO_DATA);
			else
				ratings.setStatus(Constants.JSON_STATUS_OK);
			
		} catch (Exception e) {
			ratings.setDestination(null);
			ratings.setCompetitors(null);
			ratings.setStatus(Constants.JSON_STATUS_ERROR);
			throw e;
		}
		
		return ratings;
	}
	
	private List<RatingsBean> getRatingsDestinationByYearMonth (Customer customer, String year, String month) throws Exception {
		
		List<RatingsBean> listRatingsDestination = null;
		
		try {
			HashMap<String, String> mapProcedures = transformProcedures2Map(customer.getProcedures());
			String destinationRatingsStoredProcedure = mapProcedures.get(Constants.DB_STORED_PROCEDURES_RATINGS_DESTINATION);
			listRatingsDestination = ratingsDao.getRatingsByYearMonth(destinationRatingsStoredProcedure, year, month);
		} catch (Exception e) {
			throw e;
		}
		
		return listRatingsDestination;
	}
	
	private List<RatingsBean> getRatingsCompetitorsByYearMonth (Customer customer, String year, String month) throws Exception {
		
		List<RatingsBean> listRatingsCompetitors = null;
		
		try {
			HashMap<String, String> mapProcedures = transformProcedures2Map(customer.getProcedures());
			String competitorsRatingsStoredProcedure = mapProcedures.get(Constants.DB_STORED_PROCEDURES_RATINGS_COMPETITORS);
			listRatingsCompetitors = ratingsDao.getRatingsByYearMonth(competitorsRatingsStoredProcedure, year, month);
		} catch (Exception e) {
			throw e;
		}
		return listRatingsCompetitors;
	}
	
	private HashMap<String, String> transformProcedures2Map (String procedures) {
		HashMap<String, String> mapProcedures = new HashMap<String, String>();
		
		String[] listProcedures = procedures.split("#");
		for (String procedurePair : listProcedures) {
			String[] procedure = procedurePair.split("=");
			mapProcedures.put(procedure[0], procedure[1]);
		}
		
		return mapProcedures;
	}
}
