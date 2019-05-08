package com.capgemini.controllor;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet( name = "/CurrencyConverter" , loadOnStartup =1 , urlPatterns = {"/CurrencyConverter"})
public class CurrencyConverterControllor extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
  
    public CurrencyConverterControllor() 
    {
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
	
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		doGet(request, response);
	}

}
