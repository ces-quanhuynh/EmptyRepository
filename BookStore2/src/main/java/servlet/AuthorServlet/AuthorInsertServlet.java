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

@WebServlet("/AuthorInsert")
public class AuthorInsertServlet extends HttpServlet {

    AuthorService authorService = new AuthorServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String type = "AuthorInsert";
        request.setAttribute("type",type);

        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/view/AuthorInsertJSP.jsp");
        dispatcher.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nameAuthor = request.getParameter("nameAuthor");

        boolean key = authorService.saveAuthor(new AuthorEntity(nameAuthor));

        if(key){
            response.sendRedirect("AuthorList");
        } else {
            request.setAttribute("warn","Error, try again");
            RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/view/AuthorInsertJSP.jsp");
            dispatcher.forward(request,response);
        }
    }
}
