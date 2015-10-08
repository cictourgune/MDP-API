package org.tourgune.mdp.api.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.tourgune.mdp.api.bean.Customer;
import org.tourgune.mdp.api.utils.TablesDB;

public class CustomerRowMapper implements RowMapper {

	public Object mapRow (ResultSet rs, int rowNum) throws SQLException {
		
		Customer costumer = new Customer();
		costumer.setId(rs.getInt(TablesDB.TABLE_COSTUMER_ID));
		costumer.setApiKey(rs.getString(TablesDB.TABLE_COSTUMER_API_KEY));
		costumer.setName(rs.getString(TablesDB.TABLE_COSTUMER_NAME));
		costumer.setDescription(rs.getString(TablesDB.TABLE_COSTUMER_DESCRIPTION));
		costumer.setActive(rs.getBoolean(TablesDB.TABLE_COSTUMER_ACTIVE));
		costumer.setProcedures(rs.getString(TablesDB.TABLE_COSTUMER_PROCEDURES));
		
		return costumer;
	}
}
