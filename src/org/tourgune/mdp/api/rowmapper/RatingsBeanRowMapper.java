package org.tourgune.mdp.api.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.tourgune.mdp.api.bean.RatingsBean;
import org.tourgune.mdp.api.utils.TablesDB;

public class RatingsBeanRowMapper implements RowMapper {

	public Object mapRow (ResultSet rs, int rowNum) throws SQLException {
		
		RatingsBean ratingsBean = new RatingsBean();
		ratingsBean.setCountry(rs.getString(TablesDB.STORED_PROCEDURE_COUNTRY));
		ratingsBean.setAal1(rs.getString(TablesDB.STORED_PROCEDURE_AAL1));
		ratingsBean.setAal2(rs.getString(TablesDB.STORED_PROCEDURE_AAL2));
		ratingsBean.setAal3(rs.getString(TablesDB.STORED_PROCEDURE_AAL3));
		ratingsBean.setAal4(rs.getString(TablesDB.STORED_PROCEDURE_AAL4));
		ratingsBean.setLocality(rs.getString(TablesDB.STORED_PROCEDURE_LOCALITY));
		ratingsBean.setAccType(rs.getString(TablesDB.STORED_PROCEDURE_ACC_TYPE));
		ratingsBean.setDataDate(rs.getString(TablesDB.STORED_PROCEDURE_DATE));
		
		int category = rs.getInt(TablesDB.STORED_PROCEDURE_CATEGORY);
		ratingsBean.setCategory(rs.wasNull() ? null : category);
		
		ratingsBean.setSegment(rs.getString(TablesDB.STORED_PROCEDURE_SEGMENT));
		ratingsBean.setClean(rs.getFloat(TablesDB.STORED_PROCEDURE_CLEAN));
		ratingsBean.setComfort(rs.getFloat(TablesDB.STORED_PROCEDURE_COMFORT));
		ratingsBean.setLocation(rs.getFloat(TablesDB.STORED_PROCEDURE_LOCATION));
		ratingsBean.setServices(rs.getFloat(TablesDB.STORED_PROCEDURE_SERVICES));
		ratingsBean.setStaff(rs.getFloat(TablesDB.STORED_PROCEDURE_STAFF));
		ratingsBean.setValue(rs.getFloat(TablesDB.STORED_PROCEDURE_VALUE));
		ratingsBean.setAverage(rs.getFloat(TablesDB.STORED_PROCEDURE_AVERAGE));
		ratingsBean.setNumUsers(rs.getInt(TablesDB.STORED_PROCEDURE_NUM_USERS));
		
		return ratingsBean;
	}
}
