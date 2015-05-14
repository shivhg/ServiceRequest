package com.servreq.dbfw;

import java.sql.CallableStatement;
import java.sql.SQLException;

public interface OutParamMapper {
public Object mapOutParam(CallableStatement cStmt)
		throws SQLException;
}
