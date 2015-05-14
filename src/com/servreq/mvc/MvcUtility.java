package com.servreq.mvc;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;



public class MvcUtility {

	private static boolean checkInterface(Class clazz,String interfaceName)
	{
		boolean found=false;
		Class[]interfaces=clazz.getInterfaces();
		for(int i=0;i<interfaces.length;i++)
		{
			if(interfaces[i].getName().equals(interfaceName))
			{
				found=true;
				break;
			}
		}
		return found;
	}
	public static Map buildHandlers(String propsFile) throws MvcException
	{
		Map handlers=new HashMap();
		Properties props=new Properties();
		FileInputStream proStr=null;
		try 
		{
			proStr=new FileInputStream(propsFile);
			props.load(proStr);
			Enumeration enKeys=props.propertyNames();
			while(enKeys.hasMoreElements())
			{
				String key=(String) enKeys.nextElement();
				String Clazz=props.getProperty(key);
				Class handClazz=Class.forName(Clazz);
				if(checkInterface(handClazz, "com.nttdata.mvc.HttpRequestHandler"))
				{
					Object handler=handClazz.newInstance();
					handlers.put(key,handler);
				}
				else
				{
					throw new MvcException("class does not implement com.nttdata.mvc.HttpRequestHandler interface ");
				}
			}
			
		}catch(FileNotFoundException e){
			throw new MvcException(e);
		}catch(IOException e){
			throw new MvcException(e);
		}catch(ClassNotFoundException e){
			throw new MvcException(e);
		}catch(InstantiationException e){
			throw new MvcException(e);
		}catch(IllegalAccessException e){
			throw new MvcException(e);
		}finally{
			try{
				proStr.close();
			}
			catch(IOException e){
				throw new MvcException(e);
			}
			}
		return handlers;
		}
		
		
		
	}

