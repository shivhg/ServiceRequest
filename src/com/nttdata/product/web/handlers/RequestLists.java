package com.nttdata.product.web.handlers;

import java.io.IOException;
import java.util.List;
import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.Session;

import com.nttdata.infra.domain.RequestDetails;
import com.nttdata.infra.domain.User;
import com.nttdata.infra.services.InfraAppException;
import com.nttdata.infra.services.InfraSystemFacade;
import com.nttdata.mvc.HttpRequestHandler;

public class RequestLists implements HttpRequestHandler{
	public static final Logger LOG = Logger.getLogger(RequestLists.class);
	private static InfraSystemFacade isf = new InfraSystemFacade();
	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession ses = request.getSession();
		
		
		if(ses.getAttribute("uid")!=null) {
			int roleid=(Integer)ses.getAttribute("roleid");
			int uid=Integer.parseInt((String) ses.getAttribute("uid"));
			List<RequestDetails> list = null;
			try {
				if(roleid==2) {
					
					list = isf.getAllRequest();
					request.setAttribute("list", list);
					RequestDispatcher rd = request.getRequestDispatcher("RequestList.jsp"); 
					rd.forward(request, response);}
				else {
					list = isf.getRequestByCreator(uid);
					request.setAttribute("list", list);
					RequestDispatcher rd = request.getRequestDispatcher("RequestList.jsp"); 
					rd.forward(request, response);
				}
				
			} catch (InfraAppException e) {
				// TODO Auto-generated catch block
				LOG.error(e.fillInStackTrace());
			}
		}
		else {
			response.sendRedirect("Login.jsp");
		}
	}

}
