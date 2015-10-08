package org.tourgune.mdp.api.controller;

import java.sql.Timestamp;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.tourgune.mdp.api.bean.ApiLog;
import org.tourgune.mdp.api.bean.Customer;
import org.tourgune.mdp.api.bean.Overall;
import org.tourgune.mdp.api.bean.Prices;
import org.tourgune.mdp.api.bean.Ratings;
import org.tourgune.mdp.api.facade.AdminFacade;
import org.tourgune.mdp.api.facade.PricesFacade;
import org.tourgune.mdp.api.facade.RatingsFacade;
import org.tourgune.mdp.api.utils.Constants;
import org.tourgune.mdp.api.utils.MailUtils;
import org.tourgune.mdp.api.utils.Utils;

@Controller
@RequestMapping("/overall")
public class OverallController {

	// Para poder acceder a la URL a la que se hace la petición
	@Autowired
	private HttpServletRequest context;
	
	@Resource
	private MailUtils mailUtils;
	
	@Resource
	private AdminFacade adminFacade;
	
	@Resource
	private PricesFacade pricesFacade;
	
	@Resource
	private RatingsFacade ratingsFacade;

	@RequestMapping(value = "/date", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
	public @ResponseBody Overall getByParam(@RequestParam(value = "year", required = true) String year
								 , @RequestParam(value = "month", required = true) String month
			 					, @RequestParam(value = "api_key", required = true) String apiKey) {

		Overall overall = new Overall();
		Customer customer = null;
		
		ApiLog apiLog = null;
	
	// 1. Se prepara el log
		try {
			apiLog = Utils.prepareApiLog(context, Thread.currentThread().getStackTrace()[1]);
		} catch (Exception e) {
			mailUtils.sendMail(Constants.MAIL_CAUSE_ERROR, Utils.getStackTrace(e));
		}
		
	// 2. Se obtienen los datos de la bbdd
		try {
			customer = adminFacade.isValidUser(apiKey);
			if (customer != null) {
				overall.setPrices(pricesFacade.getPricesByYearMonth(customer, year, month));
				overall.setRatings(ratingsFacade.getRatingsByYearMonth(customer, year, month));
			} else {
				Prices prices = new Prices();
				prices.setStatus(Constants.JSON_STATUS_API_KEY_NOT_VALID);
				Ratings ratings = new Ratings();
				ratings.setStatus(Constants.JSON_STATUS_API_KEY_NOT_VALID);
				
				overall.setPrices(prices);
				overall.setRatings(ratings);
			}
		} catch (Exception e) {
			mailUtils.sendMail(Constants.MAIL_CAUSE_GENERAL, Utils.getStackTrace(e));
			
			Prices prices = new Prices();
			prices.setStatus(Constants.JSON_STATUS_ERROR);
			Ratings ratings = new Ratings();
			ratings.setStatus(Constants.JSON_STATUS_ERROR);
			
			overall.setPrices(prices);
			overall.setRatings(ratings);
			
			return overall;
		}
		
	// 3. Se termina de rellenar el log y se inserta en la bbdd
		try {
			Timestamp endCallTime = new Timestamp(new Date().getTime());
			Utils.setApiLog(apiLog, apiKey, endCallTime, overall.getPrices().getStatus(), overall.getRatings().getStatus());
			adminFacade.logCall(apiLog);
		} catch (Exception e) {
			mailUtils.sendMail(Constants.MAIL_CAUSE_LOG, Utils.getStackTrace(e));
		}
		
	// 4. Se devuelve el json	
		return overall;
	}
	

}