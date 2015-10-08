package org.tourgune.mdp.api.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.tourgune.mdp.api.bean.PriceBean;
import org.tourgune.mdp.api.utils.TablesDB;

public class PricesBeanRowMapper implements RowMapper {

	public Object mapRow (ResultSet rs, int rowNum) throws SQLException {
		
		PriceBean priceBean = new PriceBean();
		priceBean.setCountry(rs.getString(TablesDB.STORED_PROCEDURE_COUNTRY));
		priceBean.setAal1(rs.getString(TablesDB.STORED_PROCEDURE_AAL1));
		priceBean.setAal2(rs.getString(TablesDB.STORED_PROCEDURE_AAL2));
		priceBean.setAal3(rs.getString(TablesDB.STORED_PROCEDURE_AAL3));
		priceBean.setAal4(rs.getString(TablesDB.STORED_PROCEDURE_AAL4));
		priceBean.setLocality(rs.getString(TablesDB.STORED_PROCEDURE_LOCALITY));
		priceBean.setAccType(rs.getString(TablesDB.STORED_PROCEDURE_ACC_TYPE));
		priceBean.setProduct(rs.getString(TablesDB.STORED_PROCEDURE_PRODUCT));
		priceBean.setDataDate(rs.getString(TablesDB.STORED_PROCEDURE_DATE));
		
		int category = rs.getInt(TablesDB.STORED_PROCEDURE_CATEGORY);
		priceBean.setCategory(rs.wasNull() ? null : category);
		
		priceBean.setPrice(rs.getFloat(TablesDB.STORED_PROCEDURE_PRICE));
		priceBean.setNumAcc(rs.getInt(TablesDB.STORED_PROCEDURE_NUM_ACC));
		
		
		return priceBean;
	}
}
