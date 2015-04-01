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
		
		responsePojo response=new responsePojo();
		if (action.equals("login")){
			String email = req.getParameter("email");
			String password = req.getParameter("password");

			if (email.equals("jose@frias.com")){
				pojoTest pojo = new pojoTest();
				pojo.setEmail(email);
				response.setPojo(pojo);
				response.setResult("OK");
			}else{
				response.setMessage("Solo sirve testjose");
				response.setResult("FAIL");
			}	
		}else if (action.equals("saveUser")){
			String name = req.getParameter("name");
			String email = req.getParameter("email");
			String password = req.getParameter("password");
			String confirmPwd = req.getParameter("confirmPassword");
			System.out.println(password);
			System.out.println(confirmPwd);
			
			pojoTest pojo = new pojoTest();
			pojo.setName(name);
			pojo.setEmail(email);;
			response.setPojo(pojo);
		
			if (password.equals(confirmPwd)){
				response.setResult("OK");	
				response.setMessage("Usuario guardado");
			}else{
				response.setResult("FAIL");
				response.setMessage("Contraseña y Confirmación de Contraseña no coinciden");
			}
		}
		
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
