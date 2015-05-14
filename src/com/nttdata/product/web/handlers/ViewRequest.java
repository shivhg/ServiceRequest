package com.nttdata.product.web.handlers;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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

public class ViewRequest implements HttpRequestHandler{
	public static final Logger LOG = Logger.getLogger(ViewRequest.class);
	private static InfraSystemFacade isf = new InfraSystemFacade();
	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession ses = request.getSession();
		
		RequestDetails rd = new RequestDetails();
		
		if(ses.getAttribute("uid")!=null) {
			int roleid=(Integer) ses.getAttribute("roleid");
			int uid=Integer.parseInt((String) ses.getAttribute("uid"));
			int sid = Integer.parseInt(request.getParameter("sid"));
			RequestDetails rqd = new RequestDetails();
			int tempReqId = Integer.parseInt(request.getParameter("rid"));
			ses.setAttribute("rid", tempReqId);
			if(sid==5) {
				try {
				
					rqd = isf.getSRDetails(tempReqId);
					request.setAttribute("rqid", rqd);
					RequestDispatcher rds = request.getRequestDispatcher("CompletedViewServiceRequest.jsp");
					rds.forward(request, response);
				} catch (InfraAppException e) {
					LOG.error(e.fillInStackTrace());
				}
			}else if(sid==4) {
				try {
					rqd = isf.getSRDetails(tempReqId);
					request.setAttribute("rqid", rqd);
					RequestDispatcher rds = request.getRequestDispatcher("RejectedViewServiceRequest.jsp");
					rds.forward(request, response);
				} catch (InfraAppException e) {
					LOG.error(e.fillInStackTrace());
				}
			}
			else if(sid == 2) {
				try {
					rqd = isf.getSRDetails(tempReqId);
					request.setAttribute("rqid", rqd);
					RequestDispatcher rds = request.getRequestDispatcher("CancelledViewServiceRequest.jsp");
					rds.forward(request, response);
				} catch (InfraAppException e) {
					LOG.error(e.fillInStackTrace());
				}
			}
					
			else  {
				
				try {
					rqd = isf.getSRDetails(tempReqId);
					request.setAttribute("rqid", rqd);
					RequestDispatcher rds = request.getRequestDispatcher("RequestedViewServiceRequest.jsp");
					rds.forward(request, response);
				} catch (InfraAppException e) {
					LOG.error(e.fillInStackTrace());
				}
				
														
				
			}
			
			
		}
		else {
			response.sendRedirect("Login.jsp");
		}
	}

}
