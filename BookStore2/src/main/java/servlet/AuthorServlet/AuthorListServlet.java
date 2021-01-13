package servlet.AuthorServlet;

import entity.AuthorEntity;
import service.AuthorService;
import service.serviceimpl.AuthorServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/AuthorList")
public class AuthorListServlet extends HttpServlet {

    AuthorService authorService = new AuthorServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<AuthorEntity> list = authorService.getAllAuthors();
        request.setAttribute("listAuthor",list);
        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/view/AuthorViewJSP.jsp");
        dispatcher.forward(request,response);
    }
}
