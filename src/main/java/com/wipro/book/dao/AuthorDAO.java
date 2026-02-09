package com.wipro.book.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.wipro.book.util.DBUtil;
import com.wipro.book.bean.AuthorBean;
public class AuthorDAO {

    
    public static AuthorBean getAuthor(int authorCode) {
        String sql = "SELECT * FROM Author_tbl WHERE author_code = ?";
        AuthorBean authorbean = null;

        try (Connection con = DBUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, authorCode);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                authorbean = new AuthorBean();
                authorbean.setAuthorCode(rs.getInt("author_code"));
                authorbean.setAuthorName(rs.getString("author_name"));
                authorbean.setContactNo(rs.getLong("contact_no"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return authorbean;
    }

   
    public static AuthorBean getAuthor(String authorName) {
        String sql = "SELECT * FROM Author_tbl WHERE author_name = ?";
        AuthorBean authorbean = null;

        try (Connection con = DBUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, authorName);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                authorbean = new AuthorBean();
                authorbean.setAuthorCode(rs.getInt("author_code"));
                authorbean.setAuthorName(rs.getString("author_name"));
                authorbean.setContactNo(rs.getLong("contact_no"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return authorbean;
    }
}
