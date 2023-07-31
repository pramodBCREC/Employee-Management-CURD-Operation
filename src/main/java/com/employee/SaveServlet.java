package com.employee;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SaveServlet")  
public class SaveServlet extends HttpServlet {  
	    protected void doPost(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException {  
	        response.setContentType("text/html");  
	        PrintWriter out=response.getWriter();  
	          
	        String name=request.getParameter("name");  
	        String password=request.getParameter("password");  
	        String email=request.getParameter("email");  
	        String country=request.getParameter("country");  
	          
	        EmpPOJO e=new EmpPOJO();  
	        e.setName(name);  
	        e.setPassword(password);  
	        e.setEmail(email);  
	        e.setCountry(country);  
	          
	        int status=EmpDao.save(e);  
	        if(status>0){  
	            out.print("<p style=\"color:blue;\">Record saved successfully!</p>");  
	            request.getRequestDispatcher("index.html").include(request, response);  
	        }else{  
	            out.println("<h1 style=\"color:red;\">Sorry! unable to save record</h1>");  
	        }  
	          
	        out.close();  
	    }  
	  
	}  

