package org.tourgune.mdp.api.facade;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.tourgune.mdp.api.bean.ApiLog;
import org.tourgune.mdp.api.bean.Customer;
import org.tourgune.mdp.api.dao.AdminDao;

@Service("adminFacade")
public class AdminFacade {

	@Resource
	private AdminDao adminDao;
	
	public Customer isValidUser(String apiKey) throws Exception {
		
		return adminDao.isValidUser(apiKey);
		
	}
	
	public void logCall (ApiLog apiLog) throws Exception {
		adminDao.logCall(apiLog);
	}
}
