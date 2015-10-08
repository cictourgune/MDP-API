package org.tourgune.mdp.api.facade;


import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.tourgune.mdp.api.bean.Customer;
import org.tourgune.mdp.api.bean.PriceBean;
import org.tourgune.mdp.api.bean.Prices;
import org.tourgune.mdp.api.dao.PricesDao;
import org.tourgune.mdp.api.utils.Constants;

@Service("pricesFacade")
public class PricesFacade {

	@Resource
	private PricesDao pricesDao;
	
	public Prices getPricesByYearMonth (Customer costumer, String year, String month) throws Exception {
		
		Prices prices = new Prices();
		try {
			prices.setDestination(getPricesDestinationByYearMonth(costumer, year, month));
			prices.setCompetitors(getPricesCompetitorsByYearMonth(costumer, year, month));
			
			if (prices.getDestination().size() == 0 || prices.getCompetitors().size() == 0)
				prices.setStatus(Constants.JSON_STATUS_DESTINATION_COMPETITORS_NO_DATA);
			else 
				prices.setStatus(Constants.JSON_STATUS_OK);
			
			
		} catch (Exception e) {
			prices.setDestination(null);
			prices.setCompetitors(null);
			prices.setStatus(Constants.JSON_STATUS_ERROR);
			throw e;
		}
		
		return prices;
	}
	
	private List<PriceBean> getPricesDestinationByYearMonth (Customer customer, String year, String month) throws Exception {
		
		List<PriceBean> listPricesDestination = null;
		
		try {
			HashMap<String, String> mapProcedures = transformProcedures2Map(customer.getProcedures());
			String pricesDestinationStoredProcedure = mapProcedures.get(Constants.DB_STORED_PROCEDURES_PRICES_DESTINATION);
			listPricesDestination = pricesDao.getPricesByYearMonth(pricesDestinationStoredProcedure, year, month);
		} catch (Exception e) {
			throw e;
		}
		
		return listPricesDestination;
	}
	
	private List<PriceBean> getPricesCompetitorsByYearMonth (Customer customer, String year, String month) throws Exception {
		
		List<PriceBean> listPricesCompetitors = null;
		
		try {
			HashMap<String, String> mapProcedures = transformProcedures2Map(customer.getProcedures());
			String competitorsPricesStoredProcedure = mapProcedures.get(Constants.DB_STORED_PROCEDURES_PRICES_COMPETITORS);
			listPricesCompetitors = pricesDao.getPricesByYearMonth(competitorsPricesStoredProcedure, year, month);
		} catch (Exception e) {
			throw e;
		}
		return listPricesCompetitors;
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
