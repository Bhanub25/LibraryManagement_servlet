package com.wipro.book.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.wipro.book.util.DBUtil;
import com.wipro.book.bean.BookBean;

public class BookDAO {

    public int createBook(BookBean bookbean) {
        int rowsInserted = 0;
        String sql =
        		"INSERT INTO book_tbl (ISBN, BOOK_TITLE, BOOK_TYPE, AUTHOR_CODE, BOOK_COST) " +
        				"VALUES (?, ?, ?, ?, ?)";


        try (Connection con = DBUtil.getConnection();
        	     PreparedStatement ps = con.prepareStatement(sql)) {

        	ps.setString(1, bookbean.getIsbn());                 
        	ps.setString(2, bookbean.getBookname());            
        	ps.setString(3, String.valueOf(bookbean.getBookType())); 
        	ps.setInt(4, bookbean.getAuthor().getAuthorCode());  
        	ps.setDouble(5, bookbean.getCost());                

        	    

        	    rowsInserted = ps.executeUpdate();

        	} catch (Exception e) {
        	    e.printStackTrace();
        	}


        return rowsInserted; 
    }
   
    public BookBean fetchBook(String isbn) {
        BookBean book = null;
        String sql = "SELECT * FROM book_tbl WHERE isbn=?";

        try (Connection con = DBUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, isbn);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                book = new BookBean();
                book.setIsbn(rs.getString(1));
                book.setBookname(rs.getString(2));
                book.setBookType(rs.getString(3).charAt(0));
                
                book.setAuthor(AuthorDAO.getAuthor(rs.getInt(4)));
                book.setCost(rs.getFloat(5));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return book;
    }

}
