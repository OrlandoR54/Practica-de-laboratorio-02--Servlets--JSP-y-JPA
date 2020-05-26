/**
 * 
 */
package ec.edu.ups.jpa;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import javax.persistence.Query;

import ec.edu.ups.dao.GenericDAO;
import ec.edu.ups.entidad.Telefono;
import ec.edu.ups.entidad.Usuario;

/**
 * @author Orlando Real
 * @param <T>
 *
 */
public class JPAGenericDAO<T, ID> implements GenericDAO<T, ID>{

	private Class<T> persistentClass;
    protected EntityManager em;
    
	/**
	 * 
	 */
	public JPAGenericDAO(Class<T> persistentClass) {
		// TODO Auto-generated constructor stub
		this.persistentClass = persistentClass;
		this.em = Persistence.createEntityManagerFactory("jpa").createEntityManager();
	}


	@Override
	public boolean create(T entity) {
		// TODO Auto-generated method stub
		em.getTransaction().begin();
		try {
			em.persist(entity);
		    em.getTransaction().commit();
		} catch (Exception e) {
		    System.out.println(">>>> ERROR:JPAGenericDAO:create " + e);
		    if (em.getTransaction().isActive())
			em.getTransaction().rollback();
		}
		return true;
	}

	@Override
	public T read(ID id) {
		// TODO Auto-generated method stub
		System.out.println("Prueba de SQL" + em.find(persistentClass, id));
		return em.find(persistentClass, id);
	}

	@Override
	public void update(T entity) {
		// TODO Auto-generated method stub
		em.getTransaction().begin();
		try {
		    em.merge(entity);
		    em.getTransaction().commit();
		} catch (Exception e) {
		    System.out.println(">>>> ERROR:JPAGenericDAO:update " + e);
		    if (em.getTransaction().isActive())
			em.getTransaction().rollback();
		}
	}

	@Override
	public void delete(T entity) {
		// TODO Auto-generated method stub
		em.getTransaction().begin();
		try {
		    em.remove(entity);
		    em.getTransaction().commit();
		} catch (Exception e) {
		    System.out.println(">>>> ERROR:JPAGenericDAO:delete " + e);
		    if (em.getTransaction().isActive())
			em.getTransaction().rollback();
		}
	}

	@Override
	public List<T> find() {
		// TODO Auto-generated method stub
		em.getTransaction().begin();
		List<T> lista = null;
		try {
			javax.persistence.criteria.CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
			cq.select(cq.from(persistentClass));
			lista = em.createQuery(cq).getResultList();
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lista;
	}


	@Override
	public Usuario findUser(String correo, String pass) {
		// TODO Auto-generated method stub
		
		Query nativeQuery = em.createNativeQuery("SELECT * FROM Usuario where correo = ? AND password= ?", Usuario.class);
		nativeQuery.setParameter(1, correo);
		nativeQuery.setParameter(2, pass);

		return (Usuario) nativeQuery.getSingleResult();
	}


	@Override
	public List<Usuario> findByIdOrMail(String context) {
		// TODO Auto-generated method stub
		Query nativeQuery = em.createNativeQuery(
				"SELECT * FROM usuario WHERE usuario.CEDULA = ? OR usuario.CORREO = ?", Usuario.class);
		nativeQuery.setParameter(1, context);
		nativeQuery.setParameter(2, context);

		return (List<Usuario>) nativeQuery.getResultList();
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<Telefono> findByCorreo(String correo) {
		Query nativeQuery = em.createNativeQuery(
				"SELECT * FROM usuario, telefono WHERE telefono.USUARIO_CEDULA = usuario.CEDULA and usuario.CORREO = ?", Telefono.class);
		nativeQuery.setParameter(1, correo);

		return (List<Telefono>) nativeQuery.getResultList();
	}


	@Override
	public Set<Telefono> findByUserId(String cedula) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Telefono findbyTelefonoId(int tel_codigo) {
		// TODO Auto-generated method stub
		Query nativeQuery = em.createNativeQuery("SELECT * FROM Telefono where id = ? ", Telefono.class);
		nativeQuery.setParameter(1, tel_codigo);

		return  (Telefono) nativeQuery.getSingleResult();
	}

	@Override
	public Telefono findbyTelefonoNumber(String tel_number) {
		// TODO Auto-generated method stub
		Query nativeQuery = em.createNativeQuery("SELECT * FROM Telefono WHERE numero = ? ", Telefono.class);
		nativeQuery.setParameter(1, tel_number);

		return  (Telefono) nativeQuery.getSingleResult();
	}

}
