package ec.edu.ups.dao;

import java.util.List;
import java.util.Set;

import ec.edu.ups.entidad.Telefono;
import ec.edu.ups.entidad.Usuario;


/**
 * 
 * Interface GenericDAO.
 * 
 * La interface GenericDAO ha sido creada como interface con los métodos
 * genericos para realizar la persistencia en la base de datos. Dicha interface
 * será imlementada en cada clase específica que controlará la persistencia a la
 * base de datos un sistema que permite ejemplificar el uso del patrón de diseño
 * DAO usando JDBC como coexión a la misma.
 * 
 * @param <T>  la entidad o modelo que será persistida en la base de datos
 * @param <ID> el id o llave primaria por la cuál se identificara al modelo como
 *             valor único
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
