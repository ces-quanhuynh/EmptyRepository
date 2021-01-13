package servlet.BookServlet;

import service.BookService;
import service.serviceimpl.BookServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/BookDelete")
public class BookDeleteServlet extends HttpServlet {

    BookService bookService = new BookServiceImpl();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.parseInt(request.getParameter("bookIdDelete"));
        bookService.deleteBook(id);
        response.sendRedirect(request.getContextPath()+"/BookList");
    }
}
