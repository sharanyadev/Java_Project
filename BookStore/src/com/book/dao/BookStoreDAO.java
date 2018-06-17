package com.book.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class BookStoreDAO {
	private Connection con;

	public BookStoreDAO() throws ClassNotFoundException, SQLException {
		establishConnection();
	}

	private void establishConnection() throws ClassNotFoundException, SQLException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		String conURL = "jdbc:oracle:thin:@localhost:1521:XE";
		con = DriverManager.getConnection(conURL, "system", "system");
	}

	public void addBook(Book b) throws SQLException, ClassNotFoundException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "system");
		String sql = "insert into bookstore values(bid.nextval,?,?,?)";
		PreparedStatement pstmt = con.prepareStatement(sql);
		String bname = b.getbName();
		pstmt.setString(1, bname);
		String author = b.getAuthor();
		pstmt.setString(2, author);
		int prize = b.getPrize();
		pstmt.setInt(3, prize);
		pstmt.executeUpdate();
	}

	public ArrayList retriveBook(String bname) throws SQLException {
		ArrayList bookList = new ArrayList<>();
		String sql = "select * from bookstore where bookName=?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, bname);
		ResultSet rs = pstmt.executeQuery();
		int bid;
		String bName;
		String author;
		int prize;
		while (rs.next()) {
			bid = rs.getInt(1);
			bName = rs.getString(2);
			author = rs.getString(3);
			prize = rs.getInt(4);
			Book b = new Book();
			b.setBid(bid);
			b.setbName(bName);
			b.setAuthor(author);
			b.setPrize(prize);
			bookList.add(b);
		}
		return bookList;
	}

	public ArrayList retriveBookList() throws SQLException {
		ArrayList bookList = new ArrayList<>();
		String sql = "select * from bookstore";
		Statement st = con.createStatement();
		System.out.println("Statement created");
		ResultSet rs = st.executeQuery(sql);
		System.out.println("ResultSet created");
		int bid;
		String bname;
		String author;
		int prize;
		while (rs.next()) {
			bid = rs.getInt(1);
			bname = rs.getString(2);
			author = rs.getString(3);
			prize = rs.getInt(4);
			Book b = new Book();
			b.setBid(bid);
			b.setbName(bname);
			b.setAuthor(author);
			b.setPrize(prize);
			bookList.add(b);
		}
		System.out.println("No Of Books " + bookList.size());
		System.out.println(bookList);
		return bookList;
	}

	public void deleteBook(int bid) throws SQLException {
		String sql = "delete from bookstore where bookid=?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, bid);
		pstmt.executeUpdate();
	}

	public void editBook(Book b) throws SQLException {
		String sql = "update bookstore set bookname=?,author=?,prize=? where bookid=?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		int bid = b.getBid();
		pstmt.setInt(4, bid);
		String bname = b.getbName();
		pstmt.setString(1, bname);
		String author = b.getAuthor();
		pstmt.setString(2, author);
		int prize = b.getPrize();
		pstmt.setInt(3, prize);
		pstmt.executeUpdate();
	}

}
