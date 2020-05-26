package ec.edu.ups.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ec.edu.ups.dao.DAOFactory;
import ec.edu.ups.dao.UsuarioDAO;
import ec.edu.ups.entidad.Usuario;

/**
 * Servlet implementation class RegistrarUser
 */
@WebServlet("/RegistrarUser")
public class RegistrarUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrarUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String nombres = "";
		String apellidos = "";
		String cedula = "";
		String email = "";
		String password = "";
		
		nombres = request.getParameter("names").toLowerCase();
		apellidos = request.getParameter("lastnames").toLowerCase();
		cedula = request.getParameter("id");
		email = request.getParameter("email").toLowerCase();
		password = request.getParameter("password");
		
		//response.setContentType("text/html");
		//PrintWriter out = response.getWriter();
		
		UsuarioDAO usuarioDAO = DAOFactory.getDAOFactory().getUserDAO();
		
		Usuario user = new Usuario(cedula, nombres, apellidos, email, password);
		
		String page = "";
		
		
			if (usuarioDAO.create(user) == true) {
	            response.sendRedirect("Sesio");
	            //response.sendRedirect("Public/HTML/inicioSesion.html"); 
	            System.out.println("Usuario Creado");
	            System.out.println("nombres: "+ nombres +" apellidos: " + apellidos + " cedula: " + cedula + " email: " + email + " password: " + password);
	            /*out.println("<script type='text/javascript'>");
	        	out.println("alert('Usuario creado');");
	        	out.println("location='/Practica-de-laboratorio-01-Servlets-JSP-y-JDBC/Public/HTML/inicioSesion.html';");
	        	out.println("</script>");*/
	            //request.getRequestDispatcher("inicioSesion.html").forward(request, response);  
	            
	            
	           
				//getServletContext().getRequestDispatcher("/Public/HTML/incioSesion.html").forward(request, response);
			}else{
	            System.out.println("Usuario No Creado");
	            /*out.println("<script type='text/javascript'>");
	        	out.println("alert('No se pudo registrar, faltan datos');");
	        	out.println("location='/Practica-de-laboratorio-01-Servlets-JSP-y-JDBC/Public/HTML/inicioSesion.html';");
	        	out.println("</script>");
	        	
	        	out.println("<meta http-equiv='refresh' content='3;URL=index.html'>");//redirije despues de 3 segundos
	        	out.println("<p style='color:red;'>User or password incorrect!</p>");
	        	*/
	           // response.sendRedirect("inicioSesion.html");
	        }
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
