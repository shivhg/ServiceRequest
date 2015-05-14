package com.servreq.mvc;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.text.StyledEditorKit.BoldAction;

 public class MvcController extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
	 
	 private Map handlers;
	 static final long serialVersionUID = 1L;
	
	 
	 @Override
	public void init(ServletConfig config) throws ServletException {
		 super.init(config);
	String mvcProps=getServletContext().getRealPath("WEB-INF/mvc.properties");
	
	try{
		handlers=MvcUtility.buildHandlers(mvcProps);
		}
	catch(MvcException e)
	{
		throw new ServletException("Unable to Configure Controller Servlet",e);
	}
	}

	

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path=request.getServletPath();//how this work
	
		String key=path.substring(1, path.lastIndexOf("."));
		HttpRequestHandler handler=(HttpRequestHandler) handlers.get(key);//D:\advjava\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\Mvc\WEB-INF\mvc.properties
		if(handler!=null){
			handler.handle(request, response);
		}else{
			throw new ServletException("No Matching Handler");
		}
		
	}  	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}   	  	    
}