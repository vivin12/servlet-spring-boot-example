package com.example.springbootservlet.servlet;

import com.example.springbootservlet.connection.DatabaseConnection;
import com.example.springbootservlet.model.Book;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = "/jdbc/fetch", loadOnStartup = 1)
public class ServletJdbc extends HttpServlet {

    private ObjectMapper Obj = new ObjectMapper();

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            Connection con = DatabaseConnection.initializeDatabase();
            Statement st = con.createStatement();

            String query = "select * from books";
            ResultSet result = st.executeQuery(query);

            List<Book> books = new ArrayList<>();

            while (result.next()) {
                int bookId = result.getInt("book_id");
                String bookName = result.getString("book_name");

                Book book = new Book ();
                book.setBookId(bookId);
                book.setBookName(bookName);
                books.add(book);
            }

            String jsonStr = Obj.writeValueAsString(books);

            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.println("<h3>No of rows in DB : " + books.size()  + " </h3>");
            out.println("<h3>Data in table : " + jsonStr);
            st.close();
            con.close();
        } catch (Exception ex) {
            System.out.println("Exception occurred" + ex);
        }
    }
}


