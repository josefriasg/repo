package prueba2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

public class PruebaServlet extends HttpServlet{

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String action = req.getParameter("action");
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		responsePojo response=new responsePojo();
		if (username.equals("testjose")){
			pojoTest pojo = new pojoTest();
			pojo.setPassword(password);
			pojo.setUsername(username);
			response.setPojo(pojo);
			response.setResult("OK");
		}else{
			response.setMessage("Usuario invalido, sólo testjose");
			response.setResult("FAIL");
		}
		System.out.println("Llego get:"+action);
		JSONObject obj = new JSONObject(response);
		resp.setContentType("application/Json");
        PrintWriter out = resp.getWriter();
        out.print(obj.toString());
        out.flush();
        out.close();
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String action = req.getParameter("action");
		System.out.println("Llego post:"+action);
	}

}
