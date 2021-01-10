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

@WebServlet("/BookUpdate")
public class BookUpdateController extends HttpServlet {

    BookService bookService = new BookServiceImpl();
    Integer idBook = 0;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        idBook = Integer.parseInt(request.getParameter("bookIdUpdate"));
        String type = "BookUpdate";
        request.setAttribute("type",type);
        request.setAttribute("idBook",idBook);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/BookInsertJSP.jsp");
        dispatcher.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nameBook = request.getParameter("nameBook");
        String nameAuthor = request.getParameter("nameAuthor");
        boolean key = bookService.update(idBook,nameBook,nameAuthor);
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
