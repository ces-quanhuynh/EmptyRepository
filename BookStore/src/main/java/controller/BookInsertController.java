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
import java.util.Random;

@WebServlet("/BookInsert")
public class BookInsertController extends HttpServlet {

    BookService bookService = new BookServiceImpl();
    Integer idPresent = 3;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String type = "BookInsert";
        request.setAttribute("type",type);
        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/view/BookInsertJSP.jsp");
        dispatcher.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer idBook = ++idPresent;
        String nameBook = request.getParameter("nameBook");
        String nameAuthor = request.getParameter("nameAuthor");
        boolean key = bookService.insert(new Book(idBook,nameBook,nameAuthor));
        if(key){
            response.sendRedirect(request.getContextPath()+"/BookList");
        } else {
            request.setAttribute("warn","Book available, try again");
            RequestDispatcher dispatcher = request.getServletContext()
                    .getRequestDispatcher("/WEB-INF/view/BookInsertJSP.jsp");
            dispatcher.forward(request, response);
        }
    }
}
