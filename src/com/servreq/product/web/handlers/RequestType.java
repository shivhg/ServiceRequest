package com.servreq.product.web.handlers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.servreq.infra.domain.User;
import com.servreq.infra.services.InfraAppException;
import com.servreq.infra.services.InfraSystemFacade;
import com.servreq.mvc.HttpRequestHandler;

public class RequestType implements HttpRequestHandler{
	public static final Logger LOG = Logger.getLogger(RequestType.class);
	private static InfraSystemFacade isf = new InfraSystemFacade();
	@Override
			public void handle(HttpServletRequest request, HttpServletResponse response)
					throws ServletException, IOException {
		HttpSession ses = request.getSession();
				InfraSystemFacade isf = new InfraSystemFacade();
					List<User> reqTy = new ArrayList<User>();
					if(ses.getAttribute("uid")!=null) {
					try {
			reqTy = isf.getRequestTypes();
		} catch (InfraAppException e) {
			LOG.error(e.fillInStackTrace());
		}
		
		request.setAttribute("lst", reqTy);
		RequestDispatcher rd = request.getRequestDispatcher("CreateServiceRequest.jsp");
			rd.forward(request, response);
		}
	
					else {
						response.sendRedirect("Login.jsp");
					}
	}
	
		
	


}
