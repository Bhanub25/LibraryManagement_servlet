package com.wipro.book.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.wipro.book.bean.BookBean;


@WebServlet("/ViewServlet")
public class ViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		HttpSession session=request.getSession();
		BookBean bookBean=(BookBean)session.getAttribute("book");
		out.print("<html><body>");
		out.print("Isbn:"+bookBean.getIsbn());
		out.print("Book title: " +bookBean.getBookname());
		out.print("Book Type:"+bookBean.getBookType());
		out.print("Cost"+bookBean.getCost());
		out.print("Author:"+bookBean.getAuthor().getContactNo());
		
		
		out.print("</body></html>");
		
	}

}
