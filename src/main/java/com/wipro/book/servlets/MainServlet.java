package com.wipro.book.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.wipro.book.bean.AuthorBean;
import com.wipro.book.bean.BookBean;
import com.wipro.book.dao.AuthorDAO;
import com.wipro.book.service.Administrator;


@WebServlet("/MainServlet")
public class MainServlet extends HttpServlet {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String operation = request.getParameter("operation");

        if ("AddBook".equals(operation)) {

            String res = addBook(request);

            if ("Success".equals(res)) {
                response.sendRedirect("Menu.html");
            } else if ("Failure".equals(res)) {
                response.sendRedirect("Failure.html");
            } else if("Invalid".equals(res)){
                response.sendRedirect("InvalidData.html");
            }

        } else if ("Search".equals(operation)) {

            String isbn = request.getParameter("isbn");
            BookBean bookBean = viewBook(isbn);

            if (bookBean == null) {
                response.sendRedirect("InvalidData.html");
            } else {
                HttpSession session = request.getSession();
                session.setAttribute("book", bookBean);
                RequestDispatcher rd = request.getRequestDispatcher("ViewServlet");
                rd.forward(request, response);
            }
        }
    }

    public String addBook(HttpServletRequest request) {

        String isbn = request.getParameter("isbn");
        String bookName = request.getParameter("Bookname");
        String bookType = request.getParameter("BookType");
        String cost = request.getParameter("Cost");
        String authorName = request.getParameter("authorName");
        

        BookBean bookBean = new BookBean();
        bookBean.setIsbn(isbn);
        bookBean.setBookname(bookName);
        bookBean.setBookType(bookType.charAt(0));
        bookBean.setCost(Float.parseFloat(cost));
        AuthorBean author = AuthorDAO.getAuthor(authorName);
        if (author == null) {
            return "Invalid";
        }
        bookBean.setAuthor(author);

        String res=new Administrator().addBook(bookBean);
        return res;
    }

    public BookBean viewBook(String isbn) {
        return new Administrator().viewBook(isbn);
    }
}

