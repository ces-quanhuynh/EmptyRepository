package servlet.BookServlet;

import entity.BookEntity;
import service.BookService;
import service.serviceimpl.BookServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/BookList")
public class BookListServlet extends HttpServlet {

    BookService bookService = new BookServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<BookEntity> listBook = bookService.getAllBook();
        request.setAttribute("listBook",listBook);

        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/view/BookViewJSP.jsp");
        dispatcher.forward(request,response);
    }
}
