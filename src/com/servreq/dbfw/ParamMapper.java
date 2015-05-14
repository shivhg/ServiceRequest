package com.servreq.dbfw;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public interface ParamMapper {
	public void mapParams(PreparedStatement pstm) throws SQLException;

}
