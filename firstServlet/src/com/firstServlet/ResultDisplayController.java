package com.firstServlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/quality")
public class ResultDisplayController extends HttpServlet {

	public void service(HttpServletRequest req, HttpServletResponse res) throws IOException
	{
		PrintWriter out = res.getWriter();
		
		
		int total = 0;
		//HttpSession session = req.getSession();
				
		//int total = (int)session.getAttribute("total");
		//int total = Integer.parseInt(req.getParameter("total"));
		Cookie cookies[] = req.getCookies();
		for(Cookie c : cookies)
		{
			if(c.getName().equals("total"))
			{
				total = Integer.parseInt(c.getValue());
			}
		}
		
		
		
		if(total >= 90)
		{
			out.println("You have performed really well and got A+ "+total);
		}	
		if(total<90 && total >= 85)
		{
			out.println("You have performed really well and got A "+total);
		}
		if(total<85 && total >= 75)
		{
			out.println("You have performed well and got B+ "+total);
		}
		if(total<75 && total >= 50)
		{
			out.println("You have performed average and got B "+total);
		}
		if(total < 50)
		{
			out.println("You have got F+ "+total);
		}
		//session.removeAttribute("total");
	}
}
