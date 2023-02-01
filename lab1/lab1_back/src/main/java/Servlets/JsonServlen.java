package Servlets;

import Entity.MyEntity;
import com.google.gson.Gson;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import javax.swing.text.html.parser.Entity;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.util.ArrayList;

@WebServlet("/servlet")
public class JsonServlen extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        MyEntity entity = new MyEntity("kraken", "good sleeping bag for hiking", "assets/img/spalnik.png");

        ArrayList<MyEntity> data = new ArrayList<MyEntity>();
        data.add(entity);

        String mydata = new Gson().toJson(data);

        PrintWriter out = response.getWriter();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        out.print(mydata);
        out.flush();
    }
}
