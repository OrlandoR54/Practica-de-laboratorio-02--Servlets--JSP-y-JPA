package ec.edu.ups.dao;

import java.util.List;
import java.util.Set;

import ec.edu.ups.entidad.Telefono;
import ec.edu.ups.entidad.Usuario;


/**
 * 
 * Interface GenericDAO.
 * 
 * La interface GenericDAO ha sido creada como interface con los m�todos
 * genericos para realizar la persistencia en la base de datos. Dicha interface
 * ser� imlementada en cada clase espec�fica que controlar� la persistencia a la
 * base de datos un sistema que permite ejemplificar el uso del patr�n de dise�o
 * DAO usando JDBC como coexi�n a la misma.
 * 
 * @param <T>  la entidad o modelo que ser� persistida en la base de datos
 * @param <ID> el id o llave primaria por la cu�l se identificara al modelo como
 *             valor �nico
 * 
 * */
public interface GenericDAO<T, ID> {

	public boolean create(T entity);

	public T read(ID id);
	
	public void update(T entity);

	public void delete(T entity);

	public List<T> find();
	
	public Usuario findUser(String correo, String pass);
	
	public List<Usuario> findByIdOrMail(String context);
	
	public Usuario findByCorreo(String correo);
	
	public Set<Telefono> findByUserId(String cedula);
	
	public Telefono findbyTelefonoId(int tel_codigo);
}
