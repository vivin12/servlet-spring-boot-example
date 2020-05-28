package com.example.springbootservlet.servlet;

import com.example.springbootservlet.model.Book;
import com.example.springbootservlet.repo.BookRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(urlPatterns = "/fetch", loadOnStartup = 1)
public class MySevlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Autowired
    private BookRepository bookRepository;
    private ObjectMapper Obj = new ObjectMapper();

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException{
        doGet(request,response);
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<Book> books = bookRepository.findAll();
        int rowCount = books.size();
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<h3>No of rows in DB : " + rowCount + " </h3>");

        String jsonStr = Obj.writeValueAsString(books);
        System.out.println(jsonStr);

        out.println("<h3>Data in table : " + jsonStr);
    }
}
