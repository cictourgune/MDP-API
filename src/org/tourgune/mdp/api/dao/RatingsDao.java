package org.tourgune.mdp.api.dao;

import java.sql.Types;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.tourgune.mdp.api.bean.RatingsBean;
import org.tourgune.mdp.api.rowmapper.RatingsBeanRowMapper;

@Service("ratingsDao")
public class RatingsDao {
	
	public List<RatingsBean> getRatingsByYearMonth (String procedure, String year, String month) throws Exception {

		List<RatingsBean> listRatings = null;
		
		StringBuffer sql = new StringBuffer();
		Object[] parametros;
		int[] types;
	
		sql	.append(" CALL " + procedure);
		parametros = new Object[] { year, month};
		types = new int[] {Types.INTEGER, Types.INTEGER};
		
		listRatings = (List<RatingsBean>) jdbcTemplate.query(sql.toString(), parametros, types, new RatingsBeanRowMapper());
		
		return listRatings;
	}
	
	
	@Resource
	private JdbcTemplate jdbcTemplate;
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
}
