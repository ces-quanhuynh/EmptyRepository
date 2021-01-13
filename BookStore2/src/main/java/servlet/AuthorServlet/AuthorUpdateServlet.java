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

@WebServlet("/AuthorUpdate")
public class AuthorUpdateServlet extends HttpServlet {

    AuthorService authorService = new AuthorServiceImpl();
    Integer idAuthor;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        idAuthor = Integer.parseInt(request.getParameter("authorIdUpdate"));
        String type = "AuthorUpdate";

        request.setAttribute("type",type);
        request.setAttribute("idAuthor",idAuthor);
        request.setAttribute("oldNameAuthor",authorService.getAuthorById(idAuthor).getNameAuthor());

        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/view/AuthorInsertJSP.jsp");
        dispatcher.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nameAuthor = request.getParameter("nameAuthor");

        boolean key = authorService.updateAuthor(idAuthor,new AuthorEntity(nameAuthor));

        if(key){
            response.sendRedirect("AuthorList");
        } else {
            request.setAttribute("warn","Error, try again");
            RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/view/AuthorInsertJSP.jsp");
            dispatcher.forward(request,response);
        }
    }
}
