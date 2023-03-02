package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import Entity.MyEntity;
import com.google.gson.Gson;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jdbc.SqlCRUD;

/**
 * Servlet implementation class Servlet1
 */
@WebServlet("/Servlet1/*")
public class Servlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	LabCRUDInterface<MyEntity> crud = new SqlCRUD();

	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub

		crud = new SqlCRUD();

	}
	public void destroy() {
		try{
			((SqlCRUD) crud).getConnection().close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		setAccessControlHeaders(response);
		String mydata = new Gson().toJson(crud.read());
		PrintWriter out = response.getWriter();
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		out.print(mydata);
		out.flush();
	}

	public void doPut(HttpServletRequest request, HttpServletResponse response) throws IOException {
		setAccessControlHeaders(response);
		MyEntity ent = Helpers.Parse(request);
		response.setContentType("application/json");
		crud.update(ent.getId(), ent);
		doGet(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		setAccessControlHeaders(response);
		MyEntity watch = Helpers.Parse(request);
		crud.create(watch);
		doGet(request, response);

	}

	public void doDelete(HttpServletRequest request, HttpServletResponse response) throws IOException {
		setAccessControlHeaders(response);
		int id = Integer.parseInt(request.getPathInfo().substring(1));
		response.setContentType("application/json");
		crud.delete(id);
		doGet(request, response);
	}

	@Override
	protected void doOptions(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		setAccessControlHeaders(response);
		response.setStatus(HttpServletResponse.SC_OK);
	}

	private void setAccessControlHeaders(HttpServletResponse response) {
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "*");
		response.setHeader("Access-Control-Allow-Headers", "*");
	}
}
