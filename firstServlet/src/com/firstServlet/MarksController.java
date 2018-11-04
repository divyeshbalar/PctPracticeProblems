package com.firstServlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/display")
public class MarksController extends HttpServlet {
	
	public void service(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException
	{
		int t0, t1, t2, d1, d2, p;
		//HttpSession session = req.getSession();
		
		
		t0 = Integer.parseInt(req.getParameter("T0"));
		t1 = Integer.parseInt(req.getParameter("T1"));
		t2 = Integer.parseInt(req.getParameter("T2"));
		d1 = Integer.parseInt(req.getParameter("D1"));
		d2 = Integer.parseInt(req.getParameter("D2"));
		p  = Integer.parseInt(req.getParameter("P"));
		System.out.println(t0+" "+t1+" "+t2+" "+d1+" "+d2+" " +p);
		int total = (int) ((6*t0/12) + (32*t1/80) + (32*t2/80) + (20*d1/200) + (4*d2/10) + (6*p/12));
		System.out.println(total);
		
		
		//session.setAttribute("total", total);
		
		
		Cookie cookie = new Cookie("total", total+"");
		res.addCookie(cookie);
		res.sendRedirect("quality");
		
		
		
		
		//res.sendRedirect("quality?totlal="+total);
		
		
		//req.setAttribute("total", total);
		//RequestDispatcher rd = req.getRequestDispatcher("/quality");
		//rd.forward(req, res);
		
		
		
		
		//PrintWriter out = res.getWriter();
		//out.println(total);
				
	}
}
