package org.tourgune.mdp.api.dao;

import java.sql.Types;

import javax.annotation.Resource;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.dao.RecoverableDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.tourgune.mdp.api.bean.ApiLog;
import org.tourgune.mdp.api.bean.Customer;
import org.tourgune.mdp.api.rowmapper.CustomerRowMapper;



@Service("adminDao")
public class AdminDao {
	
	public Customer isValidUser(String apiKey) throws Exception {
		// Se dan casos que después de mucha inactividad la conexión se pierde
		// y falla la consulta. Intentaremos volver a lanzarla 1 vez más (que 
		// a la 2ª parece que ya suele funciona)
		boolean retry = false;
		
		Customer customer = null;
		StringBuffer sql = new StringBuffer();
		Object[] parametros;
		int[] types;
				
		sql	.append(" SELECT * FROM staging_area.customers WHERE api_key = ? ");
		parametros = new Object[] { apiKey};
		types = new int[] {Types.VARCHAR};
		try {
			customer = (Customer) jdbcTemplate.queryForObject(sql.toString(), parametros, types, new CustomerRowMapper());
		} catch (RecoverableDataAccessException rdae) {
			if (!retry) {
				customer = (Customer) jdbcTemplate.queryForObject(sql.toString(), parametros, types, new CustomerRowMapper());
				retry = true;
			}
		} catch (Exception e) {
			throw e;
		}
		return customer;
	}
	
	public void logCall(ApiLog apiLog) throws Exception{
		
		StringBuffer sql = new StringBuffer();
		Object[] parametros;
		int[] types;
				
		sql	.append(" INSERT INTO staging_area.api_log (api_key, call_time, duration, controller, url_target, status) VALUES (?, ?, ?, ?, ?, ?)");
		parametros = new Object[] { apiLog.getApiKey(), apiLog.getCallTime(), apiLog.getDuration(), apiLog.getController(), apiLog.getUrlTarget(), apiLog.getStatus()};
		types = new int[] {Types.VARCHAR, Types.TIMESTAMP, Types.FLOAT, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR};
		
		try {
			jdbcTemplate.update(sql.toString(), parametros, types);
		}	catch (Exception e) {
			throw e;
		}
	}
	
	@Resource
	private JdbcTemplate jdbcTemplate;
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
}
