
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.book.dao.Book;
import com.book.dao.BookStoreDAO;

public class BookController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			processRequest(request, response);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			processRequest(request, response);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	private void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ClassNotFoundException, SQLException, ServletException {
		System.out.println("processRequest()");
		String userAction = request.getParameter("action");
		if (userAction.equals("addBook")) {
			response.sendRedirect("addBook.jsp");
		} else if (userAction.equals("searchBook")) {
			response.sendRedirect("searchBook.jsp");
		} else if (userAction.equals("EditBook")) {
			response.sendRedirect("editBook.jsp");
		} else if (userAction.equals("DeleteBook")) {
			response.sendRedirect("deleteBook.jsp");
		}
		if (userAction.equals("Save")) {
			addBook(request, response);
		} else if (userAction.equals("Search")) {
			searchBook(request, response);
		} else if (userAction.equals("Delete")) {
			deleteBook(request, response);
		} else if (userAction.equals("Edit")) {
			editBook(request, response);
		} else if (userAction.equals("List")) {
			listBook(request, response);
		}
	}

	private void addBook(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ClassNotFoundException, SQLException, ServletException {
		try {
			Book b = new Book();
			BookStoreDAO dao = new BookStoreDAO();
			String bname = request.getParameter("bname");
			b.setbName(bname);
			String author = request.getParameter("author");
			b.setAuthor(author);
			String prz = request.getParameter("prize");
			int prize = Integer.parseInt(prz);
			b.setPrize(prize);
			dao.addBook(b);
			response.sendRedirect("saveBook.jsp");
		} catch (ClassNotFoundException | SQLException e) {
			request.setAttribute("javax.servlet.jsp.JspException", e);
			RequestDispatcher rd = request.getRequestDispatcher("bookerror.jsp");
			rd.forward(request, response);
		}

	}

	private void searchBook(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ClassNotFoundException, SQLException, ServletException {
		try {
			BookStoreDAO dao = new BookStoreDAO();
			String bname = request.getParameter("bname");
			ArrayList al = dao.retriveBook(bname);
			request.setAttribute("list", al);
			RequestDispatcher rd = request.getRequestDispatcher("showBook.jsp");
			rd.forward(request, response);
		} catch (ClassNotFoundException | SQLException e) {
			request.setAttribute("javax.servlet.jsp.JspException", e);
			RequestDispatcher rd = request.getRequestDispatcher("bookerror.jsp");
			rd.forward(request, response);
		}

	}

	private void listBook(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ClassNotFoundException, SQLException, ServletException {
		try {
			BookStoreDAO dao = new BookStoreDAO();
			ArrayList al = dao.retriveBookList();
			System.out.println(al);
			request.setAttribute("Blist", al);
			RequestDispatcher rd = request.getRequestDispatcher("listBook.jsp");
			rd.forward(request, response);
		} catch (ClassNotFoundException | SQLException e) {
			request.setAttribute("javax.servlet.jsp.JspException", e);
			RequestDispatcher rd = request.getRequestDispatcher("bookerror.jsp");
			rd.forward(request, response);
		}
	}

	private void deleteBook(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		try {
			BookStoreDAO dao = new BookStoreDAO();
			String bId = request.getParameter("bid");
			int bid = Integer.parseInt(bId);
			dao.deleteBook(bid);
			response.sendRedirect("showDelete.jsp");
		} catch (ClassNotFoundException | SQLException e) {
			request.setAttribute("javax.servlet.jsp.JspException", e);
			RequestDispatcher rd = request.getRequestDispatcher("bookerror.jsp");
			rd.forward(request, response);
		}
	}

	private void editBook(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		try {
			Book b = new Book();
			BookStoreDAO dao = new BookStoreDAO();
			String bId = request.getParameter("bid");
			int bid = Integer.parseInt(bId);
			b.setBid(bid);
			String bname = request.getParameter("bname");
			b.setbName(bname);
			String author = request.getParameter("author");
			b.setAuthor(author);
			String pr = request.getParameter("prize");
			int prize = Integer.parseInt(pr);
			b.setPrize(prize);
			dao.editBook(b);
			response.sendRedirect("showEdit.jsp");
		} catch (ClassNotFoundException | SQLException e) {
			request.setAttribute("javax.servlet.jsp.JspException", e);
			RequestDispatcher rd = request.getRequestDispatcher("bookerror.jsp");
			rd.forward(request, response);
		}

	}

}
