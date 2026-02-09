package com.wipro.book.service;


import com.wipro.book.bean.BookBean;
import com.wipro.book.dao.BookDAO;

public class Administrator {
	
	  private BookDAO bookDAO = new BookDAO();
	  public String addBook(BookBean bookBean) {

		    if (bookBean == null ||
		        bookBean.getBookname() == null || bookBean.getBookname().isEmpty() ||
		        bookBean.getIsbn() == null || bookBean.getIsbn().isEmpty() ||
		        (bookBean.getBookType() != 'G'&& bookBean.getBookType() != 'T') ||
		        bookBean.getCost() <= 0 ||
		        bookBean.getAuthor().getAuthorName().isEmpty()) {

		        return "Invalid";
		    }

		    int res = bookDAO.createBook(bookBean);

		    if (res> 1) {
		        return "Success";
		    }
		    return "Failure";
		}

	public BookBean viewBook(String isbn) {
		BookBean bookBean=new BookDAO().fetchBook(isbn);
		return bookBean;
		/*if(bookBean.getIsbn().getBookname()) {
			
		}if(bookBean.getIsbn().isEmpty()) {
			return "null";
		}*/
		
	}
	
}
