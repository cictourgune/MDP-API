package org.tourgune.mdp.api.dao;

import java.sql.Types;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.tourgune.mdp.api.bean.PriceBean;
import org.tourgune.mdp.api.rowmapper.PricesBeanRowMapper;

@Service("pricesDao")
public class PricesDao {
	
	public List<PriceBean> getPricesByYearMonth (String procedure, String year, String month) throws Exception {

		List<PriceBean> listPrices = null;
		
		StringBuffer sql = new StringBuffer();
		Object[] parametros;
		int[] types;
	
		sql	.append(" CALL " + procedure);
		parametros = new Object[] { year, month};
		types = new int[] {Types.INTEGER, Types.INTEGER};
		
		listPrices = (List<PriceBean>) jdbcTemplate.query(sql.toString(), parametros, types, new PricesBeanRowMapper());
//		listPrices = (List<PriceBean>) jdbcTemplate.query(sql.toString(), new PricesBeanRowMapper());
		
		return listPrices;
	}
	
	
	@Resource
	private JdbcTemplate jdbcTemplate;
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
}
