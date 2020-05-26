/**
 * 
 */
package ec.edu.ups.jpa;

import java.util.Set;

import ec.edu.ups.dao.TelefonoDAO;
import ec.edu.ups.entidad.Telefono;

/**
 * @author Orlando Real
 *
 */
public class JPATelefonoDAO extends JPAGenericDAO<Telefono, String> implements TelefonoDAO{


	public JPATelefonoDAO() {
		// TODO Auto-generated constructor stub
		super(Telefono.class);
	}


	
}
