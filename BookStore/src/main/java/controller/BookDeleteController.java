package controller;

import service.BookService;
import service.BookServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/BookDelete")
public class BookDeleteController extends HttpServlet {

    BookService bookService = new BookServiceImpl();;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer idBook = Integer.parseInt(request.getParameter("bookIdDelete"));
        bookService.delete(idBook);
        response.sendRedirect(request.getContextPath()+"/BookList");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
