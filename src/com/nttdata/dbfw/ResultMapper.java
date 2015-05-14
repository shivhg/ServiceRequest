package com.nttdata.dbfw;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface ResultMapper {
	Object mapRows(ResultSet rs) throws SQLException;

}
