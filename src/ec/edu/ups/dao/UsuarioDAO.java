/**
 * 
 */
package ec.edu.ups.dao;

import java.util.List;

import ec.edu.ups.entidad.Usuario;

/**
 * 
 * Interface UserDAO.
 * 
 * 
 * En esta interface se pueden agregar método específicos para el manejo del
 * objeto User, por ejemplo: buscarUsuarioPorName, buscarUsuarioPorCedula, entre
 * otras.
 * 
 * @author Orlando Real
 *
 */
public interface UsuarioDAO extends GenericDAO<Usuario, String> {

	/*public abstract Usuario findUser(String correo, String pass);

	public List<Usuario> findByIdOrMail(String context);

	public abstract Usuario findByCorreo(String correo);
*/
}
