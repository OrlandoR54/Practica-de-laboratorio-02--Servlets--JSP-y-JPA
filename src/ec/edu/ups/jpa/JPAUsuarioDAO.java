/**
 * 
 */
package ec.edu.ups.jpa;

import java.util.List;

import com.mysql.cj.Query;

import ec.edu.ups.dao.UsuarioDAO;
import ec.edu.ups.entidad.Usuario;

/**
 * @author Orlando Real
 *
 */
public class JPAUsuarioDAO extends JPAGenericDAO<Usuario, String> implements UsuarioDAO{

	/**
	 * 
	 */
	public JPAUsuarioDAO() {
		// TODO Auto-generated constructor stub
		super(Usuario.class);
	}
}
