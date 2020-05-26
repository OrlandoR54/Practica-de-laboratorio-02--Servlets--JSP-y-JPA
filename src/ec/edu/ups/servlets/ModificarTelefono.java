package ec.edu.ups.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ec.edu.ups.dao.DAOFactory;
import ec.edu.ups.dao.TelefonoDAO;
import ec.edu.ups.entidad.Telefono;
import ec.edu.ups.entidad.Usuario;

/**
 * Servlet implementation class ModificarTelefono
 */
@WebServlet("/ModificarTelefono")
public class ModificarTelefono extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ModificarTelefono() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String numero = request.getParameter("numero");
        String tipo = request.getParameter("tipo");
        String operadora = request.getParameter("operadora");
        String idTelefono = request.getParameter("tel_id");
        
        
        System.err.println("Numero tel: " + numero);
        System.err.println("tipo tel: " + tipo);
        System.err.println("Operadora tel: " + operadora);
        System.out.println("Tel ID: " + idTelefono);
        
        TelefonoDAO telefonoDAO = DAOFactory.getDAOFactory().getTelefonoDAO();
        System.out.println(telefonoDAO);
        Telefono telefono = telefonoDAO.findbyTelefonoId(Integer.parseInt(idTelefono));
        		
        System.out.println("!!!!!!!!!!!!!!!!!!!!!NUMERO DE TELEFONO " + telefono);
       
        
        
        Usuario user = DAOFactory.getDAOFactory().getUserDAO().read(String.valueOf(request.getSession().getAttribute("userID")));
        telefono.setUsuario(user);
        telefono.setNumero(numero);
        telefono.setTipo(tipo);
        telefono.setOperadora(operadora);
        telefono.setId(Integer.parseInt(idTelefono));
        System.err.println("Id TELEFONO "  + telefono);
        telefonoDAO.update(telefono);
        String url = "/Sesion?usr=" + user.getCorreo() + "&pass=" + user.getPassword();
		System.out.println("URL" + url);
		//getServletContext().getRequestDispatcher(url).forward(request, response);
		request.getRequestDispatcher(url).forward(request, response);
		//doGet(request, response);
	}

}
