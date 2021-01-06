package controller;

import entities.Book;
import service.BookService;
import service.BookServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/BookList")
public class BookListController extends HttpServlet {

    private static final long serialVersionUID = 1L;
    BookService bookService = new BookServiceImpl();

    public BookListController(){
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Book> books = bookService.getAll();
        request.setAttribute("books",books);
        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/view/BookViewJSP.jsp");
        dispatcher.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.doGet(request, response);
    }
}
