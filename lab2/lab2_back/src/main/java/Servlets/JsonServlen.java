package Servlets;

import Crud.Lab2CrudInterface;
import Entity.MyEntity;
import com.google.gson.Gson;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serial;
import java.util.ArrayList;

@WebServlet("/servlet")
public class JsonServlen extends HttpServlet {

    private static final long serialVersionUID = 1L;
    ServletConfigInterface servletConfig;
    Lab2CrudInterface lab2Crud;

    public JsonServlen() {
        super();
        this.servletConfig = new ServletConfig();
        this.lab2Crud = servletConfig.getCrud();
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        ArrayList<MyEntity> data = new ArrayList<MyEntity>();
        data.add(lab2Crud.readEntity());

        String mydata = new Gson().toJson(data);

        PrintWriter out = response.getWriter();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        out.print(mydata);
        out.flush();
    }

    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String name = request.getParameter("name");
        String description = request.getParameter("description");
        String ImgUrl = request.getParameter("ImgUrl");
        lab2Crud.updateEntity(new MyEntity(name,description,ImgUrl));
    }

}
