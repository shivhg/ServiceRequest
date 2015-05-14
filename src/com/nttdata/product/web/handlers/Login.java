package com.nttdata.product.web.handlers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nttdata.infra.domain.User;
import com.nttdata.infra.services.InfraAppException;
import com.nttdata.infra.services.InfraSystemFacade;
import com.nttdata.mvc.HttpRequestHandler;
//import org.apache.log4j.Logger;

public class Login implements HttpRequestHandler {
	private static InfraSystemFacade isf = new InfraSystemFacade();
//	public static final Logger LOG = Logger.getLogger(Login.class);

	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		LOG.info("---------------Main Method Started-----------");
		String uid = request.getParameter("userid");// uu
		String pass = request.getParameter("password");
		User userFirst = null;

		HttpSession ses = request.getSession();
		int id = Integer.parseInt(uid);

		try {
			userFirst = isf.validateUser(id, pass);
		} catch (InfraAppException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (userFirst == null) {
			PrintWriter pw = response.getWriter();
			pw.write("<h1>Credential Error  </h1>");

			RequestDispatcher disp1 = request.getRequestDispatcher("Login.jsp");
			disp1.include(request, response);

		} else {

			ses.setAttribute("uid", uid);
		//	int ud = Integer.parseInt(uid);

			if (userFirst.getRoleId() == 1) {
				ses.setAttribute("roleid", 1);
				RequestDispatcher rd = request
						.getRequestDispatcher("Emenu.jsp");
				rd.forward(request, response);
			} else {
				ses.setAttribute("roleid", 2);
				response.sendRedirect("RequestLists.do");
			}
		}
	}
}
