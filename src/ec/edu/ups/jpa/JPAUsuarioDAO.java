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

/*	
	@Override
	public Usuario findUser(String correo, String pass) {
		// TODO Auto-generated method stub
		Query nativeQuery = em.createNativeQuery("SELECT * FROM Usuario where correo =? AND pwd=?", Usuario.class);
		((javax.persistence.Query) nativeQuery).setParameter(1, correo);
		((javax.persistence.Query) nativeQuery).setParameter(2, pass);
		
		return (Usuario) ((javax.persistence.Query) nativeQuery).getSingleResult();
	}

	@Override
	public List<Usuario> findByIdOrMail(String context) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Usuario findByCorreo(String correo) {
		// TODO Auto-generated method stub
		return null;
	}
	*/
}
