package com.nttdata.product.web.handlers;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.nttdata.infra.domain.RequestDetails;
import com.nttdata.infra.services.InfraAppException;
import com.nttdata.infra.services.InfraSystemFacade;
import com.nttdata.mvc.HttpRequestHandler;

public class CreateRequest implements HttpRequestHandler{
	private static InfraSystemFacade isf = new InfraSystemFacade();
	public static final Logger LOG = Logger.getLogger(CreateRequest.class);
	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession ses = request.getSession();
		
		RequestDetails rd = new RequestDetails();
		LOG.info("---------------Main Method Started-----------");
		if(ses.getAttribute("uid")!=null) {
			
			int roleid=(Integer)ses.getAttribute("roleid");
			int uid=Integer.parseInt((String) ses.getAttribute("uid"));

			rd.setUserId(uid);
			
			rd.setLocation(request.getParameter("loc"));
			
			rd.setCubicleNo(Integer.parseInt(request.getParameter("cub")));
			
			rd.setDepartment(request.getParameter("dept"));
			
			Date datObj = null;
			SimpleDateFormat dateFormat = new SimpleDateFormat(
					"dd/MM/yyyy");
			String dts = request.getParameter("reqby");
			try {
				datObj = dateFormat.parse(dts);
			} catch (ParseException e) {
				LOG.error(e.fillInStackTrace());

			}
			java.sql.Date sd = new java.sql.Date(datObj.getTime());
			rd.setRequiredByDate(sd);
			
			
			rd.setReqTypeId(Integer.parseInt(request.getParameter("rti")));
			
			rd.setJustification(request.getParameter("jus"));
			rd.setStatusId(1);
			try {
				int res = isf.createNewSR(rd);
				ses.setAttribute("rol", res);
				
			} catch (InfraAppException e) {
				LOG.error(e.fillInStackTrace());
			}
			RequestDispatcher rd2 = request.getRequestDispatcher("Success.jsp"); 
			rd2.forward(request, response);
		}
		else {
			response.sendRedirect("Login.jsp");
		}
	}

}
