package servlet.BookServlet;

import entity.AuthorEntity;
import entity.BookEntity;
import entity.TypeEntity;
import service.AuthorService;
import service.BookService;
import service.TypeService;
import service.serviceimpl.AuthorServiceImpl;
import service.serviceimpl.BookServiceImpl;
import service.serviceimpl.TypeServiceImpl;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/BookInsert")
public class BookInsertServlet extends HttpServlet {

    BookService bookService = new BookServiceImpl();
    AuthorService authorService = new AuthorServiceImpl();
    TypeService typeService = new TypeServiceImpl();
    List<TypeEntity> listType;
    List<AuthorEntity> listAuthor;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String type = "BookInsert";
        listType = typeService.getAllType();
        listAuthor = authorService.getAllAuthors();

        request.setAttribute("type",type);
        request.setAttribute("listAuthor",listAuthor);
        request.setAttribute("listType",listType);

        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/view/BookInsertJSP.jsp");
        dispatcher.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String nameBook = request.getParameter("nameBook");
        Integer idAuthor = Integer.parseInt(request.getParameter("nameAuthor"));
        Integer idType = Integer.parseInt(request.getParameter("nameType"));

        boolean key = bookService.saveBook(new BookEntity(nameBook,authorService.getAuthorById(idAuthor),
                typeService.getTypeById(idType)));

        if(key){
            response.sendRedirect("BookList");
        } else {
            request.setAttribute("warn","Error, try again");
            request.setAttribute("listAuthor",listAuthor);
            request.setAttribute("listType",listType);
            RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/view/BookInsertJSP.jsp");
            dispatcher.forward(request,response);
        }
    }

}
