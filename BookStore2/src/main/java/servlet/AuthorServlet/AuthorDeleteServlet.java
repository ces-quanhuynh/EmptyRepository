package servlet.AuthorServlet;

import entity.BookEntity;
import service.AuthorService;
import service.BookService;
import service.serviceimpl.AuthorServiceImpl;
import service.serviceimpl.BookServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/AuthorDelete")
public class AuthorDeleteServlet extends HttpServlet {

    AuthorService authorService = new AuthorServiceImpl();
    BookService bookService = new BookServiceImpl();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer idAuthor = Integer.parseInt(request.getParameter("authorIdDelete"));
        List<BookEntity> listBookOfAuthor = bookService.getAllBookByAuthor(idAuthor);
        for(BookEntity bookEntity:listBookOfAuthor){
            bookService.deleteBook(bookEntity.getIdBook());
        }
        authorService.deleteAuthor(idAuthor);
        response.sendRedirect(request.getContextPath()+"/AuthorList");
    }
}
