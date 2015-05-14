package com.nttdata.product.web.handlers;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.apache.log4j.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nttdata.infra.domain.RequestDetails;
import com.nttdata.infra.services.InfraAppException;
import com.nttdata.infra.services.InfraSystemFacade;
import com.nttdata.mvc.HttpRequestHandler;

public class SaveRequest implements HttpRequestHandler{
	public static final Logger LOG = Logger.getLogger(SaveRequest.class);
	private static InfraSystemFacade isf = new InfraSystemFacade();
	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession ses = request.getSession();
		int uid=Integer.parseInt((String) ses.getAttribute("uid"));
		
		
		int rid = (Integer)ses.getAttribute("rid");
		if(ses.getAttribute("uid")!=null) {
			RequestDetails rqd = new RequestDetails();
		
			rqd.setReqId(rid);
			rqd.setUserId(uid);
			ses.setAttribute("rol", rid);
			
			
			if(request.getParameter("cdate")!=null) {
				rqd.setStatusId(5);
			
				Date datObj = null;
				SimpleDateFormat dateFormat = new SimpleDateFormat(
						"dd/MM/yyyy");
				String dts = request.getParameter("cdate");
				try {
					datObj = dateFormat.parse(dts);
				} catch (ParseException e) {
					LOG.error(e.fillInStackTrace());
	
				}
				java.sql.Date sd = new java.sql.Date(datObj.getTime());
				rqd.setCompletedDate(sd);
			}
			
			
			if(request.getParameter("creason")!=null) {
				rqd.setStatusId(2);
				
				rqd.setCancellationReason(request.getParameter("creason"));
				}
			
			if(request.getParameter("rreason")!=null) {
				rqd.setStatusId(4);
				
				rqd.setRejectionReason(request.getParameter("rreason"));
				}
			
			if(request.getParameter("cmdate")!=null) {
				rqd.setStatusId(3);
				
					Date datObj = null;
					SimpleDateFormat dateFormat = new SimpleDateFormat(
							"dd/MM/yyyy");
					String dts = request.getParameter("cmdate");
					try {
						datObj = dateFormat.parse(dts);
					} catch (ParseException e) {
						LOG.error(e.fillInStackTrace());
	
					}
					java.sql.Date sd = new java.sql.Date(datObj.getTime());
					rqd.setCommittedDate(sd);
				}
			
			
			
			
			try {
				
				
				if(isf.saveSRDetails(rqd)) {
					response.sendRedirect("Success.jsp");
				}
			} catch (InfraAppException e) {
				LOG.error(e.fillInStackTrace());
			}
			String cr = request.getParameter("creason");
		}
		else {
			response.sendRedirect("Login.jsp");
		}
	}

}
